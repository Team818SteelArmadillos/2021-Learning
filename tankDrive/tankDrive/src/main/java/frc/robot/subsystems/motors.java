// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class motors extends SubsystemBase {
    private TalonSRX talonLeft, talonRight;
    private VictorSPX[] victorsLeft, victorsRight;

  public motors() {
    talonLeft = new TalonSRX(Constants.MOTOR_PORTS_LEFT[0]);
    talonRight = new TalonSRX(Constants.MOTOR_PORTS_RIGHT[0]);

    talonLeft.configFactoryDefault();
    talonRight.configFactoryDefault();

    talonLeft.setInverted(Constants.LEFT_INVERTED);
    talonRight.setInverted(Constants.RIGHT_INVERTED);

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


    /** Creates a new motors. */
  public void SetLeftMotors(double speed) {
    talonLeft.set(ControlMode.PercentOutput, speed);
  }

  public void SetRightMotors(double speed) {
    talonRight.set(ControlMode.PercentOutput, speed);
  }
  
  public void SetBothMotors(double speed) {
    SetLeftMotors(speed);
    SetRightMotors(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}