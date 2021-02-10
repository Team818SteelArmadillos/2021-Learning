// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class DistanceDrive extends CommandBase {
  DriveTrain distanceDriveTrain;
  /** Creates a new DistanceDrive. */
  public DistanceDrive() {
    distanceDriveTrain = new DriveTrain();
    addRequirements(distanceDriveTrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    distanceDriveTrain.setBothMotors(0);
    distanceDriveTrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    distanceDriveTrain.setBothMotors(0.3);
    distanceDriveTrain.getDistance();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    distanceDriveTrain.setBothMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return distanceDriveTrain.getDistance() > 1;
  }
}
