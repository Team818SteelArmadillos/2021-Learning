// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveSubsystem;

public class autoCMD extends CommandBase {
  /** Creates a new driveTrainCMD. */
  private double leftSpeed;
  private double rightSpeed;
  
  public float leftInput;
  public float rightInput;
  
  private Timer timer = new Timer();
  
  public autoCMD() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveSubsystem.SetMotors(0,0);
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    leftSpeed = 0.3;
    rightSpeed = 0.3;
    
    driveSubsystem.SetMotors(leftSpeed, rightSpeed);

    if(timer.get()>= 3){
      leftSpeed = 0f;
      rightSpeed = 0f;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get()>=3;
  }
}
