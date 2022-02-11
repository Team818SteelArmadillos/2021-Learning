// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
    public static final int[] MOTOR_PORTS_RIGHT = {1, 2};
    public static final int[] MOTOR_PORTS_LEFT = {3, 4};

    public static final int JOYSTICK_PORT_LEFT = 0; 
    public static final int JOYSTICK_PORT_RIGHT = 1;
    public static final int XBOX_PORT = 2;

    public static final float JOYSTICK_RIGHT_DEADZONE_Y = 0.02f;
    public static final float JOYSTICK_LEFT_DEADZONE_Y = 0.02f;

    public static final boolean LEFT_INVERTED = true;
    public static final boolean RIGHT_INVERTED = false;

    public static final double RAMP_RATE = 0;

    
    public static final double WHEEL_DIAMETER = 6;
    public static final double wheelCircumference = WHEEL_DIAMETER * Math.PI;

    public static final double ENCODER_GEAR_RATIO = 1;
    public static final int ENCODER_PULSES_PER_REVOLUTION = 2048;
    public static final int VELOCITY_CALCULATION_PER_SECOND = 10;
    public static final double distancePerPulse = wheelCircumference/(double) ENCODER_PULSES_PER_REVOLUTION;
}