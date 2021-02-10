// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TimeDrive extends CommandBase {
  DriveTrain autonDriveTrain;
  Timer autonTimer; 
  /** Creates a new TimeDrive. */
  public TimeDrive() {
    autonDriveTrain = new DriveTrain();
    autonTimer = new Timer();
    addRequirements(autonDriveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    autonDriveTrain.setBothMotors(0);
    autonTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    autonDriveTrain.setBothMotors(0.3);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    autonDriveTrain.setBothMotors(0);
    autonTimer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return autonTimer.hasElapsed(2);
  }
}
