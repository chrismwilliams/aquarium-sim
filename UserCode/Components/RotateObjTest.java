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
 * The test class RotateObjTest for testing the production class RotateObj
 * 
 * Test Conditions
 * 
 * 1) Construction: all fields are initialised as expected and checked once via the object bench using the Initialise method
 * 2) componentAction(): Test that the method flips the y orientation of the image set in the _token
 *
 * @author  Chris Williams
 * @version 3.0
 */
public class RotateObjTest
{
    /**
     * Default constructor for test class RotateObjTest
     */
    public RotateObjTest()
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
     * Check if the componentAction method flips the y orientation of the image
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

        // DECLARE and initialise an instance of the RotateObj class, call it '_rotateObj':
        IComponent _rotateObj = new RotateObj();

        // DELCARE and initialise a List to store the IComponent, call it '_compList':
        List<IComponent> _compList = new ArrayList<IComponent>();

        // ADD the IComponent to the arraylist:
        _compList.add(_rotateObj);

        // INITIALISE the JavaFish with the newly created IComponent:
        _javaFish.Initialise(_compList);

        // DECLARE and intialise an array of type double to store the call to getOrientation, call it '_startingOrientation':
        double[] _startingOrientation = _token.getOrientation();

        // CALL the IComponent method componentAction to see if the image is rotated on the y axis:
        _rotateObj.componentAction();

        // DECLARE and initialise another array to check if the y value has changed:
        double[] _rtnOrientation = _token.getOrientation();

        // FIRST check the y values are not the same:
        if(_startingOrientation[1] == _rtnOrientation[1])
        {
            // FAIL to flip the image:
            fail("The y orientation hasn't been changed");
        }

        // CHECK that the y values are oppersite:
        if((_startingOrientation[1] * -1) != _rtnOrientation[1])
        {
            // FAIL
			fail("The y orientation hasn't been set to the oppersite");
        }
    }
}
