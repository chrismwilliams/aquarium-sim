package UserCode.Pets;

import UserCode.Behaviours.Behaviour;
import UserCode.Components.IComponent;
import UserCode.Misc.Screen;

import java.util.Map;
import java.util.List;

/**
 * Bubble class defines the properties and methods of the 'pet' Bubble that onced placed in the aquarium will continue to rise until it reaches
 * the value set in the field _max
 * 
 * @author Chris Williams
 * @version 3.0
 */
public class Bubble extends Behaviour
{
    // No instance variables
    
    /**
     * Constructor for objects of class Bubble
     * 
     * @param   _token   the token of the class that contains its texture and model
     * @param   posX   the x position of the class
     * @param   posY   the y position of the class
     * @param   max   the maximum value the class is allowed to reach vertically before isActive is set to false and internally no longer updates
     * its position
     */
    public Bubble(IToken _token, double posX, double posY)
    {
        // CALL super behaviour with the _token and _m params:
        super(_token);

        // CALL the super method generateSpeed with the param slow to generate a random 'slower' speed:
        super.generateSpeed("slow");

        // CALL the super method setScale to set the scale of the bubble to 0.1:
        super.setScale(0.05);

        // CALL the method setPosition and pass the param's posX and posY to assign fields:
        setPosition(posX,posY);

    }

    /**
     * 
     * METHOD: used to initialise all the IComponents a Bubble requires within an aquarium
     * 
     * @param   _components   the List of IComponents for a Piranha in the simulation 
     * 
     */
    public void Initialise(List<IComponent> _components) 
    {
        // LOOP through all the IComponents within the _components List passed: 
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
     * METHOD: to override the behaviour base class to set the position of the pet assigning the _x and _y fields
     * 
     * @param   xpos   the x position of the bubble
     * @param   ypos   the y position of the bubble
     * 
     */
    @Override
    public void setPosition(double xpos, double ypos)
    {
        // CALL the super setPosition to update the display properties:
        super.setPosition(xpos,ypos);

    }
    
    /**
     * @Override
     * METHOD - update method used to call the unique methods for the bubble and update its position within the aquarium
     * Method overrides the base behaviour class
     * 
     */
    @Override
    public void update()
    {
        // Loop through all _components Map array and call the IComponent update:
        for (Map.Entry<String, IComponent> _entry : _components.entrySet()) 
        {
            // INITIALISE and assign an IComponent field calling the getValue method:
            IComponent _component = (IComponent) _entry.getValue();

            // CALL the update method on the IComponent:
            _component.update();
        }

    }
}
