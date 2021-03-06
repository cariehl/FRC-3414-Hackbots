/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmington.frameworks;

/**
 *
 * @author 3414
 */
public class Waiter extends LoopHandler {
    
    private int targetIteration;
    
    public Waiter() {
        targetIteration = -1;
    }
    
    public void waitXLoops(int waitTime) {
        this.targetIteration = getCurrentIteration() + waitTime;
    }
    
    public boolean isWaiting() {
        if (getCurrentIteration() < targetIteration) {
            return true;
        }
        return false;
    }
    
    public boolean timeUp() {
        if (getCurrentIteration() >= targetIteration) {
            return true;
        }
        return false;
    }
}
