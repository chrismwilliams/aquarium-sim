package UserCode.Components;

import UserCode.Behaviours.IBehaviour;

/**
 * MoveHorizontal defines a movement behaviour by considering the boundary it is placed within and used by a pet to move
 * horizontally within those parameters
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class MoveHorizontal implements IComponent
{
    // DECLARE and Initialise a String to hold the name of the component, call it '_name':
    private String _name = "moveinboundary";

    // DECLARE an IBehaviour field, call it '_behaviour':
    private IBehaviour _behaviour;

    // DECLARE a double to hold the maximum value the IBehaviour is allowed to move to, call it '_max':
    private double _max;

    // DECLARE a double to hold the minimum value the IBehaviour is allowed to move to, call it '_min':
    private double _min;

    // DECLARE a double to hold the vector direction, call it '_vector':
    private double _vector;

    // DECLARE a double to hold the value this class will add to the x position, call it '_incrementVal':
    private double _incrementVal;

    // DECLARE an IComponent to change the direction of the IBehaviour when the direction is changed, call it '_rotateObj':
    private IComponent _rotateObj;

    // DECLARE a double to store the positional properties of the IBehaviour class, call it '_currentPos':
    private double[] _currentPos;

    /**
     * Constructor for objects of class MoveHorizontal
     * 
     * @param   minVal   the minimum value this class is allowed to move on the horizontal plane
     * @param   maxVal   the maximum value this class is allowed to move on the horizontal plane
     * 
     */
    public MoveHorizontal(double minVal, double maxVal)
    {
        // INITIALISE the _min field with the minVal passed:
        _min = minVal;

        // INITIALISE the _max field with the maxVal passed:
        _max = maxVal;

        // INITIALISE the _vector field to 1.0:
        _vector = 1.0;

        // INITAILISE the _rotateObj field with a RotateObj class:
        _rotateObj = new RotateObj();
    }

    /**
     * 
     * METHOD: used to set the _behaviour field with the IBehaviour passed. This method will then assign the IBehaviour
     * properties this component requires to function
     * 
     * @param   _b   the behaviour class that is required to move horizontally
     * 
     */
    public void Initialise(IBehaviour _b)
    {
        // INITIALISE the _behaviour field to the param passed:
        _behaviour = _b;

        // INITIALISE the _incrementalVal by calling the IBehaviour getSpeed method:
        _incrementVal = _behaviour.getSpeed();

        // INTIALISE the _currentPos field by calling the Ibehaviour getPosition method:
        _currentPos = _behaviour.getPosition();

        // CALL the Initialise method of the _rotateObj field and pass the reference to the IBehaviour passed:
        _rotateObj.Initialise(_b);

    }

    /**
     * GETTER
     * METHOD: used to return the name of this component which is held in the _name field
     * 
     * @return  String   the name of this component
     * 
     */
    public String getName()
    {
        // RETURN the _name field:
        return _name;
    }

    /**
     * 
     * METHOD: used to set the _behaviour field to null and to call the _rotateObj TearDown when the components are no longer required
     * 
     */
    public void TearDown()
    {
        // SET the _behaviour field to null:
        _behaviour = null;

        // CALL the TearDown method of the IComponent held in the _rotateObj field:
        _rotateObj.TearDown();

    }

    /**
     * SETTER
     * METHOD: used to change the _vector field to the oppersite of its current value
     * 
     */
    private void changeVector()
    {
        // SET the vector to the opposite of its value:
        _vector *= -1;
    }

    /**
     * 
     * GETTER
     * METHOD: used to retrieve the positional values of the IBehaviour held in the _behaviour class assigned in Initialise method
     * 
     * @return  a double array of the x,y and z properties of the IBehaviour
     * 
     */
    private double[] getPosition()
    {
        // RETURN the _behaviour positional properties by calling the IBehaviour getPosition method:
        return _behaviour.getPosition();
    }

    /**
     * 
     * METHOD: used to check if the current position is less than or greater than the _min and _max fields. If it is then this method
     * will call the changeVector method and the update method of _rotateObj.
     * 
     * @return  a double of the x position of the IBehaviour
     * 
     */
    private double checkPosition()
    {
        // CALL getPosition to retrieve positional values:
        _currentPos = getPosition();

        // INITIALISE and assign a double to store the _currentPos x position, call it '_xPos':
        double _xPos = _currentPos[0];

        // CHECK if the x position of the IBehaviour is less than or greater than _min and _max fields:
        if (_xPos <= _min || _xPos >= _max)
        {
            // IF it is change the vector:
            changeVector();

            // CALL componentAction on _rotateObj to flip the image:
            _rotateObj.componentAction();

        }

        // RETURN the _xPos field to caller:
        return _xPos;
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
     * METHOD: used on each frame to update and check the x position of the IBehaviour. This method calls the checkPosition method firstly
     * to check if the object is within the _min and _max boundaries
     *  
     */
    public void update()
    {
        // CALL checkPostion to make sure _behaviour is within the _min and _max fields and store the returned value in a new field
        // call it '_newPos':
        double _newPos = checkPosition();

        // INCREMENT the _newPos field using the result of _incrementalVal times the _vector field:
        _newPos += _incrementVal * _vector;

        // SET the new position by calling the IBehaviour setPosition method:
        _behaviour.setPosition(_newPos, _currentPos[1]);

    }
}
