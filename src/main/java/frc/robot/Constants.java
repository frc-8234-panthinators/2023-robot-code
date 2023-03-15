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
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static final double periodicUpdateRateSec = 0.02;//How often 'periodic' runs IN SECONDS

  public static final double normalSpeedMultiplier = 0.6;//The multiplier for how fast the robot normally runs at max speed
  
  public static final double armExtensionRotRate = 1.0;//How fast the arm extension motor turns PER SECOND
  public static final double armExtensionRotRatio = 1.0;//How far the arm extends PER ROTATION of the extension gear
  
  public static final double armDeflectionRotRate = -0.3;//How fast the arm extension motor turns PER SECOND
  public static final double armDeflectionRotRatio = 1.0;//How far the arm extends PER ROTATION of the extension gear

  public static final double armZRotRate = 0.2;//The maximum rate at which the arm rotates when the motor is engaged
  public static final double armZRotRatio = 1.0;//How much the arm rotates PER ROTATION of the arm rotation gear
}
