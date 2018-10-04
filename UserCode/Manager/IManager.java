package UserCode.Manager;

import UserCode.Sim.ISim;

/**
 * IManager defines the behaviour for the top level manager required to run an aquarium simulation.
 *
 * @author Chris Williams
 * @version 3.0
 */
public interface IManager
{
    /**
     * 
     * METHOD: called per frame and used to update any managers that require updating
     * 
     */
    void update();
}
