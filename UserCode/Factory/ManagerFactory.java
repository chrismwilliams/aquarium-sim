package UserCode.Factory;

import UserCode.Manager.*;
import UserCode.Misc.MouseClickHandler;
import UserCode.Behaviours.IObservable;
import UserCode.Behaviours.IObserver;
import UserCode.Behaviours.RequestBubbleObserver;

import env3d.Env;

/**
 * ManagerCreator defines the class that creates all the top level managers required for the aquarium simulation
 *
 * @author Chris Williams
 * @version 3.0
 */
public class ManagerFactory implements IManagerFactory
{
    // DECLARE a field to store the IEntityManager class, call it '_entityMngr':
    IEntityManager _entityMngr;

    // DECLARE a field to store the IObservable class, call it '_mouseHandler':
    private IObservable _mouseHandler;
    
    // DECLARE a instance of the IObserver class 
    private IObserver _bubbleObserver;

    /**
     * Constructor for objects of class ManagerCreator, used only for testing
     */
    public ManagerFactory()
    {
        // USED only for testing
    }
    
    /**
     * Constructor for objects of class ManagerCreator
     * 
     * @param   worldRef   a reference to the Env environment many of the managers require
     * 
     */
    public ManagerFactory(Env worldRef)
    {
        // INITIALISE _soundManager and pass the _world reference:
        ISoundManager _soundManager = new SoundManager(worldRef);
        
        // INITIALISE a new instance of IWorldManger which the IEntityManager class requires:
        IWorldManager _worldManager = new WorldManager(worldRef);
        
        // INITIALISE a new instance of IEntityListManager:
        IEntityListManager _listManager = new EntityListManager();
        
        // INITIALISE a new instance of a RequestBubbleObserver and pass the reference to this:
        _bubbleObserver = new RequestBubbleObserver(_listManager);
        
        // INITIALISE the instance variable _factory to the EntityCreatorFactory and pass _bubbleObserver instance:
        IEntityCreatorFactory _factory = new EntityCreatorFactory(_bubbleObserver);
        
        // CALL the _listManager Initialise method with the _factory and _worldManager fields:
        _listManager.Initialise(_factory,_worldManager);
        
        // INITIALISE a new instance of ISubEntityMngr CollisionManager:
        ISubEntityMngr _collisionMngr = new CollisionManager(_listManager);
        
        // INITIALISE a new instance of ISubEntityMngr WorldBoundsManager:
        ISubEntityMngr _boundsMngr = new WorldBoundsManager(_listManager, _soundManager);
        
        // INITIALISE a new instance of ISubEntityMngr FeedManager:
        ISubEntityMngr _feedMngr = new FeedManager(_listManager);

        // INITIALISE a new instance of ISubEntityMngr PreyLvlManager:
        ISubEntityMngr _preyLvlMngr = new PreyLvlManager(_listManager);
        
        // INITIALISE _entityMngr and pass the ISubEntityMngr's created:
        _entityMngr = new EntityManager(_boundsMngr,_collisionMngr,_feedMngr,_preyLvlMngr,(ISubEntityMngr) _listManager);
        
        // INITIALISE a new MouseManager with the IEntityListManager:
        IObserver _mouseManager = new MouseManager(_listManager);
        
        // INITIALISE _mouseHandler with the _world reference:
        _mouseHandler = new MouseClickHandler(worldRef);

        // TELL the mouseManager to watch the _mouseHandler class created:
        _mouseManager.observeObj(_mouseHandler);
        
    }

    /**
     * 
     * METHOD: used to return the _mouseHandler IObservable class set in construction
     * 
     * @param   the _mouseHandler field
     * 
     */
    public IObservable getMouseHandler()
    {
        // RETURN the _mouseHandler field to caller:
        return _mouseHandler;
    }
    
    /**
     * 
     * METHOD: used to return the _entityMngr field set in construction
     * 
     * @return  the _entityMngr field
     * 
     */
    public IEntityManager getEntityManager()
    {
        // RETURN the _entityMngr field:
        return _entityMngr;
    }
}
