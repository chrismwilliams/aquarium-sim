package UserCode.Misc;

import UserCode.Manager.MouseManager;
import UserCode.Behaviours.IObserver;
import env3d.Env;
import Framework.Core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MouseClickHandlerTest.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1) getWorldRef(). Check if the _world field is assigned correctly once when a new instance of MouseClickHandler is created
 * 2) addObserver(). Check if the _observer field is assigned with an instance of IObserver after the method addObserver method is called
 * 3) removeObserver(). Check if the _observer field is assigned to null once this method is called
 * 4) getUpdate(). Check if the method returns an array of doubles
 */
public class MouseClickHandlerTest
{
    /**
     * Default constructor for test class MouseClickHandlerTest
     */
    public MouseClickHandlerTest()
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
     * METHOD: Test condition 1:
     * Throws an error if the _world field isn't assigned correctly with the Env used in construction
     * 
     */
    @Test
    public void testCondition1()
    {
        // DECLARE and initialise a new Core instance, call it '_core':
        Core _core = new Core();

        // DECLARE and create a new world from the _core field, call it '_world':
        Env _world = _core.createWorld();

        // DECLARE and initalise a new instance of the MouseClickHandler class passing the reference to the Env created:
        IMouseClickHandler _mouseHandler = new MouseClickHandler(_world);

        // CHECK if _mouseHandler has assigned the field _world correctly:
        // CALL getWorldRef method and initialise and assign the reference to a new field, call it '_worldReturned':
        Env _worldReturned = _mouseHandler.getWorldRef();

        // CHECK if the _world created and the _worldReturned are the same:
        assertSame(_world,_worldReturned);

    }
    
    /**
     * 
     * METHOD: Test condition 2:
     * Throws an error if the field _observer isn't assigned correctly with an IObserver after calling addObserver()
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initalise a new instance of the MouseClickHandler class using the testing constructor:
        IMouseClickHandler _mouseHandler = new MouseClickHandler();

        // DELCARE and initialise a new instance of an IObserver class to be used by the _mouseHandler:
        IObserver _mouseObserver = new MouseManager();

        // INITIALISE the _mouseObserver and _mouseHandler to notify the presence of each other:
        _mouseObserver.observeObj(_mouseHandler);

        // CALL the method getObserver and both initialise and assign a reference to a new field, call it '_rtnObserver':
        IObserver _rtnObserver = _mouseHandler.getObserver();

        // CHECK if the _mouseObserver field is the same as the _rtnObserver and the MouseClickHandler class
        // is assigning the field _observer correctly
        assertSame(_mouseObserver,_rtnObserver);
    }

    /**
     * 
     * METHOD: Test condition 3:
     * Throws an error if the field _observer isn't assigned to null after calling the removeObserver() method
     * 
     */
    @Test
    public void testCondition3()
    {
        // DECLARE and initalise a new instance of the MouseClickHandler class using the testing constructor:
        IMouseClickHandler _mouseHandler = new MouseClickHandler();

        // DELCARE and initialise a new instance of an IObserver class to be used by the _mouseHandler:
        IObserver _mouseObserver = new MouseManager();

        // INITIALISE the _mouseObserver and _mouseHandler to notify the presence of each other:
        _mouseObserver.observeObj(_mouseHandler);

        // Tell the _mouseHandler to assign the _observer field to null by calling remvoeObserver():
        _mouseHandler.removeObserver(_mouseObserver);

        // CALL the method getObserver and both initialise and assign a reference to a new field, call it '_rtnObserver':
        IObserver _rtnObserver = _mouseHandler.getObserver();

        // CHECK if the _observer field is set to null:
        assertNull(_rtnObserver);
    }

    /**
     * 
     * METHOD: Test condition 4:
     * Throws an error if the IMouseClickHandler returns an array of doubles when the getUpdate() method is called
     * The values returned should be double[-1.0,-1.0]
     * 
     */
    @Test
    public void testCondition4()
    {
        // DECLARE and initalise a new instance of the MouseClickHandler class using the testing constructor:
        IMouseClickHandler _mouseHandler = new MouseClickHandler();

        // DELCARE and initialise a new instance of an IObserver class to be used by the _mouseHandler:
        IObserver _mouseObserver = new MouseManager();

        // INITIALISE the _mouseObserver and _mouseHandler to notify the presence of each other:
        _mouseObserver.observeObj(_mouseHandler);
        
        // INITIALISE and assign an array of double by calling the getUpdate() method, call it '_rtnMousePos':
        double[] _rtnMousePos = _mouseHandler.getUpdate();
        
        // CHECK if the first _rtnMousePos is equal to -1.0:
        assertEquals(_rtnMousePos[0], -1.0, 0.0);
        
        // CHECK if the second _rtnMousePos is equal to -1.0:
        assertEquals(_rtnMousePos[1], -1.0, 0.0);
    }
}
