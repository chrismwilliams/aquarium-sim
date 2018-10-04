package UserCode.Factory;

import UserCode.Pets.IToken;
import UserCode.Pets.IEntity;
import UserCode.Behaviours.IBehaviour;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EntityCreatorFactoryTest, used to test the EntitiyCreatorFactory. Testing with the default constructor
 * as the overloaded constructor requires the EntityManager class as a dependancy
 *
 * @author  Chris Williams & Marc Price
 * @version 1.5
 * 
 * Test Conditions:
 * 
 * 1: Construction (default): all fields are initialised as expected apart from the _manager field, done via the object bench
 * 2: getEntity(): does the method return a null instance after passing a pet name that doesn't exist
 * 3: getEntity(): does the method return an IEntity type after requesting a pet that exists
 * 4: getEntity(): check if the method creates an IEntity of type FishFood at the coords passed
 * 
 */
public class EntityCreatorFactoryTest
{
    /**
     * Default constructor for test class EntityCreatorFactoryTest
     */
    public EntityCreatorFactoryTest()
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
     * METHOD: Test condition 2:
     * getEntity() method returns null if the param _type is set to a pet that doesn't exist. Used by the method getNewEntity in EntityManager when
     * deciding to add the return to the _entities array and the world to avoid a null exception
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initialise a new instance of the EntityCreatorFactory, call it '_factory':
        IEntityCreatorFactory _factory = new EntityCreatorFactory();

        // CALL the method getEntity with a pet that doesn't exist:
        IEntity _entity = _factory.getEntity("Java");

        // CHECK if it is null:
        assertNull(_entity);
        
    }
    
    /**
     * 
     * METHOD: Test condition 3:
     * getEntity() method returns an IEntity consisting of a _token and a correct _behaviour
     * 
     */
    @Test
    public void testCondition3()
    {
        // DECLARE and initialise a new instance of the IEntityCreatorFactory, call it '_factory':
        IEntityCreatorFactory _factory = new EntityCreatorFactory();

        // CALL the method getEntity with a pet that exists:
        IEntity _entity = _factory.getEntity("JavaUrchin");

        // CHECK if it is an instanceof IEntity
        assertTrue(_entity instanceof IEntity);
        
        // CHECK the _entity has an instanceof IToken and IBehaviour:
        assertTrue(_entity.getToken() instanceof IToken);
        assertTrue(_entity.getBehaviour() instanceof IBehaviour);
    }
    
    /**
     * 
     * METHOD: Test condition 4:
     * getEntity() method should use the param's passed to place the class FishFood with the x and y passed
     * 
     */
    @Test
    public void testCondition4()
    {
        // DECLARE and initialise a new instance of the IEntityCreatorFactory, call it '_factory':
        IEntityCreatorFactory _factory = new EntityCreatorFactory();

        // CALL the method getEntity with a pet that exists:
        IEntity _entity = _factory.getEntity("FishFood", 5.0, 5.0);

        // CHECK if _token has the x and y values of 5.0:
        IToken _token = _entity.getToken();
        
        // CHECK the _token x and y positions are 5.0:
        assertEquals(_token.getPosition()[0], 5.0, 0.0);
        assertEquals(_token.getPosition()[1], 5.0, 0.0);
    }
    
}
