package UserCode.Pets;

import UserCode.Behaviours.Behaviour;
import UserCode.Components.IComponent;

import java.util.List;
import java.util.Map;

/**
 * JavaBubbler class defines the properties and methods of the 'pet' JavaBubbler that is placed in the aquarium to emmit bubble
 * at regular intervals.
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class JavaBubbler extends Behaviour
{
    /**
     * Constructor for objects of class JavaBubbler
     * 
     * @param   _token   the token of the Bubbler that contains its texture
     * 
     */
    public JavaBubbler(IToken _token)
    {
        // CALL super behaviour with the _token and _m params:        
        super(_token);

        // CALL the super method setOrientation with the x,y and z arguments 90,90,0 to set orientation:
        super.setOrientation(90,90,0);
        
        // CALL the super method setScale with the double amount 0.4:
        super.setScale(0.4);

        // CALL the setStartPosition method of base class to request a random starting position that is near the bottom of the aquarium:
        super.setStartPosition("bottom");
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
     * 
     * METHOD: This method 'alters' the percieved position of this 'pet', as it requests a bubble to be placed at the mouth
     * of the bubbler image.
     * 
     * @return  an array[3] of the x,y and z positions. The x and y positions are the values that have been altered  
     * 
     */
    @Override
    public double[] getPosition()
    {
        // ASSIGN and initialise an array of doubles calling the super getPosition method:
        double[] _pos = super.getPosition();

        // SET the new x position:
        _pos[0] -= 0.1;

        // SET the new y position:
        _pos[1] += 0.4;

        // RETURN the adjusted positions to the caller:
        return _pos;
    }

    /**
     * @Override
     * METHOD: used to override the behaviour base class as the bubbler isn't required to update its IComponents as it shouldn't move
     * 
     */
    @Override
    public void update()
    {
        // NO update, used to override behaviour base class update: 
    }
}
