
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private TalonSRX talonLeft, talonRight;
  private VictorSPX[] victorsLeft, victorsRight;
  

  private int leftOffset = 0;
  private int rightOffset = 0;
  
  private final double distancePerPulse = Math.PI * Constants.WHEEL_DIAMETER * Constants.ENCODER_GEAR_RATIO / Constants.ENCODER_PULSES_PER_REVOLUTION; 

  public DriveTrain() {
    talonLeft = new TalonSRX(Constants.MOTOR_PORTS_LEFT[0]);
    talonRight = new TalonSRX(Constants.MOTOR_PORTS_RIGHT[0]);

    talonLeft.configFactoryDefault();
    talonRight.configFactoryDefault();

    talonLeft.setInverted(Constants.LEFT_INVETED);
    talonRight.setInverted(!Constants.LEFT_INVETED);

    talonLeft.configOpenloopRamp(Constants.RAMP_RATE);
    talonRight.configOpenloopRamp(Constants.RAMP_RATE);

    victorsLeft = new VictorSPX[Constants.MOTOR_PORTS_LEFT.length - 1];
    for (int i = 1; i < Constants.MOTOR_PORTS_LEFT.length; i++) {
      victorsLeft[i-1] = new VictorSPX(Constants.MOTOR_PORTS_LEFT[i]);
      victorsLeft[i-1].configFactoryDefault();
      victorsLeft[i-1].follw(talonLeft);
      victorsLeft[i-1].setInverted(Constants.LEFT_INVETED);
    }

    victorsRight = new VictorSPX[Constants.MOTOR_PORTS_RIGHT.lenth - 1];
    for (int i = 1; i < Constants.MOTOR_PORTS_RIGHT.length; i++) {
      victorsRight[i-1] = new VictorSPX(Constants.MOTOR_PORTS_RIGHT[i]);
      victorsRight[i-1].configFactoryDefault();
      victorsRight[i-1].follow(talonRight);
      victorsRight[i-1].setInverted(!Constants.LEFT_INVETED);
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

  public void resetEncoders() {
    leftOffset = talonLeft.getSelectedSensorPostion();
    rightOffset = talonRight.getSelectedSensorPostion();
  }

  public double getLeftDistance() {
    return (talonLeft.getSelectedSensorPostion() - leftOffset) * distancePerPulse;
  }
  
  public double getRightDistance() {
    return (talonRight.getSelectedSensorPostion() - rightOffset) *distancePerPulse;
  }
  
  public double getDistance() {
    return (getRightDistance() + getLeftDistance()) * 0.5;
  }
  
  public double getleftVelocity() {
    return talonLeft.getSelectedSensorVelocity() * distancePerPulse * Constants.VELOCITY_CALCULATIONS_PER_SECOND / 12;
  }
  
  public double getRightVelocity() {
    return talonRight.getSelectedSensorVelocity() * distancePerPulse * Constants.VELOCITY_CALCULATIONS_PER_SECOND / 12;
  }

  public double getVelocity() {
    return (getleftVelocity() + getRightVelocity()) * 0.5;
  }


  
  @Override
  public void periodic() {
  
  }
}
