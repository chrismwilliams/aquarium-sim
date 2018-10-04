package UserCode.Manager;

import UserCode.Behaviours.IObservable;
import UserCode.Behaviours.IObserver;
import UserCode.Misc.MouseClickHandler;

import java.util.List;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MouseManagerTest for testing the production class MouseManager.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1) Construction (default): all fields are initialised as expected - do once via object bench.
 * 2) observeObj(): check if the IObservable class is added to the _subjects array
 * 3) endObserving(): check that the IObservable class is removed from the _subjects array
 * 
 */
public class MouseManagerTest
{
    /**
     * Default constructor for test class MouseManagerTest
     */
    public MouseManagerTest()
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
     * observeObj(): check that the field _clickHandler is assign correctly which calling this method with an IObservable
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initalise a new instance of the MouseClickHandler class:
        IObservable _clickSubject = new MouseClickHandler();

        // DEClARE and initialise a new instance of an IObserver class:
        IObserver _mouseObserver = new MouseManager();

        // INITIALISE the _mouseObserver to the IObservable field _clickHandler:
        _mouseObserver.observeObj(_clickSubject);

        // INITIALISE and assign a new List array by calling the rtnSubjects() method:
        List<IObservable> _observableList = _mouseObserver.rtnSubjects();

        // CHECK if list size is greater than 0:
        assertTrue(_observableList.size() > 0);
        
        // GET the IObservable from the array:
        IObservable _rtnObservable = _observableList.get(0);
        
        // CHECK the IObservable _clickSubject and the _rtnObservable are the same:
        assertSame(_clickSubject, _rtnObservable);
    }
    
    /**
     * 
     * endObserving(): Check check that the IObservable class is removed from the _subjects array which should be empty
     * 
     */
    @Test
    public void testCondition3()
    {
        // DECLARE and initalise a new instance of the MouseClickHandler class:
        IObservable _clickSubject = new MouseClickHandler();

        // DEClARE and initialise a new instance of an IObserver class:
        IObserver _mouseObserver = new MouseManager();

        // INITIALISE the _mouseObserver to the IObservable field _clickSubject:
        _mouseObserver.observeObj(_clickSubject);
        
        // CALL the endObserving method:
        _mouseObserver.endObserving(_clickSubject);

        // INITIALISE and assign a new List array by calling the rtnSubjects() method:
        List <IObservable> _observableList = _mouseObserver.rtnSubjects();

        // CHECK if the object in the List is set to null:
        assertNull(_observableList.get(0));
    }
}
