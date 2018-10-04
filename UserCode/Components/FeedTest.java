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
 * The test class FeedTest for testing the IComponent Feed production class
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1) Construction: all fields are initialised as expected and checked once via the object bench using the Initialise method
 * 2) componentAction(): check that this method calls the private method feed and the scale is increased
 * 
 */
public class FeedTest
{
    /**
     * Default constructor for test class FeedTest
     */
    public FeedTest()
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

        // DECLARE and initialise an instance of the Feed class, call it '_feed':
        IComponent _feed = new Feed();

        // DELCARE and initialise a List to store the IComponent, call it '_compList':
        List<IComponent> _compList = new ArrayList<IComponent>();

        // ADD the IComponent to the arraylist:
        _compList.add(_feed);

        // INITIALISE the JavaFish with the newly created IComponent:
        _javaFish.Initialise(_compList);

        // INITIALISE and assign a double to store the scale before calling method, call it '_scale':
        double _scale = _token.rtnScale();
        
        // CALL the componentAction method which should update the scale:
        _feed.componentAction();
        
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
