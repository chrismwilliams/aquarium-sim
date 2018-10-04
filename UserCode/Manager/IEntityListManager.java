package UserCode.Manager;

import UserCode.Pets.IEntity;
import UserCode.Factory.IEntityCreatorFactory;

/**
 * IEntityListManager defines the behaviour of a class that will add and remove IEntites from the simulation based on the parameters provided.
 *
 * @author Chris Williams
 * @version 3.0
 */
public interface IEntityListManager
{
    /**
     * 
     * METHOD: used to initialise the concrete implementation with a IEntityCreatorFactory and IWorldManager
     * 
     * @param   factory   a concrete implementation that can create and return IEntities
     * @param   _wManager   a concrete implementation that can add IToken to the aquarium
     * 
     */
    void Initialise(IEntityCreatorFactory factory, IWorldManager _wManager);
    
    /**
     * 
     * METHOD: used to add entities based on the String provided. The coords param is used to play certain types of pets
     * within the aquarium
     * 
     * @param   _type   the name of the pet required as a String
     * @parma   coords   the position to place the pet's 'Bubble' & 'FishFood'
     * 
     */
    void addEntity(String _type, double ...coords);

    /**
     * 
     * METHOD: used to remove the IEntity from the world based on the parameter provided
     * 
     * @param   e   the IEntity that needs to be removed
     * 
     */
    void removeEntity(IEntity e);
    
    
}
