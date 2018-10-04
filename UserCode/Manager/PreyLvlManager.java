package UserCode.Manager;

import UserCode.Pets.IEntity;
import UserCode.Behaviours.IBehaviour;
import UserCode.Components.IComponent;

import java.util.List;

/**
 * PreyLvlManager defines the behaviour of a class that checks the amount of pets with the IComponent Prey. This
 * class add either a JavaFish or JavaSeaHorse if the level falls below the field _requiredPrey
 *
 * @author Chris Williams
 * @version 3.0
 */
public class PreyLvlManager implements ISubEntityMngr
{
    // DECLARE an instance of the IEntityListManager class, call it '_listManager':
    private IEntityListManager _listManager;
    
    // DECLARE an int for the amount of Prey pets required, call it '_requiredPrey':
    private int _requiredPrey = 35;
    
    // DECLARE a String of the pet required, call it '_pet':
    private String _pet = "";

    /**
     * @Deprecated
     * Constructor for objects of class PreyLvlManager, used only for testing
     */
    @Deprecated
    public PreyLvlManager()
    {
        // USED only for testing:
    }

    /**
     * Constructor for objects of class FeedManager
     * 
     * @param   _e    the IEntityListManager that adds IEntities to the simulation
     * 
     */
    public PreyLvlManager(IEntityListManager _e)
    {
        // INITIALISE the _listManager field with the param passed:
        _listManager = _e;
        
    }

    /**
     * 
     * METHOD: used to check the amount of 'prey' pets within the aquarium. IF the level falls below 15, JavaFish & JavaSeaHorse's will be added
     * to the simulation
     * 
     * @param   _entities   an array List of IEntity's that contain the IComponents, within the IBehaviour
     * 
     */
    public void checkEntities(List<IEntity> _entities)
    {
        // DECLARE an int to count the number of IEntity's that have the IComponent 'Prey', call it '_preylvl':
        int _preyLvl = 0;

        // LOOP through all the IEntities within the _entities passed:
        for(IEntity e : _entities)
        {
            // DECLARE and initialise an IBehaviour using the get method on the _entities array and calling the getBeahviour():
            IBehaviour _b = e.getBehaviour();

            // DECLARE and initialise an IComponent using the getIComponent seeing if it has the Prey class:
            IComponent _c = _b.getIComponent("prey");

            // CHECK if the field _c is not null:
            if(_c != null)
            {
                // INCREMENT the _preyLvl field as we have a pet with the prey class:
                _preyLvl++;
            }
        }

        // System.out.println(_preyLvl);
        
        // CHECK if the _preLvl is below _requiredPrey
        if(_preyLvl < _requiredPrey)
        {
            // CALL the topUpPreyLvls method with the result
            topUpPreyLvls(_requiredPrey - _preyLvl);
        }

    }

    /**
     * 
     * METHOD: used to add either JavaFish or JavaSeaHorse's to the aquarium based on the amount param.
     * 
     * @param   amount   the amount of Prey Pets that will be added to the aquarium
     * 
     */
    private void topUpPreyLvls(int amount)
    {
        // System.out.println(amount);
                
        // Start a loop based on the amount param:
        for(int i = 0; i < amount; i++)
        {
            
            // System.out.println("Adding prey pets");
            // ASSIGN a String of the pet requested based on the ternary:
            _pet = _pet == "JavaFish" ? "JavaSeaHorse" : "JavaFish";
            
            // CALL the _listManager addEntity with the _pet String:
            _listManager.addEntity(_pet);
        }
    }
}
