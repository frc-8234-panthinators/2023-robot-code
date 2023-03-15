package frc.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class GyroControl {
    static AnalogGyro thing = new AnalogGyro(0);

    public static double getAngle(){
        return thing.getAngle();
    }
}
