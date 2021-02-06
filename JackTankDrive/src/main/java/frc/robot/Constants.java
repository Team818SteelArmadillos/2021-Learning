package frc.robot;


public final class Constants {
    //Drive Motors
    public static int[] MOTOR_PORTS_LEFT = {1, 2, 3};
    public static int[] MOTOR_PORTS_RIGHT = {4, 5, 6};
    public static boolean LEFT_INVETED = false; 
    public static double RAMP_RATE = 0;

    //Chassis constants
    public static double WHEEL_DIAMETER = 8;
    public static double ENCODER_GEAR_RATIO = 1; 
    public static int ENCODER_PULSES_PER_REVOLUTION = 4096; 
    public static int VELOCITY_CALCULATIONS_PER_SECOND = 10;

    public static int JOYSTICK_PORT_LEFT = 0;
    public static int JOYSTICK_PORT_RIGHT = 1; 
    public static double JOYSTICK_LEFT_DEADZONE_Y = 0.02;
    public static double JOYSICK_RIGHT_DEADZONE_Y = 0.02;
}