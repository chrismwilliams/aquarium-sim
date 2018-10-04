package UserCode.Pets;

import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Behaviours.IBehaviour;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JavaUrchinTest for testing the JavaUrchin production class.
 *
 * @author  Chris Williams & Marc Price
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1: Construction: all fields are initialised as expected and checked once via the object bench
 * 2: Construction: check that the inherited setOrienation set the orientation of the pet to 0,-90,0
 * 3: Construction: check that speed generated from the inherited generateSpeed("slow") creates a speed between 0.005 - 0.010
 * 
 */
public class JavaUrchinTest
{
    /**
     * Default constructor for test class JavaUrchinTest
     */
    public JavaUrchinTest()
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
        try
        {
            _token = new Token("textures/javaFish/Urchin.png");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // TESTED in token
        }

        // DECLARE and initialise an instance of JavaUrchin, call it 'urchin':
        IBehaviour _urchin = new JavaUrchin(_token);

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
     * Check that speed generated from the inherited generateSpeed("slow") creates a speed between 0.005 - 0.010
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
            _token = new Token("textures/javaFish/Urchin.png");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // TESTED in token
        }

        // DECLARE and initialise an instance of JavaUrchin, call it 'JavaUrchin':
        IBehaviour _urchin = new JavaUrchin(_token);

        // DECLARE and initialise a double from calling the _urchin.getSpeed method, call it, '_rtnSpeed':
        double _rtnSpeed = _urchin.getSpeed();

        // CHECK if the _rtnSpeed is less than 0.005 or greater than 0.010:
        if(_rtnSpeed < 0.005 || _rtnSpeed > 0.010)
        {
            // TEST failed
            fail("The speed set in Urchin is too fast for this pet: " + _rtnSpeed);
        }

    }
    
}
