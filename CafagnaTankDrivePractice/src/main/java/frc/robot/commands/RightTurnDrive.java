// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class RightTurnDrive extends CommandBase {
  DriveTrain rightTurnDriveTrain;
  public  double Angle;
  /** Creates a new DistanceDrive. */
  public RightTurnDrive(double angle)  {
    Angle = angle;

    // anlge is not defined... Angle = angle;

    rightTurnDriveTrain = new DriveTrain();
    addRequirements(rightTurnDriveTrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    rightTurnDriveTrain.setBothMotors(0);
    rightTurnDriveTrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   rightTurnDriveTrain.setRightMotors(-0.3);
    rightTurnDriveTrain.setLeftMotors(0.3);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    rightTurnDriveTrain.setBothMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return rightTurnDriveTrain.getLeftDistance() > -1 * Angle * Math.PI;
  }
}
