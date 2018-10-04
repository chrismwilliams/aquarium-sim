package UserCode.Components;

import UserCode.Behaviours.IBehaviour;

/**
 * Preditor defines the behaviour of a components that a pet should include if it is defined as a preditor. This component will
 * increase the size of the IBehaviour once its componentAction method is called.
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class Preditor implements IComponent
{
    // DECLARE and initialise a String of the name of the component, call it _name:
    private String _name = "preditor";
    
    // DECLARE an IBehaviour field that will store the behaviour this component will 'act' on,
    // call it '_behaviour':
    private IBehaviour _behaviour;
        
    // DECLARE an instance of the Feed class this class wraps, call it '_feed':
    private IComponent _feed;

    /**
     * 
     * Constructor for objects of class Preditor
     * 
     */
    public Preditor()
    {
      // INITIALISE the IComponent Feed:
      _feed = new Feed();
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
        
        // INITIALISE the IComponent with the IBehaviour:
        _feed.Initialise(_b);
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
     * METHOD: used to increase the size of the preditor once this method is called. This method calls the _feed IComponent
     * componentAction method increment the scale of the image
     * 
     */
    private void feed()
    {
        // INCREASE the preditor size by calling the componentAction method:
        _feed.componentAction();        
    }
    
    /**
     * 
     * METHOD used to call the unique method this component adds to the IBehaviour. This method calls the feed private method
     * when an IBehaviour is required to increase in scale
     * 
     */
    public void componentAction()
    {
        // CALL the unique method for this component feed();
        feed();
    }
    
    /**
     * 
     * METHOD: this method is left empty as the component is primarily used by a preditor to increment the scale
     * 
     */
    public void update()
    {
        // METHOD is not used
    }
}
