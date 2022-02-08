// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  public DriveTrain() {}
private static TalonSRX leftMotors = new TalonSRX(Constants.LEFT_MOTOR_PORT);
private static VictorSPX leftVictor = new VictorSPX(Constants.LEFT_VICTOR_PORT);
private static TalonSRX rightMotors = new TalonSRX(Constants.RIGHT_MOTOR_PORT);
private static VictorSPX rightVictor = new VictorSPX(Constants.RIGHT_VICTOR_PORT);

public static void SetMotors(double leftSpeed, double rightSpeed){
  leftMotors.set(ControlMode.PercentOutput,-leftSpeed);
  leftVictor.set(ControlMode.PercentOutput,-leftSpeed);
rightMotors.set(ControlMode.PercentOutput,rightSpeed);
rightVictor.set(ControlMode.PercentOutput,rightSpeed);
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
