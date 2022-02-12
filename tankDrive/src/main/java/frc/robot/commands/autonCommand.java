// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.sql.Time;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.driveSubsystem;

public class autonCommand extends CommandBase {
  public static double x = .25;
  autonCommand driveSub = new autonCommand();
  OI joyInput = new OI();
  Timer autonTimer = new Timer();
  /** Creates a new driveCommand. */
  public autonCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_drivesubsystem.setBothMotors(0);
    autonTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.m_drivesubsystem.setRightMotors(x);
    Robot.m_drivesubsystem.setLeftMotors(x);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
 Robot.m_drivesubsystem.setBothMotors(0);
 autonTimer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return autonTimer.hasElapsed(3);
  }
}