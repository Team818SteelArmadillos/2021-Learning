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
    //Drive Motors
    public static int[] MOTOR_PORTS_LEFT = {1, 2};
    public static int[] MOTOR_PORTS_RIGHT = {3, 4};
    public static int INTAKE_PORT = 6;
    public static int[] SHOOTER_PORTS = {7, 8, 9, 10};
    public static boolean LEFT_INVERTED = true;
    public static boolean RIGHT_INVERTED = false;
    public static double RAMP_RATE = 0;
 
    //Chassis constants
    public static double WHEEL_DIAMETER = 8;
    public static double ENCODER_GEAR_RATIO = 1;
    public static int ENCODER_PULSES_PER_REVOLATION = 4096;
    public static int VELOCITY_CALCULATIONS_PER_SECOND = 10;
 
    public static int JOYSTICK_PORT_LEFT = 0; 
    public static int JOYSTICK_PORT_RIGHT = 1;
    public static int XBOX_PORT = 2;
    public static double JOYSTICK_LEFT_DEADZONE_Y = 0.02;
    public static double JOYSTICK_RIGHT_DEADZONE_Y = 0.02;
 
}
 

