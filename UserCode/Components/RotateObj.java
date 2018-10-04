package UserCode.Components;

import UserCode.Behaviours.IBehaviour;

/**
 * RotateObj class defines a IComponent implementation which changes the y orientation of an IBehaviour 
 * 
 * @author Chris Williams
 * @version 3.0
 */
public class RotateObj implements IComponent
{
    // DECLARE and initialise a String to hold the name of the IComponent, call it '_name':
    private String _name = "rotateobj";

    // DECLARE an IBehaviour field, call it '_behaviour':
    private IBehaviour _behaviour;

    // DECLARE a double to store the x orientation of the IBehaviour, call it '_rotateX':
    private double _rotateX;

    // DECLARE a double to store the y orienation of the IBehaviour, call it '_rotateY':
    private double _rotateY;

    /**
     * Constructor for objects of class RotateObj
     */
    public RotateObj()
    {
        // Fields assigned in Initialise method:
    }

    /**
     *  
     * METHOD: used to set the _behaviour field with the IBehaviour passed. This method will then assign the fields _rotateX
     * and _rotateY, taken from the IBehaviour
     * 
     * @param   _b   the behaviour class whose image will be rotated
     *  
     */
    public void Initialise(IBehaviour _b)
    {
        // INITIALISE the _behaviour field to the param passed:
        _behaviour = _b;

        // DECLARE and initalise an array of doubles by calling the IBehaviour getOrientation method, call it '_rotationVals':
        double[] _rotationVals = _behaviour.getOrientation();

        // INITIALISE the _rotateX field with the first index of _rotationVals:
        _rotateX = _rotationVals[0];

        // INITIALISE the _rotateY field with the second index of _rotationVals:
        _rotateY = _rotationVals[1];

    }

    /**
     * 
     * METHOD: used to set the _behaviour field to null which should be triggered to end opperations
     * 
     */
    public void TearDown()
    {
        // SET the _behaviour field to null:
        _behaviour = null;
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
     * METHOD: Used to set the Y Orientation of the image to the oppersite by calling the IBehaviour setOrientation with the new values
     * 
     */
    private void flipOrientation()
    {
        // SET the _rotateY field to the oppersite:
        _rotateY *= -1;

        // CALL the setOrientation method of the IBehaviour with the _rotateX and the new _rotateY field:
        _behaviour.setOrientation(_rotateX, _rotateY);
    }

    /**
     * 
     * METHOD used to call the unique method this component adds to the IBehaviour. This method calls the flipOrientation private method
     * when an IBehaviour image needs to by flipped on the y axis
     * 
     */
    public void componentAction()
    {
        // CALL the unique method for this component flipOrientation();
        flipOrientation();
    }

    /**
     * 
     * METHOD: this method is left empty as the component is primarily used to flip the IBehaviour image
     * 
     */
    public void update()
    {
        // METHOD is not used
    }
}
