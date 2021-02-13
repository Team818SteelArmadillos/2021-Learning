// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class RightTurnDrive extends CommandBase {
  DriveTrain turnDriveTrain;
  public  double Angle;
  /** Creates a new DistanceDrive. */
  public RightTurnDrive(double angle) {
    Angle = angle;
    turnDriveTrain = new DriveTrain();
    addRequirements(turnDriveTrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    turnDriveTrain.setBothMotors(0);
    turnDriveTrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turnDriveTrain.setRightMotors(-0.3);
    turnDriveTrain.setLeftMotors(0.3);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    turnDriveTrain.setBothMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return turnDriveTrain.getRightDistance() > Angle * Math.PI;
  }
}
