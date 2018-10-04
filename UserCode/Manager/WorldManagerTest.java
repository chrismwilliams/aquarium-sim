package UserCode.Manager;

import env3d.Env;
import Framework.Core;
import UserCode.Pets.IToken;
import UserCode.Pets.Token;
import UserCode.Misc.ArgumentPathDoesNotExist;

import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WorldManagerTest for testing the production class WorldManager.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1) Construction (default): all fields are initialised as expected - do once via object bench.
 * 2) addToken(): check that the method adds an object to the _world
 * 3) removeToken(): check that the method removes an object from the _world
 * 
 */
public class WorldManagerTest
{
    /**
     * Default constructor for test class WorldManagerTest
     */
    public WorldManagerTest()
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
     * addToken(): check that the method adds an object to the _world
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE an instance of Token, call it '_token':
        IToken _token = null;

        // CORRECT use of throw tested in token:
        // CREATE a new instance of Token in the _token field with the JavaFish texture:
        try
        {
            _token = new Token("textures/javaFish/JavaFish.png");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // TESTED in token
        }

        // DECLARE and initialise a new Core instance, call it '_core':
        Core _core = new Core();

        // DECLARE and create a new world from the _core field, call it '_world':
        Env _world = _core.createWorld();

        // DECLARE and initialise a new instance of the IWorldManager class passing the _world ref:
        IWorldManager _worldMngr = new WorldManager(_world);

        // CALL the _worldMngr addObject and pass the IToken:
        _worldMngr.addToken(_token);

        // DECLARE and initialise a new IToken by calling the getObject method on the Env _world field:
        Collection _rtnTokens = _world.getObjects();

        // CHECK the size of _rtnTokens:
        assertFalse(_rtnTokens.isEmpty());

        // CHECK the _token sent is within the collection:
        assertTrue(_rtnTokens.contains(_token));
    }

    /**
     * 
     * removeToken(): check that the method removes an object from the _world
     * 
     */
    @Test
    public void testCondition3()
    {
        // DECLARE an instance of Token, call it '_token':
        IToken _token = null;

        // CORRECT use of throw tested in token:
        // CREATE a new instance of Token in the _token field with the JavaFish texture:
        try
        {
            _token = new Token("textures/javaFish/JavaFish.png");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // TESTED in token
        }

        // DECLARE and initialise a new Core instance, call it '_core':
        Core _core = new Core();

        // DECLARE and create a new world from the _core field, call it '_world':
        Env _world = _core.createWorld();

        // DECLARE and initialise a new instance of the IWorldManager class passing the _world ref:
        IWorldManager _worldMngr = new WorldManager(_world);

        // CALL the _worldMngr addObject and pass the IToken:
        _worldMngr.addToken(_token);

        // CALL the _worldMngr removeToken and pass the IToken:
        _worldMngr.removeToken(_token);

        // DECLARE and initialise a new IToken by calling the getObject method on the Env _world field:
        Collection _rtnTokens = _world.getObjects();

        // CHECK the size of _rtnTokens:
        assertTrue(_rtnTokens.isEmpty());
    }
}
