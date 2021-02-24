// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.TurnDrive;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FigureEightDrive extends SequentialCommandGroup {

  /** Creates a new FigureEightDrive. */
  DriveTrain drive = new DriveTrain();

  public FigureEightDrive() {
    drive.resetEncoders();
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    //Isn't finsihed yet...
    addCommands(new DistanceDrive(60), new TurnDrive(28.5), new DistanceDrive(36), new TurnDrive(28.5), new DistanceDrive(72), new TurnDrive(28.5), new DistanceDrive(72), new TurnDrive(28.5), new DistanceDrive(72), new TurnDrive(19), new DistanceDrive(180), new TurnDrive(9.5), new DistanceDrive(72), new TurnDrive(9.5), new DistanceDrive(72), new TurnDrive(9.5), new DistanceDrive(72), new TurnDrive(28.5), new DistanceDrive(72));
  }
}
