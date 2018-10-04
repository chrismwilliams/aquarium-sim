package UserCode.Manager;

import UserCode.Factory.IEntityCreatorFactory;
import UserCode.Factory.EntityCreatorFactory;
import UserCode.Pets.IEntity;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CollisionManagerTest for testing the CollisionManager production class.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions
 * 
 * 1) Construction (default): all fields are initialised as expected - do once via object bench.
 * 2) checkEntities(): check that the method removes a pet with the IComponent Prey class if it is near a pet with an
 * IComponent Preditor
 * 3) checkEntities(): check that the method doesn't remove a pet is the Preditor and Prey are not close
 * 
 */
public class CollisionManagerTest
{
    /**
     * Default constructor for test class CollisionManagerTest
     */
    public CollisionManagerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * 
     * checkEntities(): check that the method doesn't remove a pet is the Preditor and Prey are not close
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initialise a new instance of the IEntityCreatorFactory, call it '_factory':
        IEntityCreatorFactory _factory = new EntityCreatorFactory();

        // CALL the method getEntity with a Piranha pet:
        IEntity _piranha = _factory.getEntity("Piranha");
        
        // SET the position of the _piranha to 5.0,5.0,1.0;
        _piranha.getToken().setPosition(5.0,5.0,1.0);
        
        // CALL the method getEntity with a JavaSeaHorse pet:
        IEntity _fish = _factory.getEntity("JavaSeaHorse");
        
        // SET the position of the _piranha to 5.0,5.0,1.0;
        _fish.getToken().setPosition(7.0,5.0,1.0);
        
        // CREATE a new List to store the IEntity's, call it '_entityList':
        List<IEntity> _entityList = new ArrayList<IEntity>();
        
        // ADD the IEntity's to the _entityList:
        _entityList.add(_piranha);
        _entityList.add(_fish);
                
        // CREATE and initialise a new instance of the IEntityListManager, call it '_listMngr':
        IEntityListManager _listMngr = new EntityListManager();
        
        // CREATE and initialise a new instance of the ISubEntityMngr CollisionManager, call it '_collisionMngr':
        ISubEntityMngr _collisionMngr = new CollisionManager(_listMngr);
        
        // CALL the method checkEntities with the _entityList created:
        _collisionMngr.checkEntities(_entityList);
        
        // Type cast the _listMngr to be able to call the checkEntities method:
        ISubEntityMngr _subListMngr = (ISubEntityMngr) _listMngr;
        
        // CALL the checkEntities method to see if the method removes the IEntity:
        _subListMngr.checkEntities(_entityList);
        
        // CHECK if the _entityList does contain the _fish IEntity:
        assertTrue(_entityList.contains(_fish));
    }
    
    /**
     * 
     * checkEntities(): check that the method removes a pet with the IComponent Prey class if a pet with an
     * IComponent Preditor is placed next to it
     * 
     */
    @Test
    public void testCondition3()
    {
        // DECLARE and initialise a new instance of the IEntityCreatorFactory, call it '_factory':
        IEntityCreatorFactory _factory = new EntityCreatorFactory();

        // CALL the method getEntity with a Piranha pet:
        IEntity _piranha = _factory.getEntity("Piranha");
        
        // SET the position of the _piranha to 5.0,5.0,1.0;
        _piranha.getToken().setPosition(5.0,5.0,1.0);
        
        // CALL the method getEntity with a JavaSeaHorse pet:
        IEntity _fish = _factory.getEntity("JavaSeaHorse");
        
        // SET the position of the _piranha to 5.0,5.0,1.0;
        _fish.getToken().setPosition(5.0,5.0,1.0);
        
        // CREATE a new List to store the IEntity's, call it '_entityList':
        List<IEntity> _entityList = new ArrayList<IEntity>();
        
        // ADD the IEntity's to the _entityList:
        _entityList.add(_piranha);
        _entityList.add(_fish);
                
        // CREATE and initialise a new instance of the IEntityListManager, call it '_listMngr':
        IEntityListManager _listMngr = new EntityListManager();
        
        // CREATE and initialise a new instance of the ISubEntityMngr CollisionManager, call it '_collisionMngr':
        ISubEntityMngr _collisionMngr = new CollisionManager(_listMngr);
        
        // CALL the method checkEntities with the _entityList created:
        _collisionMngr.checkEntities(_entityList);
        
        // Type cast the _listMngr to be able to call the checkEntities method:
        ISubEntityMngr _subListMngr = (ISubEntityMngr) _listMngr;
        
        // CALL the checkEntities method to see if the method removes the IEntity:
        _subListMngr.checkEntities(_entityList);
        
        // CHECK if the _entityList doesn't contain the _fish IEntity:
        assertFalse(_entityList.contains(_fish));
    }
}
