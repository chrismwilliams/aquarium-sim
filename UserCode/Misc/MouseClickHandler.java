package UserCode.Misc;

import UserCode.Behaviours.IObserver;

import env3d.Env;

/**
 * MouseClickHandler is the concrete implementation of the IMouseClickHandler interface. This class is used
 * to monitor an Env world to check if the left mouse button has been clicked and notify an IObserver class
 * 
 * @author Marc Price & Chris Williams
 * @version 3.0
 */
public class MouseClickHandler implements IMouseClickHandler
{
    // DECLARE a variable to reference an Env class, call it '_world':
    Env _world;
    
    // DECLARE a field to store the IObserver instance, call it '_observer':
    IObserver _observer;
    
    // DECLARE two fields to store the values for the x & y positions of the mouse, call it '_mouseX' '_mouseY':
    double _mouseX, _mouseY;
    
    /**
     * Constructor for objects of class MouseHandler. This constructor is for testing purposes only
     *  
     */
    @Deprecated
    public MouseClickHandler()
    {
        // USED for testing to assign _mouseX and _mouseY to -1.0:
        _mouseX = -1.0;
        _mouseY = -1.0;
    }
        
    /**
     * Constructor for objects of class MouseHandler
     * 
     * @param   env   a reference to an Env class which this class will monitor for left mouse clicks
     * 
     */
    public MouseClickHandler(Env env)
    {
        // INITIALISE the _world field with the param Env param passed:
        _world = env;
    }
    
    /**
     * @Deprecated
     * GETTER
     * METHOD: used for testing purposes to return the Env reference held in the _world field
     * 
     */
    @Deprecated
    public Env getWorldRef()
    {
        // RETURN the _world field to the caller
        return _world;
    }
    
    /**
     * 
     * METHOD: used to add an IObserver concrete class to the single _observer field. This will then be notified
     * once a left click is detected
     * 
     * @param   _o   the IObserver class that will be notified once the left mouse button is clicked
     * 
     */
    public void addObserver(IObserver _o)
    {
        // INITIALISE the _observer field with the IObserver passed:
        _observer = _o;
    }
    
    /**
     * 
     * METHOD: used to remove the single IObserver held in the _observer field. This sets the field to null
     * 
     * @param   _o   this removes any reference to the IObserver in the _observer field
     * 
     */
    public void removeObserver(IObserver _o)
    {
        // SET the _observer field to null:
        _observer = null;
    }
    
    /**
     * 
     * @Deprecated
     * GETTER
     * METHOD: used in testing to return the field _observer
     * 
     */
    @Deprecated
    public IObserver getObserver()
    {
        // RETURN the IObserver found in the _observer field:
        return _observer;
    }
    
    /**
     * 
     * METHOD:  used to notify the IObserver that an event has occurred. This method firstly checks if an IObserver
     * has been initialised in the _observer field and then calls the IObserver update() method
     * 
     */
    public void notifyObservers()
    {
        // CHECK if the _observer field is empty:
        if(_observer != null)
        {
            // CALL the update method on the field _observer:
            _observer.update(this);
        }
    }
    
    /**
     * 
     * METHOD: used to get the mouse x & y coordinates. This method should be used by an IObserver once this class
     * has called the IObserver update method, as a new click event has occurred
     * 
     * @return  double[]   the mouse x and y coords of the left click event location
     * 
     */
    public double[] getUpdate()
    {
        // INITIALISE and assign an array of doubles with the _mouseX and _mouseY values:
        double[] _mousePosition = {_mouseX,_mouseY};
        
        // RETURN _mousePositon to the call:
        return _mousePosition;
    }

    /**
     * 
     * METHOD: this method should be continually used to check if the Env world has detected a left mouse click.
     * Onced clicked it will update the _mouseX & _mouseY fields and call the notifyObservers() method
     *
     */
    public void checkMouse()
    {
        // CHECK if the left mouse button has been clicked
        if (_world.getMouseButtonClicked() == 0)
        {
            // System.out.println("Left mouse clicked");
            
            // IF true assign the values to the fields _mouseX, _mouseY by calling the getMouseX 
            // and getMouseY methods:
            _mouseX = _world.getMouseX();
            _mouseY = _world.getMouseY();
            
            // System.out.println(_mouseX * 0.0077 + "  " + _mouseY * 0.0077);
            
            // ADJUST _mouseX and _mouseY coords for the aquarium:
            _mouseX = _mouseX * 0.0077;
            _mouseY = _mouseY * 0.0077;
            
            // NOTIFY the observer of event:
            notifyObservers();
        }
        
    }
    
    

}