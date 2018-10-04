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
 * The test class FeedManagerTest for testing the FeedManager production class.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions
 * 
 * 1) Construction (default): all fields are initialised as expected - do once via object bench.
 * 2) checkEntities(): check that the method removes the FishFood by placing a pet FishFood by a pet with the IComponent feed
 * 
 */
public class FeedManagerTest
{
    /**
     * Default constructor for test class FeedManagerTest
     */
    public FeedManagerTest()
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
     * checkEntities(): check that the method removes the FishFood by placing a pet FishFood by a pet with the IComponent feed
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initialise a new instance of the IEntityCreatorFactory, call it '_factory':
        IEntityCreatorFactory _factory = new EntityCreatorFactory();

        // CALL the method getEntity with a pet that has the feed IComponent:
        IEntity _urchin = _factory.getEntity("JavaUrchin");
        
        // INITIALISE and assign a double array with the position of JavaUrchin, call it '_pos':
        double[] _pos = _urchin.getToken().getPosition();
        
        // CALL the method getEntity for a pet FishFood at the same location:
        IEntity _fishFood = _factory.getEntity("FishFood", _pos[0], _pos[1]);
        
        // CREATE a new List to store the IEntity's, call it '_entityList':
        List<IEntity> _entityList = new ArrayList<IEntity>();
        
        // ADD the IEntity's to the _entityList:
        _entityList.add(_urchin);
        _entityList.add(_fishFood);
        
        // CREATE and initialise a new instance of the IEntityListManager, call it '_listMngr':
        IEntityListManager _listMngr = new EntityListManager();
        
        // CREATE and initialise a new instance of the ISubEntityMngr FeedManager, call it '_feedMngr':
        ISubEntityMngr _feedMngr = new FeedManager(_listMngr);
        
        // CALL the method checkEntities with the _entityList created:
        _feedMngr.checkEntities(_entityList);
        
        // Type cast the _listMngr to be able to call the checkEntities method:
        ISubEntityMngr _subListMngr = (ISubEntityMngr) _listMngr;
        
        // CALL the checkEntities method to see if the method removes the IEntity:
        _subListMngr.checkEntities(_entityList);
        
        // CHECK if the _entityList doesn't contain the _fishFood IEntity:
        assertFalse(_entityList.contains(_fishFood));
    }
}
