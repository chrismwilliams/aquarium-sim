package UserCode.Manager;

import UserCode.Misc.Screen;
import UserCode.Behaviours.IBehaviour;
import UserCode.Pets.IEntity;
import UserCode.Misc.ArgumentPathDoesNotExist;

import java.util.List;

/**
 * WorldBoundsManger defines the behaviour of a class that detects if any of the IEntity's have left the aquarium
 * on the x & y axis. If they have the IEntity is asked to be removed using the IEntityManager removeEntity method
 *
 * @author Chris Williams
 * @version 3.0
 */
public class WorldBoundsManager implements ISubEntityMngr
{
    // DECLARE an instance of the IEntityListManager class, call it '_listManager':
    private IEntityListManager _listManager;

    // DECALRE an instance of ISoundManager used to play sounds, call it '_soundManager':
    private ISoundManager _soundManager;

    // DECLARE and initialise two doubles representing the min and max values for the y axis, call them '_minY' & '_maxY':
    private double _minY = Screen.MIN_Y.getValue() - 1.1;
    private double _maxY = Screen.MAX_Y.getValue() + 1.1;
    
    // DECLARE and initialise two doubles representing the min and max values for the x axis, call them '_minX' & '_maxX':
    private double _minX = Screen.MIN_X.getValue() - 1.1;
    private double _maxX = Screen.MAX_X.getValue() + 1.1;

    /**
     * @Deprecated
     * Constructor for objects of class WorldBoundsManager, used only for testing
     * 
     * @param   _e   the IEntityListManager that adds and removes IEntities from the simulation
     * 
     */
    @Deprecated
    public WorldBoundsManager(IEntityListManager _e)
    {
        // USED only for testing:
        // INITIALISE the _listManager with the param passed:
        _listManager = _e;
    }

    /**
     * Constructor for objects of class WorldBoundsManger
     * 
     * @param   _e   the IEntityListManager that adds and removes IEntities from the simulation
     * @param   _s   the ISoundsManager implementation that plays sounds, used for playing the pop audio
     * 
     */
    public WorldBoundsManager(IEntityListManager _e, ISoundManager _s)
    {
        // INITIALISE the _listManager with the param passed:
        _listManager = _e;

        // INITIALISE the _soundManger with the param passed:
        _soundManager = _s;
    }

    /**
     * 
     * METHOD: used to check if any of the IEntity's are greater than or less than the _min &/or _max fields for the x and y axis
     * 
     * @param   _entities   an array List of IEntity's
     * 
     */
    public void checkEntities(List<IEntity> _entities)
    {
        // START a loop through all the _entities array:
        for(IEntity _e : _entities)
        {
            // INITIALISE and assign an IBehaviour using the get method on the _entities array callin the getBehaviour method:
            IBehaviour b = _e.getBehaviour();

            // INITIALISE a double array calling the getPosition method on the IBehaviour:
            double[] pos = b.getPosition();

            // CHECK if the pos position is less than the _min and _max field on the x & y axis:
            if(pos[1] < _minY || pos[1] > _maxY || pos[0] < _minX || pos[0] > _maxX)
            {
                // System.out.println("IEntity out of bounds");

                // CALL the IEntityManager method removeEntity with the IEntity found:
                _listManager.removeEntity(_e);

                // CALL the playSound method:
                playSound();
            }
        }
    }

    /**
     * 
     *  METHOD: used to play a pop sound by calling the _soundManager playSound method with the path to the sound
     * 
     */
    private void playSound()
    {
        // CHECK if the _soundManger is not null:
        if(_soundManager != null)
        {
            // TRY to play the sound
            try
            {
                // CALL the _soundManager's playSound method and pass the path to the pop sound to play the sound:
                _soundManager.playSound("sounds/pop.wav");
            }
            // CATCH the error
            catch(ArgumentPathDoesNotExist e)
            {
                System.out.println("The path name is incorrect");
            }
        }
    }
}
