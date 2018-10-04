package UserCode.Pets;

import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Behaviours.IBehaviour;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JavaBubblerTest for testing the JavaBubbler production class.
 *
 * @author  Chris Williams & Marc Price
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1: Construction: all fields are initialised as expected and checked via the object bench
 * 2: Construction: check that the inherited setOrientation sets the orientation to 90,90,0
 * 
 */
public class JavaBubblerTest
{
    /**
     * Default constructor for test class JavaBubblerTest
     */
    public JavaBubblerTest()
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
     * The X and Y orientation should be set as 90 in token
     * The Z orientation should be 0 in token
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

        // DECLARE and intialise an array of type double to store the call to getOrientation, call it '_rtnOrientation':
        double[] _rntOrientation = _token.getOrientation();

        // CHECK if the X orientation in _token is 90:
        assertEquals(_rntOrientation[0], 90.0, 0.0);
        
        // CHECK if the Y orientation in _token is 90:
        assertEquals(_rntOrientation[1], 90.0, 0.0);
        
        // CHECK if the Z orientation in _token is 0:
        assertEquals(_rntOrientation[2], 0.0, 0.0);
                
    }
}
