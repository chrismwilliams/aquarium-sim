package UserCode.Manager;

import UserCode.Pets.IEntity;
import UserCode.Factory.IEntityCreatorFactory;
import UserCode.Behaviours.IObserver;

import java.util.List;
import java.util.ArrayList;

/**
 * EntityListManager defines the concrete implementation of IEntityListManager and ISubEntityMngr. This class proves the behaviour required by other
 * ISubEntityMngr classes to add and remove IEntity's in the aquarium, updating the _entities List provided by the IEntityManager
 *
 * @author Chris Williams
 * @version 3.0
 */
public class EntityListManager implements IEntityListManager, ISubEntityMngr
{
    // DECLARE a variable of type EntityCreatorFactory used to creating entities for use in the sim, call it '_factory':
    private IEntityCreatorFactory _factory;

    // DECLARE a variable to store the instance of the IWorldManager, call it '_worldManager':
    private IWorldManager _worldManager;

    // DECLARE a List to store all the entities ready to be added to the simuation, call it '_newEntities': 
    private List<IEntity> _newEntities;

    // DECLARE a List to store all the entities to remove from the aquarium, call it '_removeEntities':
    private List<IEntity> _removeEntities;

    /**
     * @Deprecated
     * Constructor for objects of class EntityListManager, used only for testing
     */
    @Deprecated
    public EntityListManager()
    {
        // INITIALISE the _newEntities field with a new ArrayList:
        _newEntities = new ArrayList<IEntity>();

        // INITIALISE the _removeEntities field with a new ArrayList:
        _removeEntities = new ArrayList<IEntity>();
    }

    /**
     * 
     * METHOD: used to assign the _factory and _wManager fields which are used to get IEntities and add IToken respectivly
     * 
     * @param   factor   the concrete implementation of the IEntityCreatorFactory used for creating IEntities
     * @param   _wManager   the concrete implementation of hte IWorldManager used for adding and removing ITokens
     * 
     */
    public void Initialise(IEntityCreatorFactory factory, IWorldManager _wManager)
    {
        // INITIALISE the _factory field with the param passed:
        _factory = factory;

        // INITIALISE the _worldManger field with the param passed:
        _worldManager = _wManager;

        // CALL the populateSim method:
        populateSim();
    }

    /**
     * 
     * METHOD: called once during initialisation to populate the world with a set number of pets.
     * 
     */
    private void populateSim()
    {
        // CREATE a for loop to iterate 10 times:
        for(int i = 0; i < 10; i++)
        {
            // CALL the method addEntity and ask for 10 JavaUrchins' to be added to the world:
            addEntity("JavaUrchin");
        }

        // REQUEST a JavaBubbler to place in the sim by calling the method addEntity with the argument "JavaBubbler":
        addEntity("JavaBubbler");

        // REQUEST a Bubble to place in the sim  - USED IN TESTING:
        //addEntity("Bubble",5.0,5.0);

        // REQUEST a FishFood to place in the sim - USED IN TESTING:
        //addEntity("FishFood", 5.0,5.0);

        // REQUEST a Pirhana to place in the sim:
        addEntity("Piranha");

    }

    /**
     * 
     * METHOD: used to add the entity to the aquarium by calling the ISim method addToken found in simulation
     * 
     * @param   _e   the entity to be added which contains the IToken within
     * 
     */
    private void addToWorld(IEntity _e)
    {
        // CHECK if the _manager field has been initialised:
        if(_worldManager == null)
        {
            return;
        }

        // ADD the IToken to world by getting the token within the IEntity and calling the addToken method:
        _worldManager.addToken(_e.getToken());
    }

    /**
     * 
     * METHOD: used to remove the entity display from the aquarium by calling the ISim method
     * 
     * @param   _e   the entity that contains the IToken which will be removed from the aquarium
     * 
     */
    private void removeFromWorld(IEntity _e)
    {
        // CHECK if the _manager field has been initialised:
        if(_worldManager == null)
        {
            return;
        }

        // CALL the removeToken method of the _manager field:
        _worldManager.removeToken(_e.getToken());

        // CALL the IBehaviour Terminate method();
        _e.getBehaviour().Terminate();
    }

    /**
     * 
     * METHOD: used to send a request to the factory for the type of pet required
     * 
     * @param   _type   the string that represents the pet required
     * @param   ...coords   the x & y coordinates used for the bubble placement
     * 
     * @return  IEntity   the entity the factory created and returned based on the params passed
     * 
     */
    private IEntity getNewEntity(String _type, double ...coords)
    {
        // CHECK if the _type string is null or empty:
        if(_type == null && _type.isEmpty())
        {
            // RETURN null as the request is wrong:
            return null;
        }

        // CHECK if the _factory field is initialised, used in testing:
        if(_factory != null)
        {
            // STORE the entity that is returned from calling the factory with the params passed:
            IEntity _entity = _factory.getEntity(_type, coords);

            return _entity;
        }
        
        return null;
    }

    /**
     * 
     * METHOD: used to add the entity to the simulation and into the _entities array to update by passing it the type of pet requested. Used for all pets
     * 
     * @param   _type   the type of pet required to place in the simulation
     * @param   ...coords   the x and y position used when creating a new "Bubble"
     * 
     */
    public void addEntity(String _type, double ...coords)
    {
        //System.out.println(_type + "  " + coords[0] + " " + coords[1]);

        // CHECK is the string is null, or empty: 
        if(_type == null && _type.isEmpty())
        {
            // EXIT as the param _type is null or empty:
            return;
        }

        // CALL the getNewEntity method by using the _type param and coords if passed:
        IEntity _entity = getNewEntity(_type, coords);

        // CHECK if the return IEntity is not NULL before adding to the array and the world:
        if(_entity != null)
        {
            // ADD the entity to the _newEntities array:
            _newEntities.add(_entity);

            // CALL the addToWorld method and pass the IEntity _e created above:
            addToWorld(_entity);
        }

    }

    /**
     * 
     * METHOD: used to add an IEntity to be removed from the _entities array. This method add the IEntity to the _removeEntities
     * array which is emptied on each loop.
     * 
     * @param   e   the IEntity that will be removed from the simulation
     * 
     */
    public void removeEntity(IEntity e)
    {
        // ADD the IEntity to the _removeEntities array:
        _removeEntities.add(e);

        // CALL the removeFromWorld method with the IEntity:
        removeFromWorld(e);   
    }

    /**
     * 
     * METHOD: used for adding and removing IEntity's found in the _newEntities & _removeEntities fields. This method uses the _entities array
     * that is passed to remove and add the IEntities. The _removeEntities and _newEntities are then cleared
     * 
     * @param   _entities   the List of IEntity's that will be altered based on the _newEntities and _removeEntities array's
     * 
     */
    public void checkEntities(List<IEntity> _entities)
    {
        // CALL the method removeAll on the List passed:
        _entities.removeAll(_removeEntities);

        // CALL the clear method on the _removeEntities array to remove all IEntities:
        _removeEntities.clear();

        // CALL the method addAll method on the List passed:
        _entities.addAll(_newEntities);

        // CALL the clear method on the _newEntities array to remove all IEntities:
        _newEntities.clear();
    }
}
