// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutonDrive extends CommandBase {
  
  private final DriveSubsystem m_subsystem;
  private Timer m_Timer;
  private final float m_speed;
  private final float m_length;

  /** Creates a new AutonCommand. */
  public AutonDrive(DriveSubsystem subsystem, float speed, float length) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_subsystem = subsystem;
    m_Timer = new Timer();
    m_speed = speed;
    m_length = length;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    m_subsystem.setBothMotors(m_speed);
    m_Timer.reset();
    m_Timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    m_subsystem.setBothMotors(0);
    m_Timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return m_Timer.hasElapsed(m_length);
  }
}
