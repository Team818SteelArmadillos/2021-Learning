// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
 
public class OI extends SubsystemBase {
 XboxController controller = new XboxController(Constants.XBOX_PORT);
 Joystick joyLeft = new Joystick(Constants.JOYSTICK_PORT_LEFT);
 Joystick joyRight = new Joystick(Constants.JOYSTICK_PORT_RIGHT);
 //sets joysticks with port
 
 
 public double getJoystickLeftY(){
   return (Math.abs(joyLeft.getY()) < Constants.JOYSTICK_LEFT_DEADZONE_Y ? 0: joyLeft.getY());
 }
 //idk
 
 public double getJoystickRightY(){
  return (Math.abs(joyRight.getY()) < Constants.JOYSTICK_RIGHT_DEADZONE_Y ? 0: joyRight.getY());
 }
 //idk

 public boolean getXButton() {
return controller.getXButton();
 }
//checks if button is being pressed

 public boolean getAButton() {
  return controller.getAButton(); 
 }
//checks if button is being pressed

 public boolean getBButton() {
   return controller.getBButton();
 }
//checks if button is being pressed

  public OI() {}
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
