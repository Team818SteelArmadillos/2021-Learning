

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  public static DriveTrain driveTrain = new DriveTrain();
  public static OI m_oi; 

  @Override
  public void robotInit() {
  
  }

 
  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();
  }


  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {


 

    }



  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {

   
    }
  

 
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    driveTrain.setLeftMotors(m_oi.getJoystickLeftY());
    driveTrain.setRightMotors(m_oi.getJoystickLeftY());

    SmartDashboard.putNumber("Velocity (ft.s)", driveTrain.getVelocity());
    SmartDashboard.putNumber("Distance Traveled (in", driveTrain.getDistance());
  }

  @Override
  public void testInit() {
  
    CommandScheduler.getInstance().cancelAll();
  }


  @Override
  public void testPeriodic() {}
}
