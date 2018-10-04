package UserCode.Pets;

import UserCode.Behaviours.Behaviour;
import UserCode.Components.IComponent;

import java.util.Map;
import java.util.List;

/**
 * Piranha contains the behaviour and components thats required for a 'pet' Piranha to be used within an aquarium
 * 
 * @author Chris Williams
 * @version 3.0
 */
public class Piranha extends Behaviour
{
        
    /**
     * Constructor for objects of class Piranha
     * 
     * @param   _token   the IToken this behaviour will use and update during runtime
     * 
     */
    public Piranha(IToken _token)
    {
        // CALL super behaviour with the _token param passed:      
        super(_token);

        // CALL the super method generateSpeed without a param to generate a random speed between 0.05 and 0.005:
        super.generateSpeed("fast");

        // CALL the super method setOrientation with the x,y and z arguments 0,-90,0 to set orientation:
        super.setOrientation(0,-90,0);

        // CALL the setStartPosition method of base class to request a random starting position that is near the top
        super.setStartPosition("top");

        // CALL the setScale method of the base behaviour class to assign a size for the Piranha:
        super.setScale(0.3);
    }

    /**
     * 
     * METHOD: used to initialise all the IComponents a Piranha requires within an aquarium
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
     * METHOD: used to override the Behaviour base class and call all its IComponents update methods to update any properties of the Piranha
     * 
     */
    @Override
    public void update()
    {
        //System.out.println("I'm in");
        
        // Loop through all the IComponents in the _components Map array
        for (Map.Entry<String, IComponent> _entry : _components.entrySet()) 
        {
            // INITIALISE and assign an IComponent field with the value of each component in the _components array:
            IComponent _component = (IComponent) _entry.getValue();
            
            // CALL the IComponent update method:
            _component.update();
        }

    }
}
