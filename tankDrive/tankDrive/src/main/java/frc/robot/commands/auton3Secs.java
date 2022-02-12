package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.motors;
import frc.robot.subsystems.oi;

public class auton3Secs extends CommandBase {
    motors MotorSubsystem = new motors();
    oi oiSubsystem = new oi();
      /** Creates a new motorSpeed. */
  public auton3Secs() {
    // Use addRequirements() here to declare subsystem dependencies.
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    long start = System.currentTimeMillis();
    long end = start + 3*1000;
    while (System.currentTimeMillis() < end) {
        MotorSubsystem.SetLeftMotors(0.25);
        MotorSubsystem.SetRightMotors(0.25); 
    }
    MotorSubsystem.SetLeftMotors(0);
    MotorSubsystem.SetRightMotors(0);
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
