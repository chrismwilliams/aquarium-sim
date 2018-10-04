package UserCode.Manager;

import UserCode.Pets.IEntity;
import UserCode.Behaviours.IBehaviour;
import UserCode.Components.IComponent;

import java.util.List;
import java.awt.geom.Point2D;

/**
 * CollisionManager defines the behaviour of a class that detects for 'collisions' between IEntities. This
 * class will check if any of the 'pets' include an Preditor class against others who have a Prey class
 * 
 * @author Chris Williams
 * @version 3.0
 */
public class CollisionManager implements ISubEntityMngr
{
    // DECLARE an instance of the IEntityListManager class, call it '_listManager':
    private IEntityListManager _listManager;

    /**
     * @Deprecated
     * Constructor for objects of class CollisionManager, used only for testing
     *  
     */
    @Deprecated
    public CollisionManager()
    {
        // USED only for testing:
    }

    /**
     * Constructor for objects of class CollisionManager
     * 
     * @param   _e    the IEntityListManager that adds and removes IEntities from the simulation
     * 
     */
    public CollisionManager(IEntityListManager _e)
    {
        // INITIALISE the _listManager with the param passed:
        _listManager = _e;
    }

    /**
     * 
     * METHOD: used to check for pets with the IComponent Preditor against those that have the Prey IComponent. If the two pets are close
     * enough, this method will call the Preditor class componentAction method, and then ask the IEntityManager to remove the pet with
     * the Prey IComponent
     * 
     * @param   _entities   an array List of IEntity's that contain the IComponents, within the IBehaviour
     * 
     */
    public void checkEntities(List<IEntity> _entities)
    {
        // START a loop through all the _entities passed:
        for(int i = 0; i < _entities.size(); i++)
        {
            // INITIALISE and assign an IBehaviour using the get method on the _entities array and calling getBehaviour():
            IBehaviour _b = _entities.get(i).getBehaviour();

            // INITIALISE and assign an IComponent field calling the getIComponent method on the IBeheviour seeing if the IEntity has a Preditor class:
            IComponent _c = _b.getIComponent("preditor");

            // IF it is not null:
            if(_c != null)
            {
                // FOUND a Preditor found;

                // INITIALISE a double array by calling the getPosition method, call it 'pos':
                double[] pos = _b.getPosition();

                // CREATE and initialise a new Point2D class, call it '_pred':
                Point2D _pred = new Point2D.Double();

                // ADD the x and y position to the Point2D class, calling the setLocation method using the pos field:
                _pred.setLocation(pos[0], pos[1]);

                // INITIALISE a double to store the scale of the preditor, call it '_predScale':
                double _predScale = _b.getScale();

                // START an inner loop to loop for any pets with the Prey IComponent:
                for(int j = 0; j < _entities.size(); j++)
                {
                    // INITIALISE an IEntity field using the get method on the _entites array:
                    IEntity _e = _entities.get(j);
                    
                    // INITIALISE an IBehaviour field calling the getBehaviour() method:
                    IBehaviour _b2 = _e.getBehaviour();

                    // INITIALISE an IComponent field calling getIComponent method on the IBehaviour to check if has the Prey IComponent:
                    IComponent _c2 = _b2.getIComponent("prey");

                    // IF it is not null:
                    if(_c2 != null)
                    {
                        // Prey found;

                        // INITIAILISE a double array by calling the getPosition method, call it '_preyPos':
                        double[] _preyPos = _b2.getPosition();

                        // CREATE an intiailise an new Point2D call, call it '_prey':
                        Point2D _prey = new Point2D.Double();

                        // ADD the x and y position to the Point2D class, calling the setLocation method using the _preyPos field:
                        _prey.setLocation(_preyPos[0], _preyPos[1]);

                        //System.out.println(_pred.distance(_prey));

                        // CHECK if the distance between both the preditor and prey using the Point2D method distance using both Point2D classes
                        if(_pred.distance(_prey) <= _predScale)
                        {
                            //System.out.println("HIT!");

                            // CALL the IComponent Prey method componentAction() to increase the pet's scale:
                            _c.componentAction();

                            // CALL the IEntityManager method removeEntity with the IEntity found within the innerloop:
                            _listManager.removeEntity(_e);
                        }

                    }
                }

            }

        }
    }

}
