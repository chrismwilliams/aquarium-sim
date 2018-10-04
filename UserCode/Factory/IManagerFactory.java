package UserCode.Factory;

import UserCode.Manager.IEntityManager;
import UserCode.Behaviours.IObservable;

/**
 * IManagerCreator defines the Interface of a class that creates top level managers required in an aquarium simulation
 *
 * @author Chris Williams
 * @version 3.0
 */
public interface IManagerFactory
{
    /**
     * 
     * METHOD: used to return an Instance of the IObservable class that represenets the MouseClickHandler class
     * 
     * @return  IObservable   the concrete implementation of the IObservable class to account for mouse clicks
     * 
     */
    IObservable getMouseHandler();
            
    /**
     * 
     * METHOD: used to return an instance of the IEntityManager class that contains all the functionality required to update the pets
     * 
     * @return  IEntityManager   the concrete implementation of the IEntityManager class
     * 
     */
    IEntityManager getEntityManager();
}
