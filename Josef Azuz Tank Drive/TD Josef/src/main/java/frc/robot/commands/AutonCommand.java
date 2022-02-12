package frc.robot.commands;

import org.ejml.equation.ManagerFunctions.Input1;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.InputOI;
import frc.robot.subsystems.DriveTrain;

public class AutonCommand extends CommandBase {
  private double leftSpeed;
  private double rightSpeed;
  Timer autonTimer = new Timer();

  /** Creates a new DriveTrainCommand. */
  public AutonCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriveTrain.SetMotors(0,0);

    autonTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    leftSpeed = (.25);
    rightSpeed = (.25);
    
    DriveTrain.SetMotors(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveTrain.SetMotors(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return autonTimer.hasElapsed(4);
  }
}
