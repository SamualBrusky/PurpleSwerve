// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

import frc.robot.utils.PIDConstants;
import frc.robot.utils.SparkPIDConfig;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class Global {
    public static final double ROBOT_LOOP_PERIOD = 1.0 / 50.0;

    // Motor RPMs, encoder values, and gear ratios
    public static final int NEO_MAX_RPM = 5880;
    public static final int NEO_ENCODER_TICKS_PER_ROTATION = 42;
    public static final int REV_ENCODER_TICKS_PER_ROTATION = 8192;
  }

  public static class HID {
    public static final int PRIMARY_CONTROLLER_PORT = 0;
    public static final int SECONDARY_CONTROLLER_PORT = 1;
    public static final double CONTROLLER_DEADBAND = 0.10;
  }

  public static class Drive {
    public static final PIDConstants DRIVE_TURN_PID = new PIDConstants(0.019, 0.0, 0.0014, 0.0);
    public static final PIDConstants DRIVE_ANTI_TIP_PID = new PIDConstants(0.010, 0.0, 0.0005, 0.0);
    public static final double DRIVE_SLIP_RATIO = 0.05;
    public static final double DRIVE_TURN_SCALAR = 40.0;
    public static final double DRIVE_LOOKAHEAD = 3;

    private static final double DRIVE_THROTTLE_INPUT_CURVE_X[] = { 0.0, 0.5, 1.0 };
    private static final double DRIVE_THROTTLE_INPUT_CURVE_Y[] = { 0.0, 1.975, 3.95 };
    private static final double DRIVE_TURN_INPUT_CURVE_X[] = { 0.0, 0.100, 0.200, 0.300, 0.400, 0.500, 0.600, 0.700, 0.800, 0.900, 1.0 };
    private static final double DRIVE_TURN_INPUT_CURVE_Y[] = { 0.0, 0.008, 0.032, 0.072, 0.128, 0.200, 0.288, 0.392, 0.512, 0.768, 1.0 };

    private static final SplineInterpolator SPLINE_INTERPOLATOR = new SplineInterpolator();
    public static final PolynomialSplineFunction DRIVE_THROTTLE_INPUT_CURVE = SPLINE_INTERPOLATOR.interpolate(DRIVE_THROTTLE_INPUT_CURVE_X, DRIVE_THROTTLE_INPUT_CURVE_Y);
    public static final PolynomialSplineFunction DRIVE_TURN_INPUT_CURVE = SPLINE_INTERPOLATOR.interpolate(DRIVE_TURN_INPUT_CURVE_X, DRIVE_TURN_INPUT_CURVE_Y);

    // Swerve velocity PID settings
    private static final double DRIVE_VELOCITY_kP = 8.471e-8;
    private static final double DRIVE_VELOCITY_kI = 0.0;
    private static final double DRIVE_VELOCITY_kD = 0.0;
    private static final double DRIVE_VELOCITY_kF = 1.271e-8;
    private static final double DRIVE_VELOCITY_TOLERANCE = 0.01;
    private static final boolean DRIVE_VELOCITY_SENSOR_PHASE = false;
    private static final boolean DRIVE_INVERT_MOTOR = false;

    // Swerve velocity PID config
    public static final SparkPIDConfig DRIVE_VELOCITY_CONFIG = new SparkPIDConfig(
      DRIVE_VELOCITY_SENSOR_PHASE,
      DRIVE_INVERT_MOTOR,
      DRIVE_VELOCITY_kP,
      DRIVE_VELOCITY_kI,
      DRIVE_VELOCITY_kD,
      DRIVE_VELOCITY_kF,
      DRIVE_VELOCITY_TOLERANCE
    );

    // Swerve rotate PID settings
    private static final double DRIVE_ROTATE_kP = 10.0;
    private static final double DRIVE_ROTATE_kI = 0.0;
    private static final double DRIVE_ROTATE_kD = 0.0;
    private static final double DRIVE_ROTATE_kF = 0.0;
    private static final double DRIVE_ROTATE_TOLERANCE = 0.01;
    private static final double DRIVE_ROTATE_LOWER_LIMIT = 0.0;
    private static final double DRIVE_ROTATE_UPPER_LIMIT = 0.0;
    private static final boolean DRIVE_ROTATE_SOFT_LIMITS = false;
    private static final boolean DRIVE_ROTATE_SENSOR_PHASE = false;
    private static final boolean DRIVE_ROTATE_INVERT_MOTOR = false;

    // Swerve rotate PID config
    public static final SparkPIDConfig DRIVE_ROTATE_CONFIG = new SparkPIDConfig(
      DRIVE_ROTATE_SENSOR_PHASE,
      DRIVE_ROTATE_INVERT_MOTOR,
      DRIVE_ROTATE_kP,
      DRIVE_ROTATE_kI,
      DRIVE_ROTATE_kD,
      DRIVE_ROTATE_kF,
      DRIVE_ROTATE_TOLERANCE,
      DRIVE_ROTATE_LOWER_LIMIT,
      DRIVE_ROTATE_UPPER_LIMIT,
      DRIVE_ROTATE_SOFT_LIMITS
    );
  }

  public static class DriveHardware {
    public static final int FRONT_LEFT_DRIVE_MOTOR_ID = 2;
    public static final int FRONT_LEFT_ROTATE_MOTOR_ID = 3;
    public static final int FRONT_RIGHT_DRIVE_MOTOR_ID = 4;
    public static final int FRONT_RIGHT_ROTATE_MOTOR_ID = 5;
    public static final int REAR_LEFT_DRIVE_MOTOR_ID = 6;
    public static final int REAR_LEFT_ROTATE_MOTOR_ID = 7;
    public static final int REAR_RIGHT_DRIVE_MOTOR_ID = 8;
    public static final int REAR_RIGHT_ROTATE_MOTOR_ID = 9;
  }

  public static class AccessoryHardware {
    public static final int BLINKIN_LED_CONTROLLER_PORT = 0;
  }

  public static class SmartDashboard {
    public static final String SMARTDASHBOARD_DEFAULT_TAB = "SmartDashboard";
    public static final String SMARTDASHBOARD_AUTO_MODE = "Auto Mode";
  }
}
