package UserCode.Manager;

import UserCode.Misc.ArgumentPathDoesNotExist;
import env3d.Env;
import Framework.Core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SoundManagerTest, for testing SoundManager. The 2nd and 3rd tests have to be done seperatly as the Java Platform crashes
 *
 * @author  Chris Williams & Marc Price
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1: Construction (default): all fields are initialised as expected - do once via object bench. Needs the Core.CreateWorld()
 * dependancy during construction
 * 2: playSound(): throws an ArgumentPathDoesNotExist exception if the path provided to method is incorrect
 * 3: playSound(): plays the sound and doesn't throw an exception if the path provided to method is correct
 * 
 */
public class SoundManagerTest
{
    /**
     * Default constructor for test class SoundManagerTest
     */

    public SoundManagerTest()
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
        // DECLARE and initialise a new Core instance, call it '_core':
        //_core = new Core();

        // DECLARE and create a new world from the _core field, call it '_world':
        // _world = _core.createWorld();

        //_soundManager = new SoundManager(_world);

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        // EXIT the environment:
        //_core.destroyWorld();
    }

    /**
     * METHOD: Test condition 2:
     * Method throws exception if the filename does not exist
     */
    @Test
    public void testCondition2()
    {
        // DECLARE a boolean to assign the result of the test to, call it 'pass':
        // INITIALISE it to 'false' before the test:
        boolean pass = false;

        // DECLARE and initialise a new SoundManager with the _world instance, call it '_soundManager':
        ISoundManager _soundManager = new SoundManager();

        // DECLARE a String to hold the path to the audio file, call it '_audio':
        // INITIALISE it to "sounds/pop" which doesn't exist:
        String _audio = "sounds/pop";

        // PASS if an ArgumentOutOfBoundsException is thrown as path does not exist:
        try
        {
            // CALL the method playSound of SoundManager and pass the _audio field as the argument to play:
            //SoundManager _soundManager = new SoundManager(_world);
            _soundManager.playSound(_audio);
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // Exception thrown so the test passed:
            pass = true;
        }

        if (!pass)
        {
            // Exception not thrown so test failed
            fail("ArgumentPathDoesNotExist was not thrown when SoundManager played a track that doesn't exist");
        }
    }

    /**
     * METHOD: Test condition 3:
     * Method does not throw an exception if the filename exists
     */
    @Test
    public void testCondition3()
    {
        // DECLARE a boolean to assign the result of the test to, call it 'pass':
        // INITIALISE it to 'false' before the test:
        boolean pass = false;

        // DECLARE and initialise a new Core instance, call it '_core':
        Core _core = new Core();

        // DECLARE and create a new world from the _core field, call it '_world':
        Env _world = _core.createWorld();

        // DECLARE and initialise a new SoundManager with the _world instance, call it '_soundManager':
        ISoundManager _soundManager = new SoundManager(_world);

        // DECLARE a String to hold the path to the audio file, call it '_audio':
        // INITIALISE it to "sounds/pop.wav" which does exist this time:
        String _audio = "sounds/pop.wav";

        // PASS if an ArgumentOutOfBoundsException is thrown as path does not exist:
        try
        {
            // CALL the method playSound of SoundManager and pass the _audio field as the argument to play:
            _soundManager.playSound(_audio);

            // TEST passed:
            pass = true;
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // Exception thrown so the test failed:
            pass = false;

        }

        if (!pass)
        {
            // Exception thrown so test failed
            fail("ArgumentPathDoesNotExist was thrown with a track that exists");
        }
    }
}