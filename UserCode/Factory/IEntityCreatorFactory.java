package UserCode.Factory;

import UserCode.Pets.IEntity;

/**
 * IEntityCreatorFactory defines the behaviour a concrete implementation should include that creates and returns IEntity's
 *
 * @author Chris Williams
 * @version 3.0
 */
public interface IEntityCreatorFactory
{
    /**
     * 
     * METHOD: used to return a concrete implementation of an IEntity based on the String provided. The coords param is used
     * by both the bubble and fishfood classes
     * 
     * @param   entityType   the IEntityClass requested as a String
     * @param   coords    the x and y position for the bubble/fishfood required
     * 
     */
    IEntity getEntity(String entityType, double ...coords);
}
