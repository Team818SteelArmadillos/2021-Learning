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
  
  private double leftOffset = 0;
  private double rightOffset = 0;
 
  private final double distancePerPulse = Math.PI * Constants.ENCODER_GEAR_RATIO / Constants.ENCODER_PULSES_PER_REVOLATION;
  public DriveTrain() {
    talonLeft = new TalonSRX(Constants.MOTOR_PORTS_LEFT[0]);
    talonRight = new TalonSRX(Constants.MOTOR_PORTS_RIGHT[0]);
 
    talonLeft.configFactoryDefault();
    talonRight.configFactoryDefault();
 
    talonLeft.setInverted(Constants.LEFT_INVERTED);
    talonRight.setInverted(Constants.RIGHT_INVERTED);
    
 
    talonLeft.configOpenloopRamp(Constants.RAMP_RATE);
    talonRight.configOpenloopRamp(Constants.RAMP_RATE);
 
    victorsLeft = new VictorSPX[Constants.MOTOR_PORTS_LEFT.length - 1];
    for (int i = 1; i < Constants.MOTOR_PORTS_LEFT.length; i++) {
      victorsLeft[i-1] = new VictorSPX(Constants.MOTOR_PORTS_LEFT[i]);
      victorsLeft[i-1].configFactoryDefault();
      victorsLeft[i-1].follow(talonLeft);
      victorsLeft[i-1].setInverted(Constants.LEFT_INVERTED);
    }
 
    victorsRight = new VictorSPX[Constants.MOTOR_PORTS_RIGHT.length - 1];
    for (int i = 1; i < Constants.MOTOR_PORTS_RIGHT.length; i++) {
      victorsRight[i-1] = new VictorSPX(Constants.MOTOR_PORTS_RIGHT[i]);
      victorsRight[i-1].configFactoryDefault();
      victorsRight[i-1].follow(talonRight);
      victorsRight[i-1].setInverted(Constants.RIGHT_INVERTED);
    }
  }
  
  public void setLeftMotors(double speed) {
    talonLeft.set(ControlMode.PercentOutput, speed);
  }
 
  public void setRightMotors(double speed) {
    talonRight.set(ControlMode.PercentOutput, speed);
  }
 
  public void setBothMotors(double speed) {
    setLeftMotors(speed);
    setRightMotors(speed);
  }
 
  public void resetEncoders(){
    leftOffset = talonLeft.getSelectedSensorPosition();
    rightOffset = talonRight.getSelectedSensorPosition();
  }
 
public double getLeftDistance() {
  return (talonLeft.getSelectedSensorPosition() - leftOffset) * distancePerPulse;
}
public double getRightDistance() {
  return (talonRight.getSelectedSensorPosition() - leftOffset) * distancePerPulse;
}
public double getDistance() {
  return (getRightDistance()+ getLeftDistance()) * 0.5;
}
public double getLeftVelocity() {
  return talonLeft.getSelectedSensorVelocity() * distancePerPulse * Constants.VELOCITY_CALCULATIONS_PER_SECOND / 12;
}
public double getRightVelocity() {
  return talonRight.getSelectedSensorVelocity() * distancePerPulse * Constants.VELOCITY_CALCULATIONS_PER_SECOND / 12;
}
public double getVelocity() {
  return (getLeftVelocity() + getRightVelocity()) * 0.5;
}
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
 

