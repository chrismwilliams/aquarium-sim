package UserCode.Components;

import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Pets.IToken;
import UserCode.Pets.Token;
import UserCode.Pets.FishFood;
import UserCode.Behaviours.IBehaviour;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FoodFallTest for testing the production class FoodFall.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions
 * 
 * 1) Construction: all fields are initialised as expected and checked once via the object bench using the Initialise method
 * 2) update(): check that the method updates the y position to decrement
 * 
 */
public class FoodFallTest
{
    /**
     * Default constructor for test class FoodFallTest
     */
    public FoodFallTest()
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
     * Check if the update method decrements the y position of the IBehaviour
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE an instance of Token, call it '_token':
        IToken _token = null;

        // CORRECT use of throw tested in token:
        // CREATE a new instance of Token in the _token field with the FishFood texture:
        try
        {
            _token = new Token("textures/javaFish/FishFood.png");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // TESTED in token
        }

        // DECLARE and initialise an instance of FishFood, call it '_fishFood':
        IBehaviour _fishFood = new FishFood(_token, 5.0, 5.0);

        // DECLARE and initialise an instance of the FoodFall class, call it '_foodFall':
        IComponent _foodFall = new FoodFall(1.0);

        // DELCARE and initialise a List to store the IComponent, call it '_compList':
        List<IComponent> _compList = new ArrayList<IComponent>();

        // ADD the IComponent to the arraylist:
        _compList.add(_foodFall);

        // INITIALISE the FishFood with the newly created IComponent:
        _fishFood.Initialise(_compList);

        // DECLARE and intialise an array of type double to store the call to getPosition, call it '_startPos':
        double[] _startPos = _token.getPosition();
        
        // CALL the IComponent method update to see if the token's y position is decremented:
        _foodFall.update();

        // DECLARE and initialise another array to check if the x and y values have changed:
        double[] _rtnPos = _token.getPosition();
                
        // CHECK if the y value is the same or greater than the start:
        if(_rtnPos[1] >= _startPos[1])
        {
            // FAILED to decrement the y position:
            fail("The y position hasn't been decremented");
        }
    }
}
