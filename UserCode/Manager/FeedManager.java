package UserCode.Manager;

import UserCode.Pets.IEntity;
import UserCode.Behaviours.IBehaviour;
import UserCode.Components.IComponent;

import java.util.List;
import java.awt.geom.Point2D;

/**
 * FeedManager defines the behaviour of a class that detects if any of the pets with the IComponent feed have come into contact with
 * a pet with the IComponent FoodFall
 *
 * @author Chris Williams
 * @version 3.0
 */
public class FeedManager implements ISubEntityMngr
{
    // DECLARE an instance of the IEntityListManager class, call it '_listManager':
    private IEntityListManager _listManager;

    /**
     * @Deprecated
     * Constructor for objects of class FeedManager, used only for testing
     */
    @Deprecated
    public FeedManager()
    {
        // USED only for testing:
    }

    /**
     * Constructor for objects of class FeedManager
     * 
     * @param   _e    the IEntityListManager that adds and removes IEntities from the simulation
     * 
     */
    public FeedManager(IEntityListManager _e)
    {
        // INITIALISE the _listManager field with the param passed:
        _listManager = _e;
    }

    /**
     * 
     * METHOD: used to check if any of the pets with the IComponent Prey against those that have the FoodFall IComponent. If the two pets
     * have 'collided'. If they have, the componentAction method is calling the the Prey call and the IEntity with the FoodFall class is removed
     * 
     * @param   _entities   an array List of IEntity's that contain the IComponents, within the IBehaviour
     * 
     */
    public void checkEntities(List<IEntity> _entities)
    {
        // START a for loop through all of the IEntity's passed:
        for(int i = 0; i < _entities.size(); i++)
        {
            // DECLARE and initialise an IEntity using the get() method on the _entities array:
            IEntity _e = _entities.get(i);
            
            // DECLARE and initialise an IBehaviour using the get method on the _e field and calling getBehaviour():
            IBehaviour _b = _e.getBehaviour();

            // DECLARE and initialise an IComponent using the getIComponent seeing if it has the foodfall class:
            IComponent _c = _b.getIComponent("foodfall");

            // IF the IEntity has the FoodFall class:
            if(_c != null)
            {
                // FishFood found;

                // DECLARE and initialise a double array calling the getPosition on the IBehaviour:
                double[] pos = _b.getPosition();
                
                // DECLARE and initialise a new Point2D class, call it '_food':
                Point2D _food = new Point2D.Double();
                
                // ADD the x and y position using setLocation() using the pos field:
                _food.setLocation(pos[0], pos[1]);

                // START an inner loop to look for any pets with the Feed IComponent:
                for(int j = 0; j < _entities.size(); j++)
                {
                    // DECLARE and initialise an IBehaviour calling the getBehaviour on the IEntities array get method:
                    IBehaviour _b2 = _entities.get(j).getBehaviour();

                    // DECLARE and initialise an IComponent field calling the getIComponent to check if it has the Feed IComponent:
                    IComponent _c2 = _b2.getIComponent("feed");

                    // IF it is not null:
                    if(_c2 != null)
                    {
                        // Fish who eats found;

                        // INITIALISE a double array by calling the getPosition method, call it '_fishPos':
                        double[] _fishPos = _b2.getPosition();
                        
                        // CREATE a new Point2D class to store the x and y positions, call it '_fish':
                        Point2D _fish = new Point2D.Double();
                        
                        // CALL the setLocation method using the x and y position found in the pos array:
                        _fish.setLocation(_fishPos[0], _fishPos[1]);
                        
                        // INITIALISE a double to store the scale of the pet, call it '_fishScale':
                        double _fishScale = _b2.getScale();

                        // System.out.println(_food.distance(_fish));
                        
                        // CHECK the distance between the FishFood and Fish using the Point2D method distance with the Point2D classes created:
                        if(_food.distance(_fish) <= _fishScale)
                        {
                            // System.out.println("Eat food");
                            
                            // CALL the componentAction method on the IComponent Feed class:
                            _c2.componentAction();

                            // CALL the removeEntity method to remove the FishFood that has been 'eaten':
                            _listManager.removeEntity(_e);
                        }

                    }
                }

            }

        }
    }
}
