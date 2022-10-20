// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */

  public IntakeCommand() {
    addRequirements(Robot.m_IntakeSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  Robot.m_IntakeSubsystem.setIntake(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.m_oi.getAButton()) {
      Robot.m_IntakeSubsystem.setIntake(1);
    } else if (Robot.m_oi.getXButton()) {
      Robot.m_IntakeSubsystem.setIntake(-1);
    } else {
      Robot.m_IntakeSubsystem.setIntake(0);
    }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_IntakeSubsystem.setIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
