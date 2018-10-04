package UserCode.Components;

import UserCode.Behaviours.IBehaviour;

/**
 * MoveVertically defines the behaviour of an IComponent used by a pet that wishes to move vertically. The direction of travel
 * can be changed by calling the componentAction method when/if required
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class MoveVertically implements IComponent
{
    // DECLARE and initialise a String to hold the name of the component, call it '_name':
    private String _name = "movevertically";
    
    // DECLARE an IBehaviour field, call it '_behaviour':
    private IBehaviour _behaviour;
    
    // DECLARE a field to set the 'direction' to increment/decrement the _behaviour position, call it '_vector':
    private double _vector;
    
    // DECLARE a field to hold the value to increment/decrement by on each frame, call it '_incrementVal':
    private double _incrementVal;
    
    // DECLARE a double[] to store the positional values of the _behaviour, call it '_currentPos':
    private double[] _currentPos;

    /**
     * Constructor for objects of class MoveVertically
     */
    public MoveVertically()
    {
        // INITIALISE the _vector field with a value of 1.0:
        _vector = 1.0;
    }
    
    /**
     * 
     * METHOD: used to assign the field _behaviour and retrieve the values held in the IBehaviour 
     * 
     * @param   _b   the IBehaviour class this component will use to update its y position
     * 
     */
    public void Initialise(IBehaviour _b)
    {
        // INITIALISE the _behaviour field with the IBehaviour passed as the argument:
        _behaviour = _b;
        
        // INITIALISE the _increment field with the value return calling the IBehaviour getSpeed():
        _incrementVal = _behaviour.getSpeed();
        
        // INITIALISE the _currentPos field with the values return calling the IBehaviour getPosition();
        _currentPos = _behaviour.getPosition();
    }
    
    /**
     * GETTER
     * METHOD: used to return the name of this component which is held in the _name field
     * 
     * @return  String   the name of this component
     */
    public String getName()
    {
        // RETURN the _name field to caller:
        return _name;
    }

    /**
     * 
     * METHOD: used to remove all references to the IBehaviour and end functionality
     * 
     */
    public void TearDown()
    {
        // ASSIGN the _behaviour field to null:
        _behaviour = null;
        
    }
    
    /**
     * SETTER
     * METHOD: used to change the _vector field to the oppersite of its current value
     * 
     */
    private void changeVector()
    {
        _vector *= -1;
    }
    
    /**
     * GETTER
     * METHOD: used to retrieve the positional values of the IBehaviour held in the _behaviour class assigned in Initialise method
     * 
     * @return  a double array of the x,y and z properties of the IBehaviour
     * 
     */
    private double[] getPosition()
    {
        // RETURN the values found from calling IBehaviour getPosition():
        return _behaviour.getPosition();
    }
    
    /**
     * 
     * METHOD used to call the unique method this component adds to the IBehaviour. This method calls the changeVector private
     * method
     * 
     */
    public void componentAction()
    {
        // CALL the unique method for this component feed();
        changeVector();
    }
        
    /**
     * 
     * METHOD: used to update the y positional property of the IBehaviour held in the _behaviour field every frame
     * 
     */
    public void update()
    {
        // CALL the getPosition properties and assign it to the _currentPos field:  
        _currentPos = getPosition();
        
        // INITIALISE and assign a double to store the y position held in the _currentPos array:
        double _yPos = _currentPos[1];
        
        // INCREMENT the _yPos field using the vector for direction and _incrementVal for the amount:
        _yPos += _incrementVal * _vector;
        
        // CALL setPosition with the new values to update the y position
        _behaviour.setPosition(_currentPos[0],_yPos);

        
    }
}
