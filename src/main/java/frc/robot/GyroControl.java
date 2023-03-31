package frc.robot;

import com.ctre.phoenix.CANifier.GeneralPin;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;

public class GyroControl {
    private static final SPI.Port gyroPort = SPI.Port.kOnboardCS0;
    private static ADXRS450_Gyro balance = new ADXRS450_Gyro(gyroPort);

    public static double getAngle(){
        return balance.getAngle();
    }
    public static void initGyro() {
        balance.calibrate();
    }
    public static void resetGyro() {
        balance.reset();
    }
}
