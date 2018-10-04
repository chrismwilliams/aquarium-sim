package UserCode.Components;

import UserCode.Behaviours.IBehaviour;

/**
 * Feed defines the behaviour of a components that a pet should include if it is to 'eat', the IBehaviour scale is then increased
 *
 * @author Chris Williams
 * @version 3.0
 */
public class Feed implements IComponent
{
    // DECLARE and initialise a String of the name of the component, call it _name:
    private String _name = "feed";

    // DECLARE an IBehaviour field that will store the behaviour this component will 'act' on,
    // call it '_behaviour':
    private IBehaviour _behaviour;

    // DECLARE and initialise a double to represent the maximum scale a fish is allowed to grow, call it '_maxScale':
    double _maxScale = 0.39;

    /**
     * Constructor for objects of class Feed
     */
    public Feed()
    {
        // Fields initialised in Initialise method 
    }

    /**
     * 
     * METHOD: to be used to assign the _behaviour field with the param passed
     * 
     * @param   _b   the IBehaviour this class will use
     * 
     */
    public void Initialise(IBehaviour _b)
    {
        // INITIALISE the _behaviour field to the param passed:
        _behaviour = _b;
    }

    /**
     * 
     * METHOD: used to return the name of the name of this component held in the _name field
     * 
     * @return  a String held in the _name field
     * 
     */
    public String getName()
    {
        // RETURN the _name field to the caller:
        return _name;
    }

    /**
     * 
     * METHOD: used to set the _behaviour field to null
     * 
     */
    public void TearDown()
    {
        // SET the _behaviour field to null:
        _behaviour = null;
    }

    /**
     * 
     * METHOD: used to get the scale of the IBehaviour in the _behaviour field
     * 
     * @param   double   the scale of the pet which is return by calling the getScale method of the IBehaviour
     * 
     */
    private double getScale()
    {
        return _behaviour.getScale();
    }

    /**
     * 
     * METHOD: used to increase the size of the pet once this method is called. This method will call IBehaviour setScale() 
     * and increment it by 0.01 each time
     * 
     */
    private void eat()
    {
        // INCREASE the IBehaviour size by calling the setScale method on the _behaviour:
        // CREATE and initialise a double to store the scale, call it '_scale':
        double _scale = getScale();

        // CHECK if the _scale is already at the maximum value _maxScale:
        if(_scale < _maxScale)
        {
            // INCREMENT the scale value:
            _behaviour.setScale(_scale + 0.01);
        }
    }

    /**
     * 
     * METHOD: used to call the unique method this component adds to the IBehaviour. This method calls the eat private method
     * when an IBehaviour is required to increase in scale
     * 
     */
    public void componentAction()
    {
        // CALL the unique method for this component feed();
        eat();
    }

    /**
     * 
     * METHOD: this method is left empty as the component is primarily used by a pet to increment the scale
     * 
     */
    public void update()
    {
        // METHOD is not used
    }

}
