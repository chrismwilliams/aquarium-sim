package UserCode.Pets;

import UserCode.Behaviours.Behaviour;
import UserCode.Components.IComponent;

import java.util.Map;
import java.util.List;

/**
 * JavaSeaHorse: contains all the behaviour and methods of a SeaHorse 'pet' to be used within the aquarium. 
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class JavaSeaHorse extends Behaviour
{
    
    /**
     * Constructor for objects of class JavaSeaHorse
     * 
     * @param   _token   the token of the SeaHorse that contains its texture
     * 
     */
    public JavaSeaHorse(IToken _token)
    {
        // CALL super behaviour with the _token and _m params:
        super(_token);

        // CALL the super method generateSpeed without a param to generate a random speed between 0.05 and 0.005:
        super.generateSpeed();

        // CALL the super method setOrientation with the x,y and z arguments 180,90,0 to set orientation:
        super.setOrientation(180,90,0);

        // CALL the setStartPosition method of base class to request a random starting position that is near the top of the aquarium:
        super.setStartPosition("top");

        // CALL the randomScale method of base class to assign a random size to the SeaHorse:
        super.randomScale();

    }
    
    /**
     * 
     * METHOD: used to initialise all the IComponents a JavaSeaHorse requires within an aquarium
     * 
     * @param   _components   the List of IComponents a JavaFish updates in the simulation
     * 
     */
    public void Initialise(List<IComponent> _components) 
    {
        // LOOP through all the IComponents within the _components List passed 
        for(IComponent _c : _components)
        {
            // CALL Initialise and pass a reference to this:
            _c.Initialise(this);
            
            // ADD the IComponent to the HashMap calling the inherited addComponent method:
            addComponent(_c);
        }

    }
    
    /**
     * @Override
     * METHOD: used to override the behaviour base class and call its unique methods looping through the _components values
     * 
     */
    @Override
    public void update()
    {
        // Loop through all the IComponets held in the _components Map array:
        for (Map.Entry<String, IComponent> _entry : _components.entrySet()) 
        {
            // INTIALISE and assign an IComponent field by calling the getValue method:
            IComponent _component = (IComponent) _entry.getValue();
            
            // CALL the update method of the IComponent:
            _component.update();
        }
    }
}
