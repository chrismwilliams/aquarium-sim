package UserCode.Components;

import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Pets.IToken;
import UserCode.Pets.Token;
import UserCode.Pets.Piranha;
import UserCode.Behaviours.IBehaviour;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PreditorTest to test the IComponent Preditor
 * 
 * Test Conditions
 * 
 * 1) Construction: all fields are initialised as expected and checked once via the object bench using the Initialise method
 * 2) componentAction(): check that this method calls the private method feed and the scale is increased
 *
 * @author  Chris Williams
 * @version 3.0
 */
public class PreditorTest
{
    /**
     * Default constructor for test class PreditorTest
     */
    public PreditorTest()
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
     * Check if the update method updates the scale of the pet.
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE an instance of Token, call it '_token':
        IToken _token = null;

        // CORRECT use of throw tested in token:
        // CREATE a new instance of Token in the _token field with the Piranha texture:
        try
        {
            _token = new Token("textures/javaFish/PiranhaRed.png");
        }
        catch(ArgumentPathDoesNotExist e)
        {
            // TESTED in token
        }

        // DECLARE and initialise an instance of Piranha, call it '_piranha':
        IBehaviour _piranha = new Piranha(_token);

        // DECLARE and initialise an instance of the Preditor class, call it '_preditor':
        IComponent _preditor = new Preditor();

        // DELCARE and initialise a List to store the IComponent, call it '_compList':
        List<IComponent> _compList = new ArrayList<IComponent>();

        // ADD the IComponent to the arraylist:
        _compList.add(_preditor);

        // INITIALISE the JavaFish with the newly created IComponent:
        _piranha.Initialise(_compList);

        // INITIALISE and assign a double to store the scale before calling method, call it '_scale':
        double _scale = _token.rtnScale();
        
        // CALL the componentAction method which should update the scale:
        _preditor.componentAction();
        
        // INITIALISE and assign a double to store the return scale, call it '_rtnScale':
        double _rtnScale = _token.rtnScale();
        
        // CHECK if the scale has increased:
        if(_scale == _rtnScale || _scale > _rtnScale)
        {
            // FAILED to increase the scale:
            System.out.println("Original size " + _scale + " New scale: " + _rtnScale);
            fail("The scale of the image hasn't been increased");
        }
    }
}
