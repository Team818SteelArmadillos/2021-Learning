// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


public class Drivedistance extends CommandBase {
  /** Creates a new Drivedistance. */
  private Timer timer;
  public Drivedistance() {
    // Use addRequirements() here to declare subsystem dependencies.
  timer = new Timer();



  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.driveTrain.setBothMotors(.3);
    timer.reset();
    timer.start();
    
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.driveTrain.setBothMotors(0);
    timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.hasElapsed(5);
  }
}
