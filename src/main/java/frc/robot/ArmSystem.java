package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
public class ArmSystem {
    private static WPI_TalonFX zRot = new WPI_TalonFX(7);
    private static WPI_TalonFX armDeflection = new WPI_TalonFX(8);
    // TODO: change below to victorSPX
    private static WPI_VictorSPX armExtension = new WPI_VictorSPX(9);
    public int armExtendTime = 0;//Number of times
    public int armZRotTime = 0;
    private final double gF = 0.1;
    private final double gP = 0.1;
    public double armDeflectionPos = 0d;
    public double zRotPos = 0d;
    public void initMotors() {
        zRot.configFactoryDefault();
        zRot.setInverted(false);
        zRot.setSensorPhase(false);
        zRot.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        zRot.config_kF(0, gF);
        zRot.config_kP(0, gP);
        zRot.setNeutralMode(NeutralMode.Coast);
        armDeflection.configFactoryDefault();
        armDeflection.setInverted(false);
        armDeflection.setSensorPhase(false);
        armDeflection.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        armDeflection.config_kF(0, gF);
        armDeflection.config_kP(0, gP);
        armDeflection.setNeutralMode(NeutralMode.Coast);
    };
    public void recenterMotorPos() {
        armDeflection.setSelectedSensorPosition(0);
    }
    public void turnArm(double turnSpeed) {
        //armZRotTime=armZRotTime+(turnSpeed<0?-1:turnSpeed>0?1:0);
        if(turnSpeed<0){
            armZRotTime--;
        }else if(turnSpeed>0){
            armZRotTime++;
        }
        zRotPos += turnSpeed;
        zRot.set(TalonFXControlMode.Position, zRotPos);
    };
    public void armDeflection(double rate) {
        armDeflectionPos -= rate;
        armDeflection.set(TalonFXControlMode.Position, armDeflectionPos);
    }
    public void setArmDeflect(double pos) {
        armDeflection.set(TalonFXControlMode.Position, pos);
    }
    public void extendArm(double extendSpeed){
        //armExtendTime=armExtendTime+(extendSpeed<0?-1:extendSpeed>0?1:0);
        if(extendSpeed<0){
            armExtendTime--;
        }else if(extendSpeed>0){
            armExtendTime++;
        }
        armExtension.set(extendSpeed);
    }
    public double getArmDeflectPos() {
        return armDeflection.getSelectedSensorPosition();
    }
    public double getArmRotSpeed(){
        return(zRot.get());
    }
    public double getArmRot(){
        return(armZRotTime*Constants.periodicUpdateRateSec*Constants.armZRotRate*Constants.armZRotRatio);
    }
    public double getArmExtSpeed(){
        return(armExtension.get());
    }
    public double getArmExtension(){
        return(armExtendTime*Constants.periodicUpdateRateSec*Constants.armExtensionRotRate*Constants.armExtensionRotRatio);
        //This will get the arm extension in terms of the motor rotation
        //TODO: Analyse the relation between motor rotation and extention difference
        //That way we can return the distance extended
    }
}
