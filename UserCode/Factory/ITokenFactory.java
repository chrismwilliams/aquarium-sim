package UserCode.Factory;

import UserCode.Pets.IToken;

/**
 * ITokenFactory defines the Interface of a factory that should return an IToken based on the String provided
 *
 * @author Chris Williams
 * @version 3.0
 */
public interface ITokenFactory
{
    /**
     * 
     * METHOD: based on the String provided, this method should return an Instance of IToken
     * 
     * @param   _name   the name of the pet required
     * 
     * @return  IToken   the IToken which has been constructed with an image based on the param
     * 
     */
    IToken getToken(String _name);
}
