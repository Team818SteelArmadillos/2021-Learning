// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;

public class InputOI extends SubsystemBase {
  /** Creates a new InputOI. */

  XboxController controller = new XboxController(0);
  static Joystick leftJoystick = new Joystick(0);
  static Joystick rightJoystick = new Joystick(1);

  public static double getJoystickleftY() {
    return (Math.abs(leftJoystick.getY()) <0.02 ? 0: leftJoystick.getY());

  }

  public static double getJoystickrightY() {
    return (Math.abs(rightJoystick.getY()) <0.02 ? 0: rightJoystick.getY());
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
