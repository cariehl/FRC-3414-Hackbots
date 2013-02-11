
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shrihari, Alex
 */

public class GyroQ extends Main implements IRobot{
    Gyro myGyro = new Gyro(7);
    Timer timer = new Timer();
    
    public void Callibrate()
    {
        myGyro.reset();
    }
    
    public double Angle()
    {
        return myGyro.getAngle();
    }
    
    public void loop()
    {
        while(isEnabled() && isOperatorControl())
        {
            Angle();
            timer.delay(0.010);
        }
    }
}
