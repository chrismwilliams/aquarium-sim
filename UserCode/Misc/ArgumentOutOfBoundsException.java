package UserCode.Misc;


/**
 * ArgumentOutOfBoundsException: used to catch instances when a parameter is out of the allotted ranges
 * 
 * @author Chris Williams & Marc Price 
 * @version 3.0
 */
public class ArgumentOutOfBoundsException extends Exception
{
    
    /**
     * Constructor for objects of class ArgumentOutOfBoundsException
     * 
     * @param   _message   the message that was thrown which details the reasons why
     * 
     */
    public ArgumentOutOfBoundsException(String _message)
    {
        // CALL super with the param _message:
        super(_message);
    }

}
