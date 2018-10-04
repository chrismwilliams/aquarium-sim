package UserCode.Factory;

import UserCode.Pets.IToken;
import UserCode.Pets.Token;
import UserCode.Misc.ArgumentPathDoesNotExist;

/**
 * TokenFactory defines the behaviour of a factory that creates and returns an IToken with an image based on the String
 * value passed, the implementation of the ITokenFactory
 *
 * @author Chris Williams
 * @version 3.0
 */
public class TokenFactory implements ITokenFactory
{
    /**
     * Constructor for objects of class BehaviourFactory
     */
    public TokenFactory()
    {
        // 
    }

    /**
     * 
     * METHOD: this method returns an instance of IToken based on the param of _name. This is checked against know pets,
     * otherwise it will try to create a new IToken with the String directly
     * 
     * @param   _name   the name of a known pet or texture path (texture path must be within the javaFish folder) 
     * 
     * @return  IToken   the IToken which has been constructed with an image based on the param
     * 
     */
    public IToken getToken(String _name)
    {
        // CHECK if the _name param is 'JavaFish':
        if(_name.equalsIgnoreCase("JavaFish"))
        {
            // TRY to create the new token with the JavaFish texture path:
            try {
                //INTIALISE an instance of a Token with a JavaFish texture and return to caller:
                return new Token("textures/javaFish/JavaFish.png");
            }
            // CATCH the exception if the filepath is wrong:
            catch(ArgumentPathDoesNotExist e)
            {

                System.out.println("JavaFish filepath is incorrect");
            }
        }

        // CHECK if the _name param is 'JavaUrchin':
        else if(_name.equalsIgnoreCase("JavaUrchin"))
        {
            // TRY to create the new token with the Urchin texture path:
            try
            {
                // INITIALISE an instance of a Token with Urchin texture and return to caller:
                return new Token("textures/javaFish/Urchin.png");
            }
            // CATCH the exception if the filepath is wrong:
            catch(ArgumentPathDoesNotExist e)
            {

                System.out.println("JavaUrchin filepath is incorrect");
            }

        }

        // CHECK if the _name param is 'JavaSeaHorse':
        else if(_name.equalsIgnoreCase("JavaSeaHorse"))
        {
            // TRY to create the new token with the SeaHorse texture path:
            try
            {
                // INITIALISE an instance of a Token with a SeaHorse texture and return to caller:
                return new Token("textures/javaFish/Seahorse.png");
            }
            // CATCH the exception if the filepath is wrong:
            catch(ArgumentPathDoesNotExist e)
            {

                System.out.println("JavaSeaHorse filepath is incorrect");
            }
        }

        // CHECK if the _name param is 'Bubble':
        else if(_name.equalsIgnoreCase("Bubble"))
        {
            // TRY to create the new token with the Bubble texture path:
            try
            {
                // INITIALISE an instance of a Token with a Bubble and a sphere model and return to caller:
				//System.out.println("Creating bubble texture");
                return new Token("textures/javaFish/Bubble.png", "sphere");
            }

            // CATCH the exception if the filepath is wrong:
            catch(ArgumentPathDoesNotExist e)
            {

                System.out.println("Bubble filepath is incorrect");
            }
        }

        // CHECK if the _name param is 'FishFood':
        else if (_name.equalsIgnoreCase("FishFood"))
        {
            // TRY to create the new token with the FishFood texture:
            try
            {
                // INITIALISE an instance of a Token with the FishFood and sphere model and return to caller:
                return new Token("textures/javaFish/FishFood.png", "sphere");
            }
            // CATCH the exception if the filepath cannot be found:
            catch(ArgumentPathDoesNotExist e)
            {

                System.out.println("FishFood filepath cannot be found");
            }
        }

        // CHECK if the _name param is 'JavaBubbler':
        else if(_name.equalsIgnoreCase("JavaBubbler"))
        {
            // TRY to create the new token with the Bubbler texture path:
            try
            {
                // INITIALISE an instance of a Token with a JavaBubbler texture and return to caller:
                return new Token("textures/javaFish/Bubbler.png");
            }

            //CATCH the exception if the filepath is wrong:
            catch(ArgumentPathDoesNotExist e)
            {

                System.out.println("JavaBubbler filepath is incorrect");
            }
        }

        // CHECK if the _name param is 'Piranha':
        else if (_name.equalsIgnoreCase("Piranha"))
        {
            // TRY to create the new token with the Piranha texture path:
            try
            {
                // INITIALISE an instance of IToken with a Piranha texture and return to caller:
                return new Token("textures/javaFish/PiranhaRed.png");
            }
            // CATCH the exception if the filepath can't be found:
            catch(ArgumentPathDoesNotExist e)
            {

                System.out.println("Piranha filepath cannot be found");
            }
        }
        // ELSE try to create the new token:
        else
        {
            // TRY to create the new token with the texture path passed:
            try
            {
                // INITIALISE an instance of IToken with a the texture and return to caller:
                return new Token("textures/javaFish/"+_name+".png");
            }
            // CATCH the exception if the filepath can't be found:
            catch(ArgumentPathDoesNotExist e)
            {

                System.out.println("Texture filepath cannot be found");
            }
        }

        // RETURN NULL if no matches have been found:
        return null;
    }

}
