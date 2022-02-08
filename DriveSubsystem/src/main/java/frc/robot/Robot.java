package frc.robot; 
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

  import edu.wpi.first.wpilibj.Sendable;
  import edu.wpi.first.wpilibj.TimedRobot;
  import edu.wpi.first.wpilibj.command.Scheduler;
  import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
  import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
  import edu.wpi.first.wpilibj2.command.CommandScheduler;
  import frc.robot.subsystems.DriveTrain;
  import frc.robot.subsystems.OI;
  import frc.robot.subsystems.ShooterSubsystem;
  import frc.robot.subsystems.IntakeSubsystem;
  import frc.robot.commands.IntakeCommand;
  import frc.robot.commands.ShooterCommand;


 /** * The VM is configured to automatically run this class, and to call the functions corresponding to 
* each mode, as described in the TimedRobot documentation. If you change the name of this class or 
* the package after creating this project, you must also update the build.gradle file in the 
* project. 
*/
public class Robot extends TimedRobot { 
  public static DriveTrain driveTrain = new DriveTrain(); 
  public static OI m_oi = new OI(); 
  public static IntakeSubsystem m_IntakeSubsystem = new IntakeSubsystem(); 
  public static IntakeCommand m_IntakeCommand; 
  public static ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem(); 
  public static ShooterCommand m_ShooterCommand; 
  public static TankDriveCommand m_TankDriveCommand;
/** * This function is run when the robot is first started up and should be used for any 
* initialization code. 
*/ 

  @Override 
  public void robotInit() { 
  // Instantiate our RobotContainer. This will perform all our button bindings, and put our 
  // autonomous chooser on the dashboard. 

    m_IntakeCommand = new IntakeCommand(); 
    m_ShooterCommand = new ShooterCommand(); 
    m_TankDriveCommand = new TankDriveCommand();
} 

/** 
* This function is called every robot packet, no matter the mode. Use this for items like 
* diagnostics that you want ran during disabled, autonomous, teleoperated and test. 
* 
* <p>This runs after the mode specific periodic functions, but before LiveWindow and 
* SmartDashboard integrated updating. 
*/ 
@Override 
public void robotPeriodic() { 

// Runs the Scheduler. This is responsible for polling buttons, adding newly-scheduled 
// commands, running already-scheduled commands, removing finished or interrupted commands, 
// and running subsystem periodic() methods. This must be called from the robot's periodic 
// block in order for anything in the Command-based framework to work. 

CommandScheduler.getInstance().run(); } 
/** This function is called once each time the robot enters Disabled mode. */ 

@Override 
public void disabledInit() {} 

@Override 
public void disabledPeriodic() {} 

/** This function is called periodically during operator control. */ 

@Override public void teleopPeriodic() { 
  Scheduler.getInstance().run();  
} 

@Override 
public void teleopInit() { 
  m_ShooterCommand.schedule(); 
  m_IntakeCommand.schedule(); 
  m_TankDriveCommand.schedule();
} 

@Override 
public void autonomousInit() {} 

/** This function is called periodically during autonomous. */ 

@Override 
public void autonomousPeriodic() { 
  SmartDashboard.putNumber("Velocity (ft.s)", driveTrain.getVelocity()); 
  SmartDashboard.putNumber("Distance Traveled (in)", driveTrain.getDistance()); 
  SmartDashboard.putNumber("Left Distance Traveled (in)", driveTrain.getLeftDistance()); 
} 

@Override 
public void testInit() { 
  // Cancels all running commands at the start of test mode.
  CommandScheduler.getInstance().cancelAll(); 
} 

/** This function is called periodically during test mode. */ 
@Override 
  public void testPeriodic() {}
}
/** Add your docs here. */
public class Robot {}