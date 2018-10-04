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
 * The test class WorldBoundsManagerTest for testing the WorldBoundsManager production class.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions
 * 
 * 1) Construction (default): all fields are initialised as expected - do once via object bench.
 * 2) checkEntities(): check that the method removes a pet that is outside the _minY & _maxY fields
 * 
 */
public class WorldBoundsManagerTest
{
    /**
     * Default constructor for test class WorldBoundsManagerTest
     */
    public WorldBoundsManagerTest()
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
     * checkEntities(): check that the method removes a pet that is outside the _minY & _maxY fields
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initialise a new instance of the IEntityCreatorFactory, call it '_factory':
        IEntityCreatorFactory _factory = new EntityCreatorFactory();

        // CALL the method getEntity with a Bubble pet that is position outside the aquarium:
        IEntity _bubble = _factory.getEntity("Bubble", 12.0, 12.0);
        
        // CREATE a new List to store the IEntity's, call it '_entityList':
        List<IEntity> _entityList = new ArrayList<IEntity>();
        
        // ADD the IEntity to the _entityList:
        _entityList.add(_bubble);
                
        // CREATE and initialise a new instance of the IEntityListManager, call it '_listMngr':
        IEntityListManager _listMngr = new EntityListManager();
        
        // CREATE and initialise a new instance of the ISubEntityMngr WorldBoundsManager, call it '_boundsMngr':
        ISubEntityMngr _boundsMngr = new WorldBoundsManager(_listMngr);
        
        // CALL the method checkEntities with the _entityList created:
        _boundsMngr.checkEntities(_entityList);
        
        // Type cast the _listMngr to be able to call the checkEntities method:
        ISubEntityMngr _subListMngr = (ISubEntityMngr) _listMngr;
        
        // CALL the checkEntities method to see if the method removes the IEntity:
        _subListMngr.checkEntities(_entityList);
        
        // CHECK if the _entityList doesn't contain the _bubble IEntity:
        assertFalse(_entityList.contains(_bubble));
    }
}