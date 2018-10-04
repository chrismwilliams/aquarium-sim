package UserCode.Components;

import UserCode.Behaviours.IBehaviour;

/**
 * IComponent defines how a component should act and the main methods it should implement in order to function as intended
 * with the IBehaviour pets included within the aquarium
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public interface IComponent
{
    /**
     * 
     * METHOD: Used to assign a component an IBehaviour
     * 
     * @param	_behaviour   the IBehaviour this component will be acting on
     * 
     */
    void Initialise(IBehaviour _b);    

    /**
     * 
     * METHOD:  Used to return the unique name of the IComponent
     * 
     * @return	the name of the IComponent as a String
     * 
     */
    String getName();

    /**
     * 
     * METHOD:  Used to stop any procedures it is currently running if required
     * 
     */
    void TearDown();
    
    /**
     * 
     * METHOD: Used by the concrete implementation to perform its unique action
     * 
     */
    void componentAction();

    /**
     * 
     * METHOD: Used to update any properties if required which will be called each frame by the IBehaviour.
     *  
     */
    void update();
}
