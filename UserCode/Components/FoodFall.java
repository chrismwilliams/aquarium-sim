package UserCode.Components;

import UserCode.Behaviours.IBehaviour;

/**
 * FoodFall defines the behaviour of an IComponent of a pet that is defined as fish food in an aquarium. This class wraps the IComponent
 * MoveVertical to control the IBehaviour to fall to the bottom of the aquarium, at which point the IBehaviour will stop moving
 *
 * @author Chris Williams
 * @version 3.0
 */
public class FoodFall implements IComponent
{
    // DECLARE and initialise a String to hold the name of the component, call it '_name':
    private String _name = "foodfall";

    // DECLARE an IBehaviour field, call it '_behaviour':
    private IBehaviour _behaviour;

    // DECLARE an IComponent instance to aid in vertical movement, call it '_moveVertically':
    private IComponent _moveVertically;

    // DECLARE a double to store the current IBehaviour position, call it '_currentPos':
    private double[] _currentPos;

    // DECLARE a boolean to determine whether the update method should run, call it '_isActive':
    private boolean _isActive;

    // DECLARE a double to hold the minimum value the object is allowed to move to, call it '_minY':
    private double _minY;

    /**
     * Constructor for objects of class FoodFall
     * 
     * @param   minY   the minimum y position value the IBehaviour object is allowed to move to
     * 
     */
    public FoodFall(double minY)
    {
        // INITIALISE the _minY field with the param passed:
        _minY = minY;

        // INITIALISE the IComponent _moveVertically field:
        _moveVertically = new MoveVertically();

        // SET the isActive field to false:
        _isActive = false;
    }

    /**
     * 
     * METHOD: used to assign the field _behaviour and initialise the _moveVertically field with the IBehaviour
     * 
     * @param   _b   the IBehaviour class this component will use to update its y position via the _moveVertically field
     * 
     */
    public void Initialise(IBehaviour _b)
    {
        // INITIALISE the _behaviour field with the IBehaviour passed as the argument:
        _behaviour = _b;

        // CALL the Initialise method of the IComponent _moveVertically:
        _moveVertically.Initialise(_b);

        // CALL the componentAction method to change the _moveVertially vector:
        _moveVertically.componentAction();

        // SET the _isActive field to true:
        _isActive = true;

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

        // CALL the _moveVertically TearDown() method:
        _moveVertically.TearDown();

    }

    /**
     * 
     * METHOD: not used for this IComponent as the IBehaviour should continue to fall until it reaches the _minY field
     * 
     */
    public void componentAction()
    {
        // NOT used in this IComponent
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
     * METHOD: used to check if the current position is less than the _minY field. If it is then this method
     * will set the _isActive field to false which will end the update method from updating the position
     *  
     */
    private void checkPosition()
    {
        // CALL getPosition to retrieve positional values:
        _currentPos = getPosition();

        // INITIALISE and assign a double to store the _currentPos Y position, call it '_yPos':
        double _yPos = _currentPos[1];

        // CHECK if the y position of the IBehaviour is less than or greater than _minY field:
        if(_yPos <= _minY)
        {
            // IF it is then set the _isActive field to false:
            _isActive = false;
        }
    }

    /**
     * 
     * METHOD: used to update the y positional property of the IBehaviour held in the _behaviour field every frame if the _isActive
     * field is set to true
     * 
     */
    public void update()
    {
        // CHECK if the _isActive field is true:
        if(_isActive)
        {
            // IF it is:
            
            // CALL the checkPosition method():
            checkPosition();
            
            // CALL the _moveVertially update method():
            _moveVertically.update();
        }
    }
}
