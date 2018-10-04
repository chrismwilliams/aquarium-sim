package UserCode.Manager;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PreyLvlManagerTest for testing the PreyLvlManager production class.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions
 * 
 * 1) Construction (default): all fields are initialised as expected - do once via object bench.
 * 2) checkEntities(): check if the method adds a number of IEntity's based on the IEntity's within the _entities array passed. This
 * test is performed by running the simulation as it requires a number of concrete implementations to be created. This was tested by
 * printing out the amount passed to the method topUpPreyLvls and checking the _entities size in the class EntityManager
 * 3) checkEntities(): check that if the _entities array is full of prey's the method doesn't add more prey IEntity's. This again was
 * tested using the system print's of the amout passed to topUpPreyLvls and checking the _entities array doesn't increase
 * 
 */
public class PreyLvlManagerTest
{
    /**
     * Default constructor for test class PreyLvlManagerTest
     */
    public PreyLvlManagerTest()
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
