package UserCode.Manager;

import UserCode.Pets.IToken;

/**
 * IWorldManager defines the behaviour of a concrete class that should be able to add and remove instances of 
 * IToken's from the world
 *
 * @author Chris Williams
 * @version 3.0
 */
public interface IWorldManager
{
    /**
     * 
     * METHOD: used to add an IToken to the aquarium
     * 
     * @param   token - IToken to be added to the simulation
     * 
     */
    public void addToken(IToken t);
    
    /**
     * 
     * METHOD: used to remove the IToken from the aquarium
     * 
     * @param   t   the IToken to be removed from the simulation
     * 
     */
    public void removeToken(IToken t);    
}
