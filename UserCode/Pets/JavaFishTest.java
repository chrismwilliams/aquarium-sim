package UserCode.Pets;

import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Behaviours.IBehaviour;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JavaFishTest for testing the JavaFish production class.
 *
 * @author  Chris Williams & Marc Price
 * @version 3.0
 * 
 * 1: Construction: all fields are initialised as expected and checked once via the object bench
 * 2: Construction: check that the inherited setOrienation set the orientation of the pet to 0,-90,0
 * 3: Construction: check that the inherited setStartPosition("top") sets a position on the y axis between 2.0 - 6.8 
 * 
 */
public class JavaFishTest
{
    /**
     * Default constructor for test class JavaFishTest
     */
    public JavaFishTest()
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
     * Check if the super class setOrientation sets the fields correctly within the token
     * The X and Z orientation should be set to 0 
     * The Y orientation should be set as -90 in token
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

        // DECLARE and intialise an array of type double to store the call to getOrientation, call it '_rtnOrientation':
        double[] _rntOrientation = _token.getOrientation();

        // CHECK if the X orientation in _token is 0
        assertEquals(_rntOrientation[0], 0.0, 0.0);
        
        // CHECK if the Y orientation in _token is -90
        assertEquals(_rntOrientation[1], -90.0, 0.0);
        
        // CHECK if the Z orientation in _token is 0
        assertEquals(_rntOrientation[2], 0.0, 0.0);
    }

    /**
     * 
     * METHOD: Test condition 3:
     * setStartPosition("top"): Check that the inherited method sets a position on the y axis between 2.0 - 6.8
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

        // DECLARE and initialise a double from calling the _javaFish.getPosition method to get the current y position, call it '_posY'::
        double _posY = _javaFish.getPosition()[1];

        // CHECK if the Y axis position is between 2.0 and 6.8:
        if(_posY < 2.0 || _posY > 6.8)
        {
            // TEST failed
            fail("The starting Y position isn't between the values 2.0 and 6.8");
        }

    }
}
