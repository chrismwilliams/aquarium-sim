package UserCode.Manager;

import UserCode.Pets.IEntity;

import java.util.List;
import java.util.ArrayList;

/**
 * EntityManager: The manager controls all the entities within the aquarium by calling each ISubEntityMngr checkEntities
 * method on every frame
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class EntityManager implements IEntityManager
{
    // DECLARE an ArrayList of IEntity types to store a list of entities to manage, call it '_entities':
    private List<IEntity> _entities;

    // DECLARE an instance of the ISubEntityManager for managing the world bounds, call it '_boundsMngr':
    private ISubEntityMngr _boundsMngr;

    // DECLARE an instance of the ISubEntityMngr for collisions, call it '_collisionMngr':
    private ISubEntityMngr _collisionMngr;

    // DECLARE an instance of the ISubEntityMngr for feeding, call it '_feedMngr':
    private ISubEntityMngr _feedMngr;

    // DECLARE an instnace of the ISubEntityMngr for managing prey levels, call it '_preyLvlMngr':
    private ISubEntityMngr _preyLvlMngr;

    // DECLARE an instance of the ISubEntityMngr for adding and removing pets, call it '_entityListMngr':
    private ISubEntityMngr _entityListMngr;

    /**
     * @Deprecated
     * Default Constructor for objects of class EntityManager. Used for testing purposes only
     *
     */
    @Deprecated
    public EntityManager()
    {
        // INTIALISE _entities ArrayList to store IEntity types:
        _entities = new ArrayList<IEntity>();
    }

    /**
     * Constructor for objects of class EntityManager
     * 
     * @param   boundsMngr   used to check if any IEntity's have left the aquarium on the y axis
     * @param   collisionMngr   used to check if any Preditor has collided and eaten prey IEntities
     * @param   feedMngr   used to check for instances of FishFood and a collision which other pets
     * @param   preyLvlMngr   used to check the amount of prey fish
     * @param   entityListMngr   used to add and remove IEntities from the _entities List
     * 
     */
    public EntityManager(ISubEntityMngr boundsMngr, ISubEntityMngr collisionMngr, ISubEntityMngr feedMngr, 
    ISubEntityMngr preyLvlMngr, ISubEntityMngr entityListMngr)
    {
        // INITIALISE _entities ArrayList to store IEntity types:
        _entities = new ArrayList<IEntity>();

        // INITIALISE the _boundsMngr field;
        _boundsMngr = boundsMngr;

        // INITIALISE the _collisionMngr field:
        _collisionMngr = collisionMngr;

        // INTIALISE the _feedMngr field:
        _feedMngr = feedMngr;

        // INITIALISE the _preyLvlMngr field:
        _preyLvlMngr = preyLvlMngr;

        // INITIALISE the _entityListMngr field:
        _entityListMngr = entityListMngr;                
    }

    /**
     * @Deprecated
     * METHOD: Used to return the _entities array used in testing
     * 
     * @return  a List of all the entities added
     * 
     */
    @Deprecated
    public List getEntitiesArray()
    {
        // RETURN the arraylist _entities to the caller:
        return _entities;
    }

    /**
     * 
     * METHOD: update method which loops through the entire _entities array and updates all behaviours within each entity. This method then calls
     * the checkEntities method on all the ISubEntityMngr's to manager changes to the _entities array:
     * 
     * 
     */
    public void update()
    {
        // LOOP through all the IEntities in the _entities array:
        for(IEntity _e : _entities)
        {
            // CALL the IEntity method update:
            _e.update();

            // System.out.println("Updating entities");
            // System.out.println(_entities.size());
        }        

        // CALL the _collisionMngr checkEntities method:
        _collisionMngr.checkEntities(_entities);

        // CALL the _feedMngr checkEntities method:
        _feedMngr.checkEntities(_entities);

        // CALL the _preyLvlMngr checkEntities method:
        _preyLvlMngr.checkEntities(_entities);

        // CALL the _boundsMngr checkEntities method:
        _boundsMngr.checkEntities(_entities);

        // CALL the _entityListMngr checkEntities method:
        _entityListMngr.checkEntities(_entities);

    }
}