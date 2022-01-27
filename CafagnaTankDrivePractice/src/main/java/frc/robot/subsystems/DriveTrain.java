// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.subsystems;
 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
 
public class DriveTrain extends SubsystemBase {
  private TalonSRX talonLeft, talonRight;
  private VictorSPX[] victorsLeft, victorsRight;
  //creates the talon and victor variables
  
  private double leftOffset = 0;
  private double rightOffset = 0;
  
 
  private final double distancePerPulse = Math.PI * Constants.WHEEL_DIAMETER * Constants.ENCODER_GEAR_RATIO / Constants.ENCODER_PULSES_PER_REVOLATION;
  public DriveTrain() {
    talonLeft = new TalonSRX(Constants.MOTOR_PORTS_LEFT[0]);
    talonRight = new TalonSRX(Constants.MOTOR_PORTS_RIGHT[0]);
    //creates the talon motors and sets their ports
 
    talonLeft.configFactoryDefault();
    talonRight.configFactoryDefault();
    //resets the talons to default settings
 
    talonLeft.setInverted(Constants.LEFT_INVERTED);
    talonRight.setInverted(Constants.RIGHT_INVERTED);
    //inverts the talon motors
 
    talonLeft.configOpenloopRamp(Constants.RAMP_RATE);
    talonRight.configOpenloopRamp(Constants.RAMP_RATE);
    //tells how fast the motors can reach max speed
 
    victorsLeft = new VictorSPX[Constants.MOTOR_PORTS_LEFT.length - 1];
    for (int i = 1; i < Constants.MOTOR_PORTS_LEFT.length; i++) {
      victorsLeft[i-1] = new VictorSPX(Constants.MOTOR_PORTS_LEFT[i]);
      victorsLeft[i-1].configFactoryDefault();
      victorsLeft[i-1].follow(talonLeft);
      //makes the victors follow the current speed of the left talon
      victorsLeft[i-1].setInverted(Constants.LEFT_INVERTED);
    }//creates a loop to create the victor motors and their ports on the left side
 
    victorsRight = new VictorSPX[Constants.MOTOR_PORTS_RIGHT.length - 1];
    for (int i = 1; i < Constants.MOTOR_PORTS_RIGHT.length; i++) {
      victorsRight[i-1] = new VictorSPX(Constants.MOTOR_PORTS_RIGHT[i]);
      victorsRight[i-1].configFactoryDefault();
      victorsRight[i-1].follow(talonRight);
      //makes the victors follow the current speed of the right talon
      victorsRight[i-1].setInverted(Constants.RIGHT_INVERTED);
    }//creates a loop to create the victor motors and their ports on the right side
  }
  
  public void setLeftMotors(double speed) {
    talonLeft.set(ControlMode.PercentOutput, speed);
  }
  //sets the left talon's speed
 
  public void setRightMotors(double speed) {
    talonRight.set(ControlMode.PercentOutput, speed);
  }
  //sets the right talon speed
 
  public void setBothMotors(double speed) {
    setLeftMotors(speed);
    setRightMotors(speed);
  }
  //sets both motor's speed
 
  public void resetEncoders(){
    leftOffset = talonLeft.getSelectedSensorPosition();
    rightOffset = talonRight.getSelectedSensorPosition();
  }
  //gets the current position of the encoders on the motors
 
public double getLeftDistance() {
  return (talonLeft.getSelectedSensorPosition() - leftOffset) * distancePerPulse;
}
//
public double getRightDistance() {
  return (talonRight.getSelectedSensorPosition() - rightOffset) * distancePerPulse;
}
public double getDistance() {
  return (getRightDistance()+ getLeftDistance()) * 0.5;
}
public double getLeftVelocity() {
  return talonLeft.getSelectedSensorVelocity() * distancePerPulse * Constants.VELOCITY_CALCULATIONS_PER_SECOND / 12;
  //gets the velocity of the left motors
}
public double getRightVelocity() {
  return talonRight.getSelectedSensorVelocity() * distancePerPulse * Constants.VELOCITY_CALCULATIONS_PER_SECOND / 12;
  //gets the velocity of the right motors
}
public double getVelocity() {
  return (getLeftVelocity() + getRightVelocity()) * 0.5;
  //shows the current velocity of the motors
}
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
 

