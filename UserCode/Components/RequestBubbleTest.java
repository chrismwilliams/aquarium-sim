package UserCode.Components;

import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Pets.IToken;
import UserCode.Pets.Token;
import UserCode.Pets.JavaFish;
import UserCode.Behaviours.IBehaviour;
import UserCode.Behaviours.RequestBubbleObserver;
import UserCode.Behaviours.IObservable;
import UserCode.Behaviours.IObserver;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RequestBubbleTest for testing the production class RequestBubble implementation of the IComponent
 * 
 * Test Conditions
 * 
 * 1) Construction: all fields are initialised as expected and checked once via the object bench using the Initialise method
 * 2) getUpdate(): check that the method is returning the correct position of the IBehaviour which request a bubble
 * 3) addObserver(). Check if the _observer field is assigned with an instance of IObserver after the method addObserver method is called
 * 4) removeObserver(). Check if the _observer field is assigned to null once this method is called
 *
 * @author  Chris Williams
 * @version 3.0
 */
public class RequestBubbleTest
{
    /**
     * Default constructor for test class RequestBubbleTest
     */
    public RequestBubbleTest()
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
     * Check if the getUpdate method returns the correct x and y position of the IBehaviour
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE an instance of Token, call it '_token':
        IToken _token = null;

        // CORRECT use of throw tested in token:
        // CREATE a new instance of Token in the _token field with the JavaFish texture:
        try
        {
            _token = new Token("textures/javaFish/JavaFish.png");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // TESTED in token
        }

        // DECLARE and initialise an instance of JavaFish, call it '_javaFish':
        IBehaviour _javaFish = new JavaFish(_token);

        // DECLARE and initialise an instance of the RequestBubble class, call it '_rBubble':
        IObservable _rBubble = new RequestBubble();

        // DELCARE and initialise a List to store the IComponent, call it '_compList':
        List<IComponent> _compList = new ArrayList<IComponent>();

        // ADD the IComponent to the arraylist:
        _compList.add((IComponent)_rBubble);

        // INITIALISE the JavaFish with the newly created IComponent:
        _javaFish.Initialise(_compList);

        // DECLARE and intialise an array of type double to store the call to getPosition, call it '_startPos':
        double[] _startPos = _token.getPosition();

        // CALL the IComponent getUpdate method and assign it to a double array, call it '_bubblePos':
        double[] _bubblePos = _rBubble.getUpdate();
        
        // CHECK the that both arrays are the same:
        assertEquals(_startPos[0], _bubblePos[0], 0.0);
        assertEquals(_startPos[1], _bubblePos[1], 0.0);

    }
    
    /**
     * 
     * METHOD: Test condition 3:
     * Check the IObserver _observer field is assigned correctly with an IObserver after calling addObserver()
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

        // CALL the method getObserver and both initialise and assign a reference to a new field, call it '_rtnObserver':
        IObserver _rtnObserver = _rBubble.getObserver();

        // CHECK if the _rBubbleObserver field is the same as the _rtnObserver and that the RequestBubble class
        // is assigning the field _observer correctly
        assertSame(_rBubbleObserver,_rtnObserver);
    }
    
    /**
     * 
     * METHOD: Test condition 4:
     * Test fails if the field _observer isn't assigned to null after calling the removeObserver() method
     * 
     */
    @Test
    public void testCondition4()
    {
        // DECLARE and initalise a new instance of the RequestBubble class:
        IObservable _rBubble = new RequestBubble();

        // DEClARE and initialise a new instance of an IObserver class to be used by the _rBubble:
        IObserver _rBubbleObserver = new RequestBubbleObserver();

        // INITIALISE the _rBubbleObserver to notify the and assign the IObservable class _rBubble:
        _rBubbleObserver.observeObj(_rBubble);

        // Tell the _rBubble field to assign the _observer field to null by calling remvoeObserver():
        _rBubble.removeObserver(_rBubbleObserver);

        // CALL the method getObserver and both initialise and assign a reference to a new field, call it '_rtnObserver':
        IObserver _rtnObserver = _rBubble.getObserver();

        // CHECK if the _observer field is set to null:
        assertNull(_rtnObserver);
    }
}
