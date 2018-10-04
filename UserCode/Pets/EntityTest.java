package UserCode.Pets;

import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Behaviours.IBehaviour;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EntityTest to test the Enity class.
 *
 * @author  Chris Williams & Marc Price
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1: Construction: all fields are initialised as expected and checked via the object bench
 * 2: getToken(): check that the method returns an instance of IToken
 * 3: getBehaviour(): check that the method returns an instance of IBehaviour
 * 
 */
public class EntityTest
{
    /**
     * Default constructor for test class EntityTest
     */
    public EntityTest()
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
     * Check if the getToken() method returns an instance of IToken and is the same one created
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

        // CHECK if the method getToken returns an instance of IToken:
        if(!(_entity.getToken() instanceof IToken))
        {
            // TEST failed
            fail("The Y orientation doesn't match");
        }
        
        // CHECK if the _token initialised is the same returned from the _entity:
        assertSame(_token, _entity.getToken()); 

    }
    
    /**
     * 
     * METHOD: Test condition 3:
     * Check if the getBehaviour() method returns an instance of IBehaviour and is the same one created
     * 
     */
    @Test
    public void testCondition3()
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

        // CHECK if the method getBehaviour returns an instance of IBehaviour:
        if(!(_entity.getBehaviour() instanceof IBehaviour))
        {
            // TEST failed
            fail("The Y orientation doesn't match");
        }
        
        // CHECK if the _bubble field is the same as the _entity IBehaviour field send:
        assertSame(_bubbler, _entity.getBehaviour());
    }
}
