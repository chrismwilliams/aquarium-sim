package UserCode.Behaviours;

import UserCode.Components.IComponent;
import UserCode.Components.RequestBubble;
import java.util.concurrent.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class setIntervalTest to test the production class setInterval
 * 
 * Test Conditions
 * 
 * 1) Construction: all fields are initialised as expected and checked once via the object bench using the Initialise method
 * 2) Test that the executor field is assigned correctly after calling the generateRequest method
 * 3) Test that the _runnable field is assigned correctly after calling the generateRequest method
 * 4) stopRequest(): Test that both executor and _runnable fields are assigned to null after a generateRequest is called, followed by stopRequest
 *
 * @author  Chris Williams
 * @version 3.0
 */
public class setIntervalTest
{
    /**
     * Default constructor for test class setIntervalTest
     */
    public setIntervalTest()
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
     * Test if the executor field is assigned correctly after calling the generateRequest method
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initialise an instance of the RequestBubble class, call it '_rBubble':
        IComponent _rBubble = new RequestBubble();

        // DECLARE and initialise an instance of the setInterval class, call it '_setInterval:
        IIntervalRequest _setInterval = new setInterval(_rBubble);
        
        // CHECK that it is null first:
        assertNull(_setInterval.getExecutor());
        
        // CALL the generateRequest() method of _setInterval:
        _setInterval.generateRequest();
        
        // CHECK again that it is not null:
        assertTrue(_setInterval.getExecutor() != null);
        
        // CHECK it is an instance of ScheduledExecutorService
        assertTrue(_setInterval.getExecutor() instanceof ScheduledExecutorService);
        
        

    }
    
    /**
     * 
     * METHOD: Test condition 3:
     * Test if the _runnable field is assigned correctly after calling the generateRequest method
     * 
     */
    @Test
    public void testCondition3()
    {
        // DECLARE and initialise an instance of the RequestBubble class, call it '_rBubble':
        IComponent _rBubble = new RequestBubble();

        // DECLARE and initialise an instance of the setInterval class, call it '_setInterval:
        IIntervalRequest _setInterval = new setInterval(_rBubble);
        
        // CHECK that it is null first:
        assertNull(_setInterval.getRunnable());
        
        // CALL the generateRequest() method of _setInterval:
        _setInterval.generateRequest();
        
        // CHECK again that it is not null:
        assertTrue(_setInterval.getRunnable() != null);
        
        // CHECK it is an instance of ScheduledExecutorService
        assertTrue(_setInterval.getRunnable() instanceof Runnable);
        
        

    }
    
    /**
     * 
     * METHOD: Test condition 4:
     * Test both executor and _runnable fields are null after a generateRequest is called, followed by stopRequest
     * 
     */
    @Test
    public void testCondition4()
    {
        // DECLARE and initialise an instance of the RequestBubble class, call it '_rBubble':
        IComponent _rBubble = new RequestBubble();

        // DECLARE and initialise an instance of the setInterval class, call it '_setInterval:
        IIntervalRequest _setInterval = new setInterval(_rBubble);
        
                
        // CALL the generateRequest() method of _setInterval:
        _setInterval.generateRequest();
        
        // CALL the stopRequest() method:
        _setInterval.stopRequest();
        
        // CHECK that both executor and _runnable fields are now null:
        assertNull(_setInterval.getExecutor());
        assertNull(_setInterval.getRunnable());

    }
}
