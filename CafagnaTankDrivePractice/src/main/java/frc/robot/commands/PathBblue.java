// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.TurnDrive;
import frc.robot.commands.RightTurnDrive;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PathBblue extends SequentialCommandGroup {

  /** Creates a new Sequenceturndrive. */
  DriveTrain drive = new DriveTrain();

  public PathBblue() {
    drive.resetEncoders();
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());

    //If box is too small, it will turn instead of moving forward
    //addCommands(new DistanceDrive(34), new TurnDrive(9.45), new DistanceDrive(34), new TurnDrive(9.45), new DistanceDrive(34), new TurnDrive(9.45), new DistanceDrive(34), new TurnDrive(9.45));
    
    //Box is twice as big
    addCommands(new DistanceDrive(150), new TurnDrive(4.25), new DistanceDrive(84.8528), new TurnDrive(28.5), new DistanceDrive(84.8528), new TurnDrive(4.25), new DistanceDrive(30));
  }
}
