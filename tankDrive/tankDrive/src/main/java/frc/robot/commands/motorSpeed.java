// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.motors;
import frc.robot.subsystems.oi;

public class motorSpeed extends CommandBase {
  motors MotorSubsystem = new motors();
  oi oiSubsystem = new oi();
  /** Creates a new motorSpeed. */
  public motorSpeed() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    MotorSubsystem.SetLeftMotors(oiSubsystem.getleftStickY());
    MotorSubsystem.SetRightMotors(oiSubsystem.getrightStickY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    MotorSubsystem.SetLeftMotors(0);
    MotorSubsystem.SetRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
