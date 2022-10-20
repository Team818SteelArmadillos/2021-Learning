// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Constants;

public class ShooterCommand extends CommandBase {
  private double rpm;
  PIDController ShootPID;


  double ShooterMotorspeed;
  /** Creates a new ShooterCommand. */
  public ShooterCommand() {
    rpm = 0;
    ShootPID = new PIDController(Constants.p, Constants.i, Constants.d);
    ShootPID.setTolerance(10);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   SmartDashboard.putNumber("Set Shooter speed", 0);
   Robot.m_ShooterSubsystem.setPower(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    rpm = SmartDashboard.getNumber("Set Shooter speed", 0);

    if(Robot.m_oi.getBButton()){
      double shooterPower = ShootPID.calculate(rpm - Robot.m_ShooterSubsystem.getCurrentShooterSpeed());
      SmartDashboard.putNumber("Shooter Power", shooterPower);
      Robot.m_ShooterSubsystem.setPower(shooterPower);
    } else {
      Robot.m_ShooterSubsystem.setPower(0);
    }
    SmartDashboard.putNumber("current shooter rpm", Robot.m_ShooterSubsystem.getCurrentShooterSpeed());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_ShooterSubsystem.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
