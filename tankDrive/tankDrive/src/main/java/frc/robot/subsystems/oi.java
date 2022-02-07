// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class oi extends SubsystemBase {
  Joystick leftStick = new Joystick(Constants.JOYSTICK_PORT_LEFT);
  Joystick rightStick = new Joystick(Constants.JOYSTICK_PORT_RIGHT);
  /** Creates a new oi. */
  public oi() {}

  public double getleftStickY() {
    return (Math.abs(leftStick.getY()) < Constants.JOYSTICK_LEFT_DEADZONE_Y ? 0: leftStick.getY());
  }

  public double getrightStickY() {
    return (Math.abs(rightStick.getY()) < Constants.JOYSTICK_RIGHT_DEADZONE_Y ? 0: rightStick.getY());
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
