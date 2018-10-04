package UserCode.Pets;

import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Behaviours.IBehaviour;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FishFoodTest for testing the production class FishFood.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * 1: Construction: all fields are initialised as expected and checked once via the object bench
 * 2: Construction: check that the method setScale(0.05) sets the scale of the fish food to 0.05 in token
 * 3: Construction: check that speed generated from the inherited generateSpeed("slow") creates a speed between 0.005 - 0.010
 * 
 */
public class FishFoodTest
{
    /**
     * Default constructor for test class FishFoodTest
     */
    public FishFoodTest()
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
     * setScale(0.05) check that this method sets the scale of the fish food to 0.05 in token
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE an instance of Token, call it '_token':
        IToken _token = null;

        // CORRECT use of throw tested in token:
        // CREATE a new token with the FishFood texture and 'sphere' model:
        try
        {
            _token = new Token("textures/javaFish/FishFood.png", "sphere");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // TESTED in token
        }

        // DECLARE and initialise an instance of FishFood, call it '_fishFood' with a position in the middle of the screen:
        IBehaviour _fishFood = new FishFood(_token,5.0,5.0);

        // DECLARE and initialise a double to store the value returned from calling the scale set in the token, call it '_rtnScale':
        double _rtnScale = _token.rtnScale();

        // CHECK if the required scale of 0.05 is what is set in the token for the bubble:
        assertEquals(_rtnScale, 0.05, 0.0);
        
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
        // CREATE a new token with the FishFood texture and 'sphere' model:
        try
        {
            _token = new Token("textures/javaFish/FishFood.png", "sphere");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // TESTED in token
        }

        // DECLARE and initialise an instance of FishFood, call it '_fishFood' with a position in the middle of the screen:
        IBehaviour _fishFood = new FishFood(_token,5.0,5.0);

        // DECLARE and initialise a double from calling the _bubble.getSpeed method, call it, '_rtnSpeed':
        double _rtnSpeed = _fishFood.getSpeed();

        // CHECK if the _rtnSpeed is less than 0.005 or greater than 0.010:
        if(_rtnSpeed < 0.005 || _rtnSpeed > 0.010)
        {
            // TEST failed
            fail("The speed set in FishFood is too fast for this pet: " + _rtnSpeed);
        }

    }
}
