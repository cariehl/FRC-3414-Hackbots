package farmington.ultimateascent;

import edu.wpi.first.wpilibj.Talon;

/**
 * This class controls all four Talons on the drive train.
 * @author 3414
 */
public class DriveTrain implements IRobot {

    Talon leftFrontMotor;
    Talon rightFrontMotor;
    Talon leftBackMotor;
    Talon rightBackMotor;
    
    /**
     * Main constructor for DriveTrain.
     * @param leftFrontSlot     PWM slot for the front-left Talon.
     * @param leftBackSlot      PWM slot for the back-left Talon.
     * @param rightFrontSlot    PWM slot for the front-right Talon.
     * @param rightBackSlot     PWM slot for the back-right Talon.
     */
    public DriveTrain(int leftFrontSlot, int leftBackSlot, int rightFrontSlot, int rightBackSlot) {
        leftFrontMotor = new Talon(leftFrontSlot);
        leftBackMotor = new Talon(leftBackSlot);
        rightFrontMotor = new Talon(rightFrontSlot);
        rightBackMotor = new Talon(rightBackSlot);
    }
    
    /*
     * This sets the speed based on a raw value. Use this for setting a manual drive speed.
     */
    public void setSpeed(double speed) {
        leftFrontMotor.set(speed);
        leftBackMotor.set(speed);
        
        // We invert the right speed because the right side Talons are inverted
        rightFrontMotor.set(-speed);
        rightBackMotor.set(-speed);
    }
    
    public void setSpeed(double leftSpeed, double rightSpeed) {
        leftFrontMotor.set(leftSpeed);
        leftBackMotor.set(leftSpeed);
        
        // We invert the right speed because the right side Talons are inverted        
        rightFrontMotor.set(-rightSpeed);
        rightBackMotor.set(-rightSpeed);
    }
    
    /**
     * This sets the speed based on a Joystick. Keep in mind that this is an inversion of the true speed (so 0.5 will cause the robot to go backwards at half speed)
     * @param speed speed at which to move
     */
    public void setSpeedWithJoysticks(double speed) {
        if (speed < -JOYSTICK_DEADZONE || speed > JOYSTICK_DEADZONE) {
            /* Now we invert the left speed because the right Talons AND the
             * Joysticks are inverted
             */
            leftFrontMotor.set(-speed);
            leftBackMotor.set(-speed);
            rightFrontMotor.set(speed);
            rightBackMotor.set(speed);
        } else {
            leftFrontMotor.set(0.0);
            leftBackMotor.set(0.0);
            rightFrontMotor.set(0.0);
            rightBackMotor.set(0.0);
        }
    }
    
    /**
     * Sets the speed of the left and right sides relative to battery voltage.
     * @param leftSpeed     
     * @param rightSpeed    
     */
    public void setSpeedWithJoysticks(double leftSpeed, double rightSpeed) {
        if (leftSpeed < -JOYSTICK_DEADZONE || leftSpeed > JOYSTICK_DEADZONE) {
            /* Now we invert the left speed because the right Talons AND the
             * Joysticks are inverted
             */
            leftFrontMotor.set(-leftSpeed);
            leftBackMotor.set(-leftSpeed);
        } else {
            leftFrontMotor.set(0);
            leftBackMotor.set(0);
        }
        
        if (rightSpeed < -JOYSTICK_DEADZONE || rightSpeed > JOYSTICK_DEADZONE) {
            rightFrontMotor.set(rightSpeed);
            rightBackMotor.set(rightSpeed);
        } else {
            rightFrontMotor.set(0);
            rightBackMotor.set(0);
        }
    }
    
    /**
     * 
     * @return the speed of the front-left motor relative to battery voltage
     */
    public double getLeftFrontMotor() {
        return leftFrontMotor.get();
    }
    
    /**
     * 
     * @return the speed of the back-left motor relative to battery voltage
     */
    public double getLeftBackMotor() {
        return leftBackMotor.get();
    }
    
    /**
     * 
     * @return the speed of the front-right motor relative to battery voltage
     */
    public double getRightFrontMotor() {
        return rightFrontMotor.get();
    }
    
    /**
     * 
     * @return the speed of the back-right motor relative to battery voltage
     */
    public double getRightBackMotor() {
        return rightBackMotor.get();
    }
}
