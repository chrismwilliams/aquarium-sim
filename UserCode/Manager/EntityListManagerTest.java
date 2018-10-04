package UserCode.Manager;

import UserCode.Pets.IToken;
import UserCode.Pets.Token;
import UserCode.Pets.JavaBubbler;
import UserCode.Pets.IEntity;
import UserCode.Pets.Entity;
import UserCode.Behaviours.IBehaviour;
import UserCode.Misc.ArgumentPathDoesNotExist;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EntityListManagerTest for testing the production class EntityListManager.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1) Construction (default): all fields are initialised as expected - do once via object bench.
 * 2) checkEntities(): check that the method removes IEntity's to the List passed
 * 
 */
public class EntityListManagerTest
{
    /**
     * Default constructor for test class EntityListManagerTest
     */
    public EntityListManagerTest()
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
     * checkEntities(): check that the method removes IEntity's to the List passed
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE an instance of Token, call it '_token':
        IToken _token = null;

        // CORRECT use of throw tested in token:
        try
        {
            _token = new Token("textures/javaFish/Bubbler.png");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // TESTED in token
        }

        // DECLARE and initialise an instance of JavaBubbler, call it 'JavaBubbler':
        IBehaviour _bubbler = new JavaBubbler(_token);

        // DECLARE and initialise an instance if IEntity with the _token and _bubbler, call it '_entity':
        IEntity _entity = new Entity(_token,_bubbler);
        
        // CREATE a new List to store the IEntity, call it '_entityList':
        List<IEntity> _entityList = new ArrayList<IEntity>();
        
        // ADD the _entity to the _entityList:
        _entityList.add(_entity);
        
        // CREATE and initialise a new instance of the IEntityListManager, call it '_listMngr':
        IEntityListManager _listMngr = new EntityListManager();
        
        // CALL the removeEntity method with the _entity created: 
        _listMngr.removeEntity(_entity);
        
        // Type cast the _listMngr to be able to call the checkEntities method:
        ISubEntityMngr _subListMngr = (ISubEntityMngr) _listMngr;
        
        // CALL the checkEntities method to see if the method removes the IEntity:
        _subListMngr.checkEntities(_entityList);
        
        // CHECK that the _entityList does not contain the _entity:
        assertTrue(_entityList.size() == 0);
    }
    
}
