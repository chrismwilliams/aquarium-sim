package UserCode.Behaviours;

import UserCode.Components.RequestBubble;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RequestBubbleObserverTest for testing the IObserver RequestBubbleObserver production class
 *
 * 1) Construction: all fields are initialised as expected and checked once via the object bench using the Initialise method
 * 2) observeObj(): check if the IObservable class is added to the _subjects array
 * 3) endObserving(): check that the IObservable class is removed from the _subjects array
 *
 * @author  Chris Williams
 * @version 3.0
 */
public class RequestBubbleObserverTest
{
    /**
     * Default constructor for test class RequestBubbleObserverTest
     */
    public RequestBubbleObserverTest()
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
     * Test fails if the field _observer is assigned to null after calling the observeObj() method
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initalise a new instance of the RequestBubble class:
        IObservable _rBubble = new RequestBubble();

        // DEClARE and initialise a new instance of an IObserver class to be used by the _rBubble:
        IObserver _rBubbleObserver = new RequestBubbleObserver();

        // INITIALISE the _rBubbleObserver to notify the and assign the IObservable class _rBubble:
        _rBubbleObserver.observeObj(_rBubble);

        // INITIALISE and assign a new List array by calling the rtnSubjects() method:
        List <IObservable> _observableList = _rBubbleObserver.rtnSubjects();

        // CHECK if list size is greater than 0:
        assertTrue(_observableList.size() > 0);
        
        // GET the IObservable from the array:
        IObservable _rtnObservable = _observableList.get(0);
        
        // CHECK the IObservable _rBubble and the _rtnObservable are the same:
        assertSame(_rBubble, _rtnObservable);
    }
    
    /**
     * 
     * METHOD: Test condition 3:
     * Check check that the IObservable class is removed from the _subjects array after calling the endObserving method
     * 
     */
    @Test
    public void testCondition3()
    {
        // DECLARE and initalise a new instance of the RequestBubble class:
        IObservable _rBubble = new RequestBubble();

        // DEClARE and initialise a new instance of an IObserver class to be used by the _rBubble:
        IObserver _rBubbleObserver = new RequestBubbleObserver();

        // INITIALISE the _rBubbleObserver to notify the and assign the IObservable class _rBubble:
        _rBubbleObserver.observeObj(_rBubble);
        
        // CALL the endObserving method:
        _rBubbleObserver.endObserving(_rBubble);

        // INITIALISE and assign a new List array by calling the rtnSubjects() method:
        List <IObservable> _observableList = _rBubbleObserver.rtnSubjects();

        // CHECK if the array size is empty, the IObservable has been removed:
        assertTrue(_observableList.size() == 0);
    }
}
