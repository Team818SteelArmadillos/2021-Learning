// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.OI;

public class TankDriveCommand extends CommandBase {
  /** Creates a new DriveTrain. */
  DriveSubsystem driveTrain = new DriveSubsystem();
  OI m_oi = new OI();
public TankDriveCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveSubsystem.setLeftMotors(0);
    driveSubsystem.setRightMotors(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.setLeftMotors(m_oi.getJoystickLeftY()); 
    driveSubsystem.setRightMotors(m_oi.getJoystickRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.setLeftMotors(0); 
    driveSubsystem.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
