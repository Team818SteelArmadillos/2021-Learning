// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.pheonix.motorcontrol.can.TalonSRX;
import com.ctre.pheonix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
private TalonSRX leftTalon, rightTalon;
private VictorSPX[] leftVictor, rightVictor;
//creates variables

private double leftOffset = 0;
private double rightOffset = 0;

private final double distancePerPulse = Math.PI * Constants.WHEEL_DIAMETER * Constants.ENCODER_GEAR_RATIO / Constants.ENCODER_PULSES_PER_REVOLUTION;
public DriveTrain() {
    leftTalon = new TalonSRX(Constants.MOTOR_PORTS_LEFT[0]);
    rightTalon = new TalonSRX(Constants.MOTOR_PORTS_RIGHT[0]);
    //sets talon ports

    leftTalon.configFactoryDefault();
    rightTalon.configFactoryDefault();
    //sets to default (What does this mean? Is default not moving?)

    leftTalon.setInverted(Constants.LEFT_INVERTED);
    rightTalon.setInverted(!Constants.LEFT_INVERTED);
    //inverts right motor since it's facing a different direction than the left motor

    leftTalon.configOpenloopRamp(Constants.RAMP_RATE);
    rightTalon.configOpenloopRamp(Constants.RAMP_RATE);
    //Time taken to get to max speed

    leftVictor = new VictorSPX[Constants.MOTOR_PORTS_LEFT.length - 1];
    for (int i = 1; i < Constants.MOTOR_PORTS_LEFT.length; i++) {
      leftVictor[i-1] = new VictorSPX(Constants.MOTOR_PORTS_LEFT[i]);
      leftVictor[i-1].configFactoryDefault();
      leftVictor[i-1].follow(leftTalon);
      leftVictor[i-1].setInverted(Constants.LEFT_INVERTED);
    }
    //follows speed of the left talon

    rightVictor = new VictorSPX[Constants.MOTOR_PORTS_RIGHT.length - 1];
    for (int i = 1; i < Constants.MOTOR_PORTS_RIGHT.length; i++) {
      rightVictor[i-1] = new VictorSPX(Constants.MOTOR_PORTS_RIGHT[i]);
      rightVictor[i-1].configFactoryDefault();
      rightVictor[i-1].follow(rightTalon);
      rightVictor[i-1].setInverted(!Constants.LEFT_INVERTED);
    }
    //follows the speed of the right talon
  }

  public void setLeftMotors(double speed) {
    leftTalon.set(ControlMode.PercentOutput, speed);
  }
  //controls left talon speed

  public void setRightMotors(double speed) {
    rightTalon.set(ControlMode.PercentOutput, speed);
  }
  //controls right talon speed

  public void setBothMotors(double speed) {
    setLeftMotors(speed);
    setRightMotors(speed);
  }
  //syncs both talon speeds

  public void resetEncoders() {
    leftOffset = leftTalon.getSelectedSensorPosition();
    rightOffset = rightTalon.getSelectedSensorPosition();
  }
  //idk what this does

  public double getLeftDistance() {
    return (leftTalon.getSelectedSensorPosition() - leftOffset) * distancePerPulse;
  }
  //gets left talon distance

  public double getRightDistance() {
    return (rightTalon.getSelectedSensorPosition() - rightOffset) *distancePerPulse;
  }
  //gets right motor distance

  public double getDistance() {
    return (getRightDistance() + getLeftDistance()) * 0.5;
  }
  //gets average distance
  
  public double getleftVelocity() {
    return leftTalon.getSelectedSensorVelocity() * distancePerPulse * Constants.VELOCITY_CALCULATIONS_PER_SECOND / 12;
  }
  //gets velocity of the left talon

  public double getRightVelocity() {
    return rightTalon.getSelectedSensorVelocity() * distancePerPulse * Constants.VELOCITY_CALCULATIONS_PER_SECOND / 12;
  }
  //gets velocity of the right talon

  public double getVelocity() {
    return (getleftVelocity() + getRightVelocity()) * 0.5;
  }
//gets average velocity

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
