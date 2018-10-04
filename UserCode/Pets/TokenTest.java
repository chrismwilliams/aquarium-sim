package UserCode.Pets;

import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Misc.ArgumentOutOfBoundsException;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TokenTest for testing the Token production class.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1: Construction: all fields are initialised as expected and checked via the object bench
 * 2: Construction: check if providing a texture that doesn't exist throw an ArgumentPathDoesNotExist exception
 * 3: setScale(): check that it throws an ArgumentOutOfBoundsException by setting a scale that isn't between 0.0 - 1.0
 * 4: setScale(): check that an Exception isn't thrown by setting a scale that should be valid and between 0.0 - 1.0
 * 5: setOrientation(): check that this method correctly assigns the 3 rotate fields correctly
 * 6: updatePosition(): check that this method correctly updates the x and y fields with the Point2D values assigned
 * 
 */
public class TokenTest
{
    /**
     * Default constructor for test class TokenTest
     */
    public TokenTest()
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
     * Check that the constructor throws an ArgumentPathDoesNotExist by providing a file that doesn't exist
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE a boolean to assign the result of the test to, call it 'pass':
        // INITIALISE it to 'false' before the test:
        boolean pass = false;

        // DECLARE an instance of Token, call it '_token':
        IToken _token = null;

        // TRY to instantiate a Token by providing a file path that doesn't exist
        try
        {
            _token = new Token("path");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            pass = true; 
        }

        // IF pass != true the test has failed
        if(!pass)
        {
            fail("An ArgumentPathDoesNotExist exception did not catch a file that doesn't exist");
        }
    }

    /**
     * 
     * METHOD: Test condition 3:
     * setScale(): test an exception is throw when providing an argument that is not between 0.0 - 1.0
     * 
     */
    @Test
    public void testCondition3()
    {
        // DECLARE a boolean to assign the result of the test to, call it 'pass':
        // INITIALISE it to 'false' before the test:
        boolean pass = false;

        // DECLARE and instantiate a Token, call it _token:
        IToken _token = new Token();

        // TRY to set a scale that is out of bounds:
        try
        {
            _token.setScale(5.0);
        }
        catch(ArgumentOutOfBoundsException e)
        {
            pass = true;
        }

        if(!pass)
        {
            fail("An ArgumentOutOfBoundsException was not thrown");
        }
    }
    
    /**
     * 
     * METHOD: Test condition 4:
     * setScale(): test an exception isn't thrown when providing an argument that is between 0.0 - 1.0
     * 
     */
    @Test
    public void testCondition4()
    {
        // DECLARE a boolean to assign the result of the test to, call it 'pass':
        // INITIALISE it to 'true' before the test starts:
        boolean pass = true;
        
        // DECLARE and instantiate a Token, call it _token:
        IToken _token = new Token();

        // TRY to set a scale that is out of bounds:
        try
        {
            _token.setScale(0.4);
        }
        catch(ArgumentOutOfBoundsException e)
        {
            fail("An ArgumentOutOfBoundsException was thrown with a valid scale");
            pass = false;
        }

        if(!pass)
        {
            fail("An exception was thrown for a scale that should be valid");
        }
    }

    /**
     * 
     * METHOD: Test condition 5:
     * setOrientation(): test that the rotateX, rotateY and rotateZ fields are correctly assigned
     * 
     */
    @Test
    public void testCondition5()
    {

        // DECLARE and instantiate a Token, call it _token:
        IToken _token = new Token();

        // CALL the method with the values 180,180,0:
        _token.setOrientation(180,90,0);

        // DECLARE and instantiate a double array and get the Orientation values:
        double[] _rtnOrientation = _token.getOrientation();

        // CHECK if the rotateX field is equal to 180:
        assertEquals(_rtnOrientation[0], 180.0, 0.0);
        
        // CHECK if the rotateY field is equal to 180:
        assertEquals(_rtnOrientation[1], 90.0, 0.0);
        
        // CHECK if the rotateZ field is equal to 0.0:
        assertEquals(_rtnOrientation[2], 0.0, 0.0);
        
    }

    /**
     * 
     * METHOD: Test condition 6:
     * updatePosition(): test that the x and y fields in token are updated to the values passed
     * 
     */
    @Test
    public void testCondition6()
    {

        // DECLARE and instantiate a Token, call it _token:
        IToken _token = new Token();

        // DECLARE and initialise 3 double fields to pass to the token instance:
        double _x = 5.0, _y = 6.0, _z = 1.0;

        // CALL the method with the _point2D field created:
        _token.setPosition(_x,_y,_z);

        // DECLARE and instantiate another Point2D class by calling the getCoord method:
        double[] _rtnPos = _token.getPosition();

        // CHECK if the x axis returned is equal to _x field sent:
        assertEquals(_rtnPos[0], 5.0, 0.0);
        
        // CHECK if the y axis returned is equal to _y field sent:
        assertEquals(_rtnPos[1], 6.0, 0.0);
        
        // CHECK if the z axis returned is equal to the _z field sent:
        assertEquals(_rtnPos[2], 1.0, 0.0);
    }
}
