package UserCode.Manager;

import UserCode.Pets.IEntity;

import java.util.List;

/**
 * ISubEntityMngr defines the behaviour of classes that require the main List on IEntity's that are present in the aquarium
 *
 * @author Chris Williams
 * @version 3.0
 */
public interface ISubEntityMngr
{
    /**
     * 
     * METHOD: used by classes to perform their duties on the main IEntity List that the simulation updates per frame
     * 
     * @param   _entities   the List array which contains all the IEntity's currently in the aquarium
     * 
     */
    void checkEntities(List<IEntity> _entities);  
}
