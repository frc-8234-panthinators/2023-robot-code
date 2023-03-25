package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class PneumaticSystem {
    DoubleSolenoid clawActuator1 = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 1);
    
    public void solenoidControl (boolean state) {
        if (state) {
            clawActuator1.set(Value.kForward);
        } else {
            clawActuator1.set(Value.kReverse);
        }
    }
}
