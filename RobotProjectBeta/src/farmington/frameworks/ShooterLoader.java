/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmington.frameworks;

import edu.wpi.first.wpilibj.Relay;
import farmington.ultimateascent.IRobot;

/**
 *
 * @author Robotics
 */
public class ShooterLoader implements IRobot {
    
    Relay loaderWheel;
    DIOSensor loaderSensor;
    boolean bayIsFull;
    Waiter loaderControl;
    
    public ShooterLoader(int loaderWheelRelay, int loaderSensorSlot) {      //relay1, dio1
        loaderWheel = new Relay(loaderWheelRelay);
        loaderSensor = new DIOSensor(loaderSensorSlot);
        bayIsFull = false;
        loaderControl = new Waiter();           //do we need this line?
    }
    
    public void updateLoader(boolean pistonIsExtended) {
        if (loaderSensor.get() && !bayIsFull) {
            loaderWheel.set(RELAY_ON);
            loaderControl.waitXLoops(20);   //FIXME: this value needs to be tuned for X number of ticks for one frisbee to be loaded
        }
        //
        if (bayIsFull) {
            bayIsFull = !pistonIsExtended;
        } else {
            bayIsFull = loaderSensor.get();
        }
        
        if (loaderControl.timeUp()) {
            loaderWheel.set(RELAY_OFF);
        } else {
            loaderWheel.set(RELAY_ON);
        }
    }
}
