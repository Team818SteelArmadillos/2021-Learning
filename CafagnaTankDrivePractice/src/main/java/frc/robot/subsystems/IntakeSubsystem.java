// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.IntakeCommand;

public class IntakeSubsystem extends SubsystemBase {
  VictorSPX IntakeMotor;
  /** Creates a new IntakeSubsystem. */

  public IntakeSubsystem() {
    IntakeMotor = new VictorSPX(Constants.INTAKE_PORT);
    IntakeMotor.configFactoryDefault();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setIntake(double power) {
 IntakeMotor.set(ControlMode.PercentOutput, power);
  }
}
