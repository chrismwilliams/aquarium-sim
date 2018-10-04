package UserCode.Manager;

import env3d.Env;
import UserCode.Misc.IMouseClickHandler;
import UserCode.Factory.IManagerFactory;
import UserCode.Factory.ManagerFactory;

/**
 * Manager: This class controls which top level managers are required to run the aquarium simulation. This class requires
 * an implementation of the IManagerCreator to create the managers which are then updated each frame.
 *
 * @author Chris Williams
 * @version 3.0
 */
public class Manager implements IManager
{
    // DECLARE a field to store a reference to the Env created in the Simulation class, call it '_world':
    private Env _world;
    
    // DECLARE an instance of the EntityManager, call it '_entityManager':
    private IEntityManager _entityManager;

    // DECLARE a IMouseClickHandler field to check if the left mouse button has been clicked, call it '_mouseHandler': 
    private IMouseClickHandler _mouseHandler;

    /**
     * Constructor for objects of class Manager
     * 
     * @param   worldRef   the Env class world reference required by the ManagerCreator class
     * 
     */
    public Manager(Env worldRef)
    {
        // INITALISE the _world field with the param passed:
        _world = worldRef;
        
        // CALL the start method:
        start();
    }

    /**
     * 
     * METHOD: used to create the managers required for the aquarium simulation to run by creating an instance of the ManagerCreator
     * class and calling for the managers required.
     * 
     */
    private void start()
    {
        // DECLARE and initialise an instance of IManagerFactory to create the managers required, passing the _world:
        IManagerFactory _managerFactory = new ManagerFactory(_world);

        // INITIALISE the _mouseHandler field by calling the getMouseHandler:
        _mouseHandler = (IMouseClickHandler) _managerFactory.getMouseHandler();

        // INITIALISE the _entityManager field by calling the getEntityManager and pass the reference to this:
        _entityManager = _managerFactory.getEntityManager();
    }
    
    /**
     * 
     * METHOD: called per frame by the Simulation class. This method calls the update method of the EntityManager class
     * and the MouseClickHandler checkMouse()
     * 
     */
    public void update()
    {
        // CALL the checkMouse method of the IMouseClickHandler:
        _mouseHandler.checkMouse();

        // CALL the update method on the EntityManager to update entities:
        _entityManager.update();
    }

}
