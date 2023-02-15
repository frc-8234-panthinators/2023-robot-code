package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class PneumaticSystem {
    Solenoid clawActuator1 = new Solenoid(PneumaticsModuleType.REVPH, 3);
    
    public void solenoidControl (boolean state) {
        clawActuator1.set(state);
    }
}
