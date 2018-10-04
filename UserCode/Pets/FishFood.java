package UserCode.Pets;

import UserCode.Behaviours.Behaviour;
import UserCode.Components.IComponent;
import UserCode.Misc.Screen;

import java.util.Map;
import java.util.List;

/**
 * FishFood class defines the behaviour of a concrete implementation of a pet that will be eaten. 
 * 
 * @author Chris Williams
 * @version 3.0
 */
public class FishFood extends Behaviour
{
    // DECLARE a value to store a minimum 'height' the object is allowed to fall, call it '_min':
    private double _min = Screen.MIN_Y.getValue() - 1.2;

    /**
     * Constructor for objects of class FishFood
     * 
     * @param   _token   the token of the class that contains its texture and model
     * @param   posX   the x position of the class
     * @param   posY   the y position of the class
     * @param   min   the minimum value the class is allowed to fall before the _isActive field is set to false and internally no longer updates
     * 
     */
    public FishFood(IToken _token, double posX, double posY)
    {
        // CALL super behaviour with the _token and _m params:
        super(_token);

        // CALL the super method generateSpeed with the param slow to generate a random 'slower' speed:
        super.generateSpeed("slow");

        // CALL the super method setScale to set the scale of the fish food to 0.05:
        super.setScale(0.05);

        // CALL the method setPosition and pass the param's posX and posY to assign fields:
        setPosition(posX,posY);

    }

    /**
     * 
     * METHOD: used to initialise all the IComponents a JavaUrchin requires within an aquarium
     * 
     * @param   _components   the List of IComponents for a Piranha in the simulation 
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
     * METHOD - update method used to call the unique methods for the fishFood and update its position within the aquarium
     * Method overrides the base behaviour class
     * 
     */
    @Override
    public void update()
    {
        // Loop through all the IComponents in the _components array inherited from the base Behaviour class:
        for (Map.Entry<String, IComponent> _entry : _components.entrySet()) 
        {
            // DECLARE and initialise an IComponent field by calling the getValue method, call it '_component':
            IComponent _component = (IComponent) _entry.getValue();

            // CALL the update method of the IComponent _component field:
            _component.update();
        }

    }
}
