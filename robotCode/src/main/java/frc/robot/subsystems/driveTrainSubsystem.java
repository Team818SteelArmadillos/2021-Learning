// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class driveTrainSubsystem extends SubsystemBase {
  /** Creates a new driveTrainSubsystem. */
  private static TalonSRX leftMotors = new TalonSRX(Constants.LEFT_MOTOR_PORT);
  private static TalonSRX rightMotors = new TalonSRX(Constants.RIGHT_MOTOR_PORT);
  private static VictorSPX leftMotors1 = new VictorSPX(Constants.LEFT_MOTOR_PORT1);
  private static VictorSPX rightMotors1 = new VictorSPX(Constants.RIGHT_MOTOR_PORT1);

  public static void SetMotors(double leftSpeed, double rightSpeed){
    leftMotors.set(ControlMode.PercentOutput,-leftSpeed);
    rightMotors.set(ControlMode.PercentOutput,rightSpeed);
    leftMotors1.set(ControlMode.PercentOutput,-leftSpeed);
    rightMotors1.set(ControlMode.PercentOutput,rightSpeed);
  }

  public driveTrainSubsystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
