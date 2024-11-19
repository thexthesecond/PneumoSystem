package frc.robot;

import java.sql.Time;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticSys extends SubsystemBase {
    
    public DoubleSolenoid SuspenSoid_R = 
            new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

    public DoubleSolenoid SuspenSoid_L = 
            new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

    public Solenoid clawSoid = new Solenoid(PneumaticsModuleType.CTREPCM, 4);

    public Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);

    Supplier<String> SuspenStatus = () -> "Contraído";
    Supplier<String> ClawStatus = () -> "Fechada";

    public PneumaticSys() {
        SuspenStatus = () -> "Contraído";
        ClawStatus = () -> "Fechada";
        Descend();
        ClawOpen();
    }

    public void ClawOpen() {
        ClawStatus = () -> "Aberta";
        clawSoid.set(true);
    }

    public void ClawClose() {
        ClawStatus = () -> "Fechada";
        clawSoid.set(true);
    }

    public void Suspend() {
        SuspenStatus= () -> "Retraido";
        SuspenSoid_L.set(Value.kForward);
        SuspenSoid_R.set(Value.kForward);
    }

    public void Descend() {
        SuspenStatus= () -> "Contraido";
        SuspenSoid_L.set(Value.kReverse);
        SuspenSoid_R.set(Value.kReverse);
    }

    public void Stop() {
        SuspenStatus= () -> "Desativado";
        SuspenSoid_L.set(Value.kOff);
        SuspenSoid_L.set(Value.kOff);
    }

    @Override
    public void periodic() {
        SmartDashboard.putString("Status do cilindro", SuspenStatus.get());
        SmartDashboard.putString("Status da garra", ClawStatus.get());
    }
}
