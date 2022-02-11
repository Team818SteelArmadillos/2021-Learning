// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutonCommand extends CommandBase {
  
  private final DriveSubsystem m_subsystem;
  private Timer m_timer;
  /** Creates a new AutonCommand. */
  public AutonCommand(DriveSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_subsystem = subsystem;
    m_timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    m_subsystem.setBothMotors(0);
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    m_subsystem.setBothMotors(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    m_subsystem.setBothMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return m_timer.hasElapsed(3);
  }
}
