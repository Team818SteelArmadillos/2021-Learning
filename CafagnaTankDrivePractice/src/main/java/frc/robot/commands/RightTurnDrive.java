// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


public class RightTurnDrive extends CommandBase {
  public  double Angle;
  /** Creates a new DistanceDrive. */
  public RightTurnDrive(double angle) {
    Angle = angle;
    addRequirements(Robot.m_driveSubsystem);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_driveSubsystem.setBothMotors(0);
    Robot.m_driveSubsystem.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.m_driveSubsystem.setRightMotors(-0.3);
    Robot.m_driveSubsystem.setLeftMotors(0.3);
    Robot.m_driveSubsystem.getRightDistance();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_driveSubsystem.setBothMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Robot.m_driveSubsystem.getRightDistance() > Angle * 36 * Math.PI / 360;
  }
}
