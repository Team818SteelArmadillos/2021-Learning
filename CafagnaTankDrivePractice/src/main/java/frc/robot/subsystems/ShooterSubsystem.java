// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class ShooterSubsystem extends SubsystemBase {

  public Victor victor1, victor2, victor3;
  public Talon talon1;
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    victor1 = new Victor(Robot.m_ShooterCommand);
  }
}
