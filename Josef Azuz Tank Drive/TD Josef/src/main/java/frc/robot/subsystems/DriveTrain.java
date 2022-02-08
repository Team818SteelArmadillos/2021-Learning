// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  public DriveTrain() {}
private static Talon leftMotors = new Talon(Constants.LEFT_MOTOR_PORT);
private static Talon rightMotors = new Talon(Constants.RIGHT_MOTOR_PORT);

public static void SetMotors(double leftSpeed, double rightSpeed){
  leftMotors.set(leftSpeed);
  rightMotors.set(rightSpeed);
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
