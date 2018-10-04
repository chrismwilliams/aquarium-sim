package UserCode.Sim;

import UserCode.Pets.IToken;

/**
 * ISim defines the interface for the class that runs the simulation each frame
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public interface ISim
{
    /**
     * 
     * METHOD: used to start the Simulation and update the world
     * 
     */
    void run();
}
