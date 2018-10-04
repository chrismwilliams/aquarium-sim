package UserCode.Pets;

import UserCode.Behaviours.Behaviour;
import UserCode.Components.IComponent;

import java.util.List;
import java.util.Map;

/**
 * JavaUrchin contains all the behaviour and methods of an Urchin 'pet' to be used within the aquarium. 
 * 
 * @author Chris 
 * @version 3.0
 */
public class JavaUrchin extends Behaviour
{

    /**
     * Constructor for objects of class JavaUrchin
     * 
     * @param   _token   the token of the Urchin that contains its texture
     * 
     */
    public JavaUrchin(IToken _token)
    {
        // CALL super behaviour with the _token param:
        super(_token);

        // CALL the super method generateSpeed with the param slow to generate a random 'slower' speed:
        super.generateSpeed("slow");

        // CALL the super method setOrientation with the x,y and z arguments 0,-90,0 to set orientation:        
        super.setOrientation(0,-90,0);

        // CALL the setStartPosition method of base class to request a random starting position that is near the bottom of the aquarium: 
        super.setStartPosition("bottom");

        // CALL the randomScale method of base class to assign a random size to the Urchin:
        super.randomScale();

    }

    /**
     * 
     * METHOD: used to initialise all the IComponents a JavaUrchin requires within an aquarium
     * 
     * @param   _components   the List of IComponents required by a JavaUrchin to act in a simulation
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
     * METHOD: used to override the behaviour base class and call all the IComponents which run throught all the unique behaviours
     * of a JavaUrchin
     * 
     */
    @Override
    public void update()
    {
        // Loop through all the IComponents held in the _components HashMap array:     
        for (Map.Entry<String, IComponent> _entry : _components.entrySet()) 
        {
            // INITIALISE and assign an IComponent field by calling the getValue method:
            IComponent _component = _entry.getValue();
            
            // CALL the update method on the IComponent:
            _component.update();
        }

    }
}
