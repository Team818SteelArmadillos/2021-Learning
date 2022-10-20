// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

  public VictorSPX victor1, victor2, victor3;
  public TalonSRX talon1;
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

    victor1.follow(talon1);
    victor2.follow(talon1);
    victor3.follow(talon1);

    victor1.setInverted(Constants.SHOOTER_INVERTED);
    victor2.setInverted(Constants.SHOOTER_INVERTED);
    victor3.setInverted(Constants.SHOOTER_INVERTED);
    talon1.setInverted(Constants.SHOOTER_INVERTED);
    
    
  }
  public double getCurrentShooterSpeed(){

    return talon1.getSelectedSensorVelocity() * Constants.velocityCalculationsPerSecond *-1 * 60 / Constants.encoderPulsesPerRevolution;
    //Revolutions per mintue. Negative is to account for the change in direction.

  }
  @Override
  public void periodic() {
 
  }
  public void setPower(double power) {
    talon1.set(ControlMode.PercentOutput, power);
  }
}

