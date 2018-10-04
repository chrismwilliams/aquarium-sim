package UserCode.Components;

import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Pets.IToken;
import UserCode.Pets.Token;
import UserCode.Pets.JavaFish;
import UserCode.Behaviours.IBehaviour;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MoveHorizontalTest.
 * 
 * Test Conditions
 * 
 * 1) Construction: all fields are initialised as expected and checked once via the object bench using the Initialise method
 * 2) update(): check that the update method increments the x position of the IBehaviour
 * 3) componentAction(): check that the method changes the _vector field correctly and the x position now decrements
 *
 * @author  Chris Williams
 * @version 3.0
 */
public class MoveHorizontalTest
{
    /**
     * Default constructor for test class MoveHorizontalTest
     */
    public MoveHorizontalTest()
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
     * Check if the update method increments the x position of the IBehaviour
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

        // DECLARE and initialise an instance of the MoveHorizontal class, call it '_mHorizontal':
        IComponent _mHorizontal = new MoveHorizontal(1.0, 9.0);

        // DELCARE and initialise a List to store the IComponent, call it '_compList':
        List<IComponent> _compList = new ArrayList<IComponent>();

        // ADD the IComponent to the arraylist:
        _compList.add(_mHorizontal);

        // INITIALISE the JavaFish with the newly created IComponent:
        _javaFish.Initialise(_compList);

        // DECLARE and intialise an array of type double to store the call to getPosition, call it '_startPos':
        double[] _startPos = _token.getPosition();

        // CALL the IComponent method update to see if the token's x position is incremented:
        _mHorizontal.update();

        // DECLARE and initialise another array to check if the x value has changed:
        double[] _rtnPos = _token.getPosition();

        // CHECK if the x values are the same:
        if(_startPos[0] == _rtnPos[0])
        {
            // FAILED to increment the x position:
            fail("The x position hasn't been incremented");
        }

    }
    
    /**
     * 
     * METHOD: Test condition 3:
     * Check if the componentAction method changes the vector field and the x position of the IBehaviour now decrements
     * 
     */
    @Test
    public void testCondition3()
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

        // DECLARE and initialise an instance of the MoveHorizontal class, call it '_mHorizontal':
        IComponent _mHorizontal = new MoveHorizontal(1.0, 9.0);

        // DELCARE and initialise a List to store the IComponent, call it '_compList':
        List<IComponent> _compList = new ArrayList<IComponent>();

        // ADD the IComponent to the arraylist:
        _compList.add(_mHorizontal);

        // INITIALISE the JavaFish with the newly created IComponent:
        _javaFish.Initialise(_compList);

        // DECLARE and intialise an array of type double to store the call to getPosition, call it '_startPos':
        double[] _startPos = _token.getPosition();

        // CALL the IComponent method componentAction to see change the vector to now decrement once the update method is called:
        _mHorizontal.componentAction();
        
        // CALL the update method of the IComponent to decrement to x position:
        _mHorizontal.update();

        // DECLARE and initialise another array to check if the x value has changed:
        double[] _rtnPos = _token.getPosition();

        // CHECK if the x values are the same or less than:
        if(_startPos[0] <= _rtnPos[0])
        {
            // FAILED to change the vector:
            System.out.println("Start: " + _startPos[0] + " Return: " + _rtnPos[0]);
            fail("The x position hasn't been decremented by changing the vector");
            
        }
    }
}
