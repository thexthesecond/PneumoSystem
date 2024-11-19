package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticSys extends SubsystemBase {
    
    public DoubleSolenoid SuspenSoid = 
            new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

    public Solenoid clawSoid = new Solenoid(PneumaticsModuleType.CTREPCM, 3);

    String SuspenStatus;
    String ClawStatus;

    public PneumaticSys() {
        SuspenStatus = "Contraído";
        ClawStatus = "Fechada";
        Descend();
        ClawClose();
    }

    public void ClawOpen() {
        ClawStatus = "Aberta";
        clawSoid.set(true);
    }

    public void ClawClose() {
        ClawStatus = "Fechada";
        clawSoid.set(true);
    }

    public void Suspend() {
        SuspenStatus = "Acima";
        SuspenSoid.set(Value.kForward);
    }

    public void Descend() {
        SuspenStatus = "Abaixo";
        SuspenSoid.set(Value.kReverse);
    }

    public void Stop() {
        SuspenStatus = "Desativado";
        SuspenSoid.set(Value.kOff);
        clawSoid.set(false);
    }

    @Override
    public void periodic() {
        SmartDashboard.putString("Status da suspensão", SuspenStatus);
        SmartDashboard.putString("Status da garra", ClawStatus);
    }
}
