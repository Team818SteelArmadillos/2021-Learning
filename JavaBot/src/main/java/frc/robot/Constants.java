// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;

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
    public static boolean RIGHT_INVERTED = false;

    public static double RAMP_RATE = 0;
}
