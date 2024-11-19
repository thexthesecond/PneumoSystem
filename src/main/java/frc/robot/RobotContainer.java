// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class RobotContainer {

  public Joystick joy = new Joystick(0);
  public PneumaticSys m_PneumaticSys = new PneumaticSys();

  public ElevatorCmd elevatorCmd;

  public RobotContainer() {
    elevatorCmd = new ElevatorCmd(m_PneumaticSys, joy);

    configureBindings();
  }

  private void configureBindings() {
    m_PneumaticSys.setDefaultCommand(elevatorCmd);
  }
}
