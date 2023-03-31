package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveSystem {
    static WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(3);
    static WPI_VictorSPX rightMotor2 = new WPI_VictorSPX(5);
    static WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(2);
    static WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(4);

    public static MotorControllerGroup leftSide = new MotorControllerGroup(leftMotor2, leftMotor1);
    public static MotorControllerGroup rightSide = new MotorControllerGroup(rightMotor2, rightMotor1);

    public static DifferentialDrive drive = new DifferentialDrive(leftSide, rightSide);

    public static void drive(double speed, double rotation) {
        drive.arcadeDrive(speed * 0.6, rotation * (RobotContainer.boostEnabled?1:Constants.normalSpeedMultiplier));
    }
    public static double getDist(){ 
        //Gets the average of the two motors integral accumulator (we're assuming that this is meaured in cycles)
        //Then multiplies this by the circumference in ordetr to ghet the distance travelled
       return ((rightMotor1.getIntegralAccumulator()+leftMotor1.getIntegralAccumulator())/2)*(2*Math.PI*Constants.wheelRadius);
    }
}