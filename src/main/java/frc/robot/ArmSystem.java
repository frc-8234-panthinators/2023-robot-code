package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
public class ArmSystem {
    private static WPI_TalonFX zRot = new WPI_TalonFX(7);
    private static WPI_TalonFX armDeflection = new WPI_TalonFX(8);
    // TODO: change below to victorSPX
    private static WPI_TalonFX armExtension = new WPI_TalonFX(9);
    public int armExtendTime = 0;//Number of times
    public int armZRotTime = 0;
    public void turnArm(double turnSpeed) {
        //armZRotTime=armZRotTime+(turnSpeed<0?-1:turnSpeed>0?1:0);
        if(turnSpeed<0){
            armZRotTime--;
        }else if(turnSpeed>0){
            armZRotTime++;
        }
        zRot.set(turnSpeed);
    };
    public void armDeflection(double rate) {
        armDeflection.set(rate);
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
