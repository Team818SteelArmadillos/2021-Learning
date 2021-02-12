// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class StationaryTurnDrive extends CommandBase {
  DriveTrain stationaryturnDriveTrain;
  /** Creates a new DistanceDrive. */
  public StationaryTurnDrive() {
    stationaryturnDriveTrain = new DriveTrain();
    addRequirements(stationaryturnDriveTrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    stationaryturnDriveTrain.setBothMotors(0);
    stationaryturnDriveTrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    stationaryturnDriveTrain.setRightMotors(0);
    stationaryturnDriveTrain.setLeftMotors(-0.3);
    stationaryturnDriveTrain.getLeftDistance();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    stationaryturnDriveTrain.setBothMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return stationaryturnDriveTrain.getLeftDistance() > 42.5 * 2 * Math.PI;
  }
}
