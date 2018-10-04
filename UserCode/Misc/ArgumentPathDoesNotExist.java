package UserCode.Misc;


/**
 * ArgumentPathDoesNotExist: used to catch instances when a provided file path does not exist
 * 
 * @author Chris Williams & Marc Price 
 * @version 3.0
 */
public class ArgumentPathDoesNotExist extends Exception
{
    /**
     * Constructor for objects of class ArgumentPathDoesNotExist
     * 
     * @param   _message   the message that was thrown which details the reasons why
     * 
     */
    public ArgumentPathDoesNotExist(String _message)
    {
        // CALL super with the param _message:
        super(_message);
    }

    
}
