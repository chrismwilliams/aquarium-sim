package UserCode.Factory;

import UserCode.Pets.IToken;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TokenFactoryTest for testing the production class TokenFactory.
 * 
 * Test Conditions:
 * 
 * 1) Construction (default): all fields are initialised as expected apart from the _manager field, done via the object bench
 * 2) getToken(): test the method returns an IToken with the correct image of a known pet
 * 3) getToken(): test that the method can create an IToken with a image path provided as an argument
 *
 * @author  Chris Williams
 * @version 3.0
 */
public class TokenFactoryTest
{
    /**
     * Default constructor for test class TokenFactoryTest
     */
    public TokenFactoryTest()
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
     * getToken(): method should return an instance of IToken with the correct image 
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initialise a new instance of the TokenFactory, call it '_tokenFactory':
        ITokenFactory _tokenFactory = new TokenFactory();
        
        // DECLARE and initialise a new instance of IToken by calling the getToken method of _tokenFactory:
        IToken _token = _tokenFactory.getToken("JavaFish");
        
        // TEST that it's not null:
        assertNotNull(_token);
        
        // CHECK the image in the _token is that of the texture a JavaFish:
        String _tokenImage = _token.rtnTexture();
        
        // TEST that the image path is correct:
        assertSame(_tokenImage, "textures/javaFish/JavaFish.png");
    }
    
    /**
     * 
     * getToken(): method should return an IToken with the image path provided
     * 
     */
    @Test
    public void testCondition3()
    {
        // DECLARE and initialise a new instance of the TokenFactory, call it '_tokenFactory':
        ITokenFactory _tokenFactory = new TokenFactory();
        
        // DECLARE and initialise a new instance of IToken by calling the getToken with an image path:
        IToken _token = _tokenFactory.getToken("PiranhaGreen");
        
        // TEST that it's not null:
        assertNotNull(_token);
        
        // CHECK the image in the _token is that of the texture a JavaFish:
        String _tokenImage = _token.rtnTexture();
        
        // TEST that the image path is correct:
        assertTrue(_tokenImage.equals("textures/javaFish/PiranhaGreen.png"));
    }
}
