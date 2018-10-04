package UserCode.Manager;

import UserCode.Pets.IEntity;

import java.util.List;

/**
 * IEntityManager defines the beheviour of a manager of IEntities within the aquarium simulation. 
 *
 * @author Chris Williams
 * @version 3.0
 */
public interface IEntityManager
{
    /**
     * 
     *  METHOD: used to return the List of stored Entities
     *  
     *  @return List   the List of IEntity's stored
     * 
     */
    @Deprecated
    List getEntitiesArray();
    
    /**
     * 
     * METHOD: used to update all the IEntity's the List contains each frame
     * 
     */
    void update();
}
