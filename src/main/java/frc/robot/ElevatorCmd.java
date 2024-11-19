package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

public class ElevatorCmd extends Command {
    
    public PneumaticSys m_PneumoSys;
    public Joystick joy;

    public ElevatorCmd(PneumaticSys m_PneumoSys, Joystick joy) {
        this.m_PneumoSys = m_PneumoSys;
        this.joy = joy;

        addRequirements(m_PneumoSys);
    }

    @Override
    public void execute() {
        if (joy.getRawButton(2)) {
            m_PneumoSys.Suspend();
        }

        if (joy.getRawButton(1)) {
            m_PneumoSys.Descend();
        }

        if (joy.getRawButton(3)) {
            m_PneumoSys.ClawOpen();
        }

        if (joy.getRawButton(4)) {
            m_PneumoSys.ClawClose();
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_PneumoSys.Stop();
    }
}
