// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot;
 
import javax.sound.midi.Sequence;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.BallBoxDrive;
import frc.robot.commands.DistanceDrive;
import frc.robot.commands.FigureEightDrive;
import frc.robot.commands.PathBRed;
import frc.robot.commands.PathBRed;
import frc.robot.commands.Sequenceturndrive;
import frc.robot.commands.StationaryTurnDrive;
import frc.robot.commands.TimeDrive;
import frc.robot.commands.TurnDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.OI;
import frc.robot.commands.RightTurnDrive;
import frc.robot.commands.PathBblue;
 
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveTrain driveTrain = new DriveTrain();
  public static OI m_oi = new OI();
  
 
  private RobotContainer m_robotContainer;

  public static DriveTrain m_driveSubsystem;
 
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    m_driveSubsystem = new DriveTrain();
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
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }
 
  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}
 
  @Override
  public void disabledPeriodic() {}
 
 
 
  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    driveTrain.setLeftMotors(m_oi.getJoystickLeftY());
    driveTrain.setRightMotors(m_oi.getJoystickRightY());
 
    //SmartDashboard.putNumber("Velocity (ft.s)", driveTrain.getVelocity());
    //SmartDashboard.putNumber("Distance Traveled (in)", driveTrain.getDistance());
  }

  @Override
  public void autonomousInit() {
    //TurnDrive autonCommand = new TurnDrive(0);
    //DistanceDrive autonDrive = new DistanceDrive(0);
    driveTrain.resetEncoders();
    // schedule the autonomous command (example)
    PathBRed autonsequence = new PathBRed();
    if (autonsequence != null) {
      autonsequence.schedule();
            
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    SmartDashboard.putNumber("Velocity (ft.s)", driveTrain.getVelocity());
    SmartDashboard.putNumber("Distance Traveled (in)", driveTrain.getDistance());
    SmartDashboard.putNumber("Left Distance Traveled (in)", driveTrain.getLeftDistance());
    SmartDashboard.putNumber("Right Distance Traveled (in)", driveTrain.getRightDistance());
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
 

