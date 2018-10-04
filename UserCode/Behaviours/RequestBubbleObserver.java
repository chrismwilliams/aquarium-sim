package UserCode.Behaviours;

import UserCode.Manager.IEntityListManager;

import java.util.List;
import java.util.ArrayList;

/**
 * BubbleObserver defines the behaviour of a class that watches IObservable implementations to be notified when a bubble is requested
 * This class will then request a bubble at the position of the IObservable class IBehaviour that called the update method
 *
 * @author Chris Williams 
 * @version 3.0
 */
public class RequestBubbleObserver implements IObserver
{
    // DECLARE a field of type List to store a number of IObservable objects, call it '_subjects':
    private List <IObservable> _subjects;
    
    // DECLARE a field of type IEntityManager to call to add an IEntity of bubble:
    private IEntityListManager _listManager;
    
    /**
     * 
     * Constructor for objects of class BubblerObserver
     * 
     */
    @Deprecated
    public RequestBubbleObserver()
    {
        // USED in testing
        // INITIALISE the _subject array with a new ArrayList containing IObservable implementations:
        _subjects = new ArrayList<IObservable>();
    }
    
    /**
     * Constructor for objects of class BubbleObserver
     * 
     * @param   e   the IEntityListManager implementation this class will use to add a bubble
     * 
     */
    public RequestBubbleObserver(IEntityListManager e)
    {
        // INITIALISE the _subject array with a new ArrayList containing IObservable implementations:
        _subjects = new ArrayList<IObservable>();
        
        // INITIALISE the _listManager field with the param passed:
        _listManager = e;
    }
    
    /**
     * 
     * METHOD: used to add an IObservable class to the _subjects array and to notify the IObservable that this class should
     * be notified once an event occurs
     * 
     * @param   obj   the IObservable this class should 'watch' and register with calling the addObserver method
     * 
     */
    public void observeObj(IObservable obj)
    {
        // CALL the IObservable addObserver method and pass this to initialise: 
        obj.addObserver(this);
        
        // ADD the IObservable to the _subjects array:
        _subjects.add(obj);
        
        // System.out.println(_subjects.size());
    }
    
    /**
     * 
     * METHOD: used to stop observing an IObservable class and remove it from the _subject array
     * 
     * @param   obj   the IObservable class to stop watching
     * 
     */
    public void endObserving(IObservable obj)
    {
        //
        _subjects.remove(obj);
        
        // System.out.println(_subjects.size());
    }
    
    /**
     * 
     * METHOD: used to call the IEntityManager addEntity method to request to add a new Bubble entity to the world at the x,y position passed
     * 
     * @param   _mPos   the x and y position the FishFood entity should be placed at
     * 
     */
    private void callEntityManager(double[] _mPos)
    {
        //System.out.println("Bubble request observer");
        //System.out.println("xpos: " + _mPos[0] + " ypos: " + _mPos[1]);
        
        //
        _listManager.addEntity("Bubble", _mPos[0], _mPos[1]);
    }
    
    /**
     * 
     * METHOD: used by the IObservable class to notify of an event. This method will then
     * call getUpdate() method of IObservable to retrieve the IEntity position and pass that to the callEntityManager method
     * 
     * @param   obj   the object reference that has an update event
     * 
     */
    public void update(IObservable obj)
    {
        // System.out.println("BubbleObserver called");
               
        // CALL the callEntityManager() method passing the values from the obj.getUpdate method as a left mouse button has been clicked:
        callEntityManager(obj.getUpdate());
        
        // System.out.println("The x: " + _pos[0] + " The y: " + _pos[1]);
        
    }
    
    /**
     * @Deprecated
     * METHOD: used only for testing to return the _subjects array
     * 
     */
    @Deprecated
    public List rtnSubjects()
    {
        // RETURN the subjects array:
        return _subjects;
    }
}
