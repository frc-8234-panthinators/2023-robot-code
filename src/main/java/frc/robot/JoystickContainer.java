package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import java.lang.Math;

public class JoystickContainer {

    public Joystick left = new Joystick(0);
    public Joystick center = new Joystick(1);
    public Joystick right = new Joystick(2);
    final JoystickButton speedBoost = new JoystickButton(center, 3);
    // final JoystickButton teleopCargoLock = new JoystickButton(left, 3);
    // final JoystickButton aimBotToggle = new JoystickButton(center, 2);

    public double speed, direction;
    public boolean boostEnabled;
    // public boolean autoCargoEnabled;
    // public boolean aimBotEnabled;
    // public boolean intakeInitiated;
    // public boolean demoModeDisengaged;
    final JoystickButton extensionEnabled = new JoystickButton(left, 11);
    final JoystickButton retractionEnabled = new JoystickButton(left, 10);
    final JoystickButton clawInitiate = new JoystickButton(right, 1);
    final JoystickButton triggerLevel = new JoystickButton(left, 3);
    // final JoystickButton intakeReverse = new JoystickButton(right, 3);
    // final JoystickButton shooterIntakeReverse = new JoystickButton(right, 5);
    // final JoystickButton manualShooterIntake = new JoystickButton(right, 4);
    // final JoystickButton demoModeOff = new JoystickButton(right, 6);

    // public double inputShooterSpeed;
    // // The inputShooterSpeed will eventually be deleted and its function replaced by
    // // a distance lookup table
    // public boolean shootInitiated;

    // moving
    public double getSpeed() {
        return left.getX();
    };

    // Changed to center joystick so that it's all together
    // turning
    public double getDirection() {
        return center.getY();
    };

    // left-right direction
    public double getArmDirection() {
        return right.getX();
    }

    // up-down direction
    public double getArmDeflection() {
        return right.getY();
    }

    // extension change amount
    public double getExtension() {
        /*double accumulator = 0;
        if (extensionEnabled.getAsBoolean()) {
            accumulator++;
        } 
        if (retractionEnabled.getAsBoolean()) {
            accumulator--;
        }
        return accumulator;*/
        //^^TF is this??
        return extensionEnabled.getAsBoolean() ? 1 : -1;
    }
    public boolean getExtensionBool(){
        return extensionEnabled.getAsBoolean();
    }

    // returns 1 if pressed and -1 if not pressed
    public double getClaw() {
        return clawInitiate.getAsBoolean() ? 1 : -1;
    }
    public boolean getClawBool() {
        return clawInitiate.getAsBoolean();
    }
    public boolean getBoostEnabled(){
        return speedBoost.getAsBoolean();
    }
    public boolean getTriggerLevel(){
        return triggerLevel.getAsBoolean();
    }
}