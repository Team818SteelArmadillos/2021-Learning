// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.ejml.equation.ManagerFunctions.Input1;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.InputOI;
import frc.robot.subsystems.DriveTrain;

public class DriveTrainCommand extends CommandBase {
  private double leftSpeed;
  private double rightSpeed;

  /** Creates a new DriveTrainCommand. */
  public DriveTrainCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriveTrain.SetMotors(0,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    leftSpeed = InputOI.getJoystickleftY();
    rightSpeed = InputOI.getJoystickrightY();
    
    DriveTrain.SetMotors(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveTrain.SetMotors(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
