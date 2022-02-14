package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.motors;
import frc.robot.subsystems.oi;

public class auton3Secs extends CommandBase {
    motors MotorSubsystem = new motors();
    oi oiSubsystem = new oi();
    Timer timer = new Timer();
      /** Creates a new motorSpeed. */
  public auton3Secs() {
    // Use addRequirements() here to declare subsystem dependencies.
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }
    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    MotorSubsystem.SetLeftMotors(0.25);
    MotorSubsystem.SetRightMotors(0.25); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
    MotorSubsystem.SetLeftMotors(0);
    MotorSubsystem.SetRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() > 3;
  }

}
