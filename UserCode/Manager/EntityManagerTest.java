package UserCode.Manager;

import UserCode.Pets.IEntity;

import env3d.Env;
import Framework.Core;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EntityManagerTest for testing EntityManager. Testing with the default constructor as the overloaded constructor
 * requires the Simulation and SoundManager as dependencies
 *
 * @author  Chris Williams & Marc Price
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1: Construction (default): all fields are initialised as expected apart from the fields _simCallBack and _soundManager via the object bench 
 * 2: update(): this method requires all the ISubEntityMngr's to be constructed and the Env world created. This methods functionality was testing
 * by running the simulation and using system print out's within this method and many of the sub managers to see if the method works as intended.
 * 
 */
public class EntityManagerTest
{

    /**
     * Default constructor for test class EntityManagerTest
     */
    public EntityManagerTest()
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

    
}
