package frc.robot.commands;


import frc.robot.Input;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {
  
    private final DriveSubsystem m_subsystem;
    private final Input m_input = new Input();
    private float m_speed = 0.0f;

    public DriveCommand(DriveSubsystem subsystem) {
      m_subsystem = subsystem;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() 
    {
      m_subsystem.setBothMotors(0);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
      m_subsystem.setRightMotor(m_input.getJoystickRightY());
      m_subsystem.setLeftMotor(m_input.getJoystickLeftY());
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) 
    {
      m_subsystem.setBothMotors(0);
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
