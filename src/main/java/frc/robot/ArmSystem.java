package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
public class ArmSystem {
    private static WPI_TalonFX zRot = new WPI_TalonFX(5);
    public void turnArm(double turnSpeed) {
        zRot.set(turnSpeed);
    };
}
