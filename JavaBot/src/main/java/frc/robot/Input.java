// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Input extends SubsystemBase {
  
  private XboxController Controller = new XboxController(Constants.XBOX_PORT);
  private Joystick joyLeft = new Joystick(Constants.JOYSTICK_PORT_LEFT);
  private Joystick joyRight = new Joystick(Constants.JOYSTICK_PORT_RIGHT);
  
  public double getJoystickLeftY()
  {
    return (Math.abs(joyLeft.getY()) < Constants.JOYSTICK_LEFT_DEADZONE_Y ? 0: joyLeft.getY());
  }
  
  public double getJoystickRightY()
  {
   return (Math.abs(joyRight.getY()) < Constants.JOYSTICK_RIGHT_DEADZONE_Y ? 0: joyRight.getY());
  }

  public boolean GetButtonA() 
  {
    return Controller.getAButton();
  }

  public boolean GetButtonB() 
  {
    return Controller.getBButton();
  }

  public boolean GetRightBumperPressed()
  {
    return Controller.getRightBumperPressed();
  }

  public boolean GetLeftBumperPressed() {
    return Controller.getLeftBumperPressed();
  }

  /** Creates a new Input. */
  public Input() {}

}
