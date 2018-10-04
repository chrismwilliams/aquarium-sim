package UserCode.Components;

import UserCode.Behaviours.IBehaviour;

/**
 * MoveDiag defines a movement behaviour which acts upon an IBehaviour so that it moves diagonally direction within the boundaries
 * set in construction. This class wraps the IComponent class MoveHorizontal and MoveVertically
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class MoveDiag implements IComponent
{
    // DECLARE and Initialise a String to hold the name of the component, call it '_name':
    private String _name = "movediag";

    // DECLARE an IBehaviour field, call it '_behaviour':
    private IBehaviour _behaviour;

    // DECLARE an IComponent class to be used as a helper class to move the IBehaviour horizontally, call it '_moveHorizontal':
    private IComponent _moveHorizontal;

    // DECLARE an IComponent class to be used to help move the IBehaviour vertically, call it '_moveVertically':
    private IComponent _moveVertically;

    // DECLARE a double to hold the minimum value the object is allowed to move to, call it '_minY':
    private double _minY;

    // DECLARE a double to hold the maximum value the object is allowed to move, call it '_maxY':
    private double _maxY;

    // DECLARE a double to store the positional properties of the IBehaviour class, call it '_currentPos':
    private double[] _currentPos;

    /**
     * Constructor for objects of class MoveDiag
     * 
     * @param   minX   the minimum x position value the IBehaviour object is allowed to move to
     * @param   maxX   the maximum x position value the IBehaviour object is allowed to move to
     * @param   minY   the minimum y position value the IBehaviour object is allowed to move to
     * @param   maxY   the maximum y position value the IBehaviour object is allowed to move to
     * 
     */
    public MoveDiag(double minX, double maxX, double minY, double maxY)
    {
        // ASSIGN the _moveHorizontal field with a new MoveHorizontal class and pass the minX and maxX values:
        _moveHorizontal = new MoveHorizontal(minX, maxX);

        // ASSIGN the _moveVertically field with a new MoveVertically class:
        _moveVertically = new MoveVertically();

        // ASSIGN the _minY field with the minY param:
        _minY = minY;

        // ASSIGN the _maxY field with the maxY param:
        _maxY = maxY;

    }

    /**
     * 
     * METHOD: used to set the _behaviour field with the IBehaviour passed and then assign the _incrementVal by calling the IBehaviour
     * getSpeed method. It also passes the IBehaviour to the _moveHorizontal & _moveVertically classes through the Initialise methods
     * 
     * @param   _b   the behaviour class that is required to move diagonally
     * 
     */
    public void Initialise(IBehaviour _b)
    {
        // ASSIGN the _behaviour field with the IBehaviour passed:
        _behaviour = _b;

        // CALL the Initialise method of the _moveHorizontal class with the IBehaviour passed:
        _moveHorizontal.Initialise(_b);

        // CALL the Initialise method of the _moveVertically class and pass on the IBehaviour:
        _moveVertically.Initialise(_b);

    }

    /**
     * 
     * METHOD: used to set the _behaviour field to null and to call the _moveHorizontal & _moveVertically TearDown method to do the same
     * 
     */
    public void TearDown()
    {
        // SET the _behaviour field to null:
        _behaviour = null;

        // CALL the TearDown method on the _moveHorizontal field
        _moveHorizontal.TearDown();

        // CALL the TearDown method on the _moveVertically field:
        _moveVertically.TearDown();
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
        // RETURN the _name String field to the caller:
        return _name;
    }

    /** 
     * SETTER
     * METHOD: used to change the _vector fields in both the _moveHorizontal class and _moveVertical class
     * 
     */
    private void changeVector()
    {
        // SET the vector to the opposite value for both _moveHorizontal and _moveVertically calling the componentAction() method:
        _moveHorizontal.componentAction();

        _moveVertically.componentAction();
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
        // RETURN the IBehaviour positional properties by calling the getPosition method of the IBehaviour:
        return _behaviour.getPosition();
    }

    /**
     * 
     * METHOD: used to check if the current position is less than or greater than the _minY and _maxY fields. If it is then this method
     * will call the componentAction method for the IComponent _moveVertically
     *  
     */
    private void checkPosition()
    {
        // CALL getPosition to retrieve positional values:
        _currentPos = getPosition();

        // INITIALISE and assign a double to store the _currentPos Y position, call it '_yPos':
        double _yPos = _currentPos[1];

        // CHECK if the y position of the IBehaviour is less than or greater than _minY and _maxY fields:
        if(_yPos <= _minY || _yPos >= _maxY)
        {
            // IF it is then change the vector for the _moveVertically IBehaviour:
            _moveVertically.componentAction();

            //System.out.println("Changed vector");
        }
    }

    /**
     * 
     * METHOD used to call the unique method this component adds to the IBehaviour. This method calls the changeVector private
     * method which changes both the vertical and horizontal vectors
     * 
     */
    public void componentAction()
    {
        // CALL the changeVector method;
        changeVector();
    }

    /**
     * 
     * METHOD: used to update the x and y positional properties by calling the _moveHorizontal and _moveVertically fields update every frame
     * 
     */
    public void update()
    {
        // CALL the update method of the _moveHorizontal class:
        _moveHorizontal.update();

        // CALL the update method of the _moveVertically class:
        _moveVertically.update();

        // CALL the checkPosition method to make sure the IBehaviour is within the _minY and _maxY values:
        checkPosition();
    }
}
