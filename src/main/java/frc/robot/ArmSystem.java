package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
public class ArmSystem {
    private static WPI_TalonFX zRot = new WPI_TalonFX(5);
    private static WPI_TalonFX armExtension = new WPI_TalonFX(6);
    public void turnArm(double turnSpeed) {
        zRot.set(turnSpeed);
    };
    public void armDeflection(double rate) {
        
    }
    public void extendArm(double extendSpeed){
        armExtension.set(extendSpeed);
    }
}
