// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterSubsystem extends SubsystemBase {

  public VictorSPX victor1, victor2, victor3;
  public TalonSRX talon1;
  private double ShooterMotorSpeed;
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
   // This method will be called once per scheduler run
    victor1 = new VictorSPX(Constants.SHOOTER_PORTS[0]);
    victor2 = new VictorSPX(Constants.SHOOTER_PORTS[1]);
    victor3 = new VictorSPX(Constants.SHOOTER_PORTS[2]);
    talon1 = new TalonSRX(Constants.SHOOTER_PORTS[3]);

    victor1.configFactoryDefault(); 
    victor2.configFactoryDefault();
    victor3.configFactoryDefault();
    talon1.configFactoryDefault();

    victor2.follow(victor1);
    victor3.follow(victor1);
    talon1.follow(victor1);

    victor1.setInverted(Constants.SHOOTER_LEFT_SIDE_INVERTED);
    victor2.setInverted(Constants.SHOOTER_LEFT_SIDE_INVERTED);
    victor3.setInverted(Constants.SHOOTER_RIGHT_INVERTED);
    talon1.setInverted(Constants.SHOOTER_RIGHT_INVERTED);
    
    
  }
  public double getCurrentShooterSpeed(){

    return talon1.getSelectedSensorVelocity() * Constants.velocityCalculationsPerSecond *-1 * 60 / Constants.encoderPulsesPerRevolution;
    //Revolutions per mintue. Negative is to account for the change in direction.

  }
  @Override
  public void periodic() {
    //this defines what the shooter motor speed is

    //ShooterMotorSpeed = SmartDashboard.getNumber("Shooter speed", 0.0);
    ShooterMotorSpeed = 0.5;

 
  }
  public void setPower(double power) {
    victor1.set(ControlMode.PercentOutput, ShooterMotorSpeed);
  }
  public void showPower(double power) {
    SmartDashboard.putNumber("shooter rpm", getCurrentShooterSpeed());
  }
}

