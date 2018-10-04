package UserCode.Pets;

import UserCode.Behaviours.Behaviour;
import UserCode.Components.IComponent;

import java.util.List;
import java.util.Map;
import java.util.Iterator;

/**
 * JavaFish contains all the behaviour and methods of a JavaFish 'pet' to be used within the aquarium. 
 * 
 * @author Chris Williams
 * @version 3.0
 */
public class JavaFish extends Behaviour
{
    // 
    /**
     * Constructor for objects of class JavaFish
     * 
     * @param   _token   the token of the JavaFish that contains its all its displayable properties
     * 
     */
    public JavaFish(IToken _token)
    {
        // CALL super behaviour with the _token passed:      
        super(_token);

        // CALL the super method generateSpeed without a param to generate a random speed between 0.05 and 0.005:
        super.generateSpeed();

        // CALL the super method setOrientation with the x,y and z arguments 0,-90,0 to set orientation:
        super.setOrientation(0,-90,0);

        // CALL the setStartPosition method of base class to request a random starting position that is near the top
        super.setStartPosition("top");

        // CALL the randomScale method of base class to assign a random size to the JavaFish:
        super.randomScale();

    }

    /**
     * 
     * METHOD: used to initialise all the IComponents a JavaFish requires within an aquarium
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
     * 
     * METHOD: used to override the behaviour base class and call all the IComponents which run through all the unique behaviours
     * of a JavaFish
     * 
     */
    @Override
    public void update()
    {
        //System.out.println("I'm in"):

        // Loop through all the IComponents held in the HashMap array:
        for (Map.Entry<String, IComponent> _entry : _components.entrySet()) 
        {
            // INITIALISE and assign an IComponent by calling the getValue method:
            IComponent _component = _entry.getValue();

            // CALL the IComponent update method:
            _component.update();
        }

    }
}