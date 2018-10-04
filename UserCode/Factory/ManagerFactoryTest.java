package UserCode.Factory;

import env3d.Env;
import Framework.Core;

import UserCode.Manager.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ManagerCreatorTest for testing the production class ManagerCreator.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1) Construction (default): all fields are initialised as expected - do once via object bench.
 * 2) getEntityManager(): check that the constructor is initialising the managers required, in this instance the IEntityManager class 
 * 
 */
public class ManagerFactoryTest
{
    /**
     * Default constructor for test class ManagerCreatorTest
     */
    public ManagerFactoryTest()
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
     * getSoundManager(): test the constructor is creating the EntityManager correctly
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initialise a new Core instance, call it '_core':
        Core _core = new Core();

        // DECLARE and create a new world from the _core field, call it '_world':
        Env _world = _core.createWorld();
                        
        // DECLARE and initialise a test IManagerFactory class, call it '_mFactory':
        IManagerFactory _mFactory = new ManagerFactory(_world);
        
        // CALL the _mCreator getEntityManager method:
        IEntityManager _eManager = _mFactory.getEntityManager();
        
        // CHECK it's not null:
        assertNotNull(_eManager);
        
        // CHECK the _sManager field is an instanceof the EntityManger class:
        assertTrue(_eManager instanceof EntityManager);
    }
}
