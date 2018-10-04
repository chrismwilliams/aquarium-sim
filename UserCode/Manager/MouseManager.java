package UserCode.Manager;

import UserCode.Behaviours.IObserver;
import UserCode.Behaviours.IObservable;

import java.util.List;
import java.util.ArrayList;

/**
 * MouseManager defines the behaviour of a class that watches an IObserver mouse click handler implementation.
 * This class implements the IObserver interface
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class MouseManager implements IObserver
{
    // DECLARE an IObservable field to store the mouse click handler class, call it '_clickHandler':
    private IObservable _clickHandler;

    // DECLARE a field for the IEntityListManager class that is used to add FishFood entities, call it '_eManger':
    private IEntityListManager _listManager;
    
    // DECLARE a field used for testing the endObserving method of type List, call it '_subjects':
    List<IObservable> _subjects;

    /**
     * @Deprecated
     * Constructor for objects of class MouseManager, used only for testing
     * 
     */
    @Deprecated
    public MouseManager()
    {
        // USED for testing
        _subjects = new ArrayList<IObservable>();
    }

    /**
     * Constructor for objects of class MouseManager
     * 
     * @param   _e   the IEntityListManager class that is called to add the FishFood token to the aquarium
     * 
     */
    public MouseManager(IEntityListManager _e)
    {
        // INITIALISE the _listManager field with the param passed:
        _listManager = _e;
    }

    /**
     * 
     * METHOD: used to add the IObservable mouse click handler which this class will 'watch' over and be alerted by
     * the IObservable implementation
     * 
     * @param   obj   the IObservable class that this class will watch
     * 
     */
    public void observeObj(IObservable obj)
    {
        // CALL the addObserver method of IObservable to notify is that this class should be notified once on 
        // a click event
        obj.addObserver(this);

        // INITIALISE the _clickHandler field with the param passed:
        _clickHandler = obj;
    }

    /**
     * 
     * METHOD: used to stop observing the IObservable initialised in the _clickHandler field. 
     * This method assigns the _clickHandler field to null
     * 
     * @param   obj   the IObservable class
     * 
     */
    public void endObserving(IObservable obj)
    {
        // INITIALISE the _clickHandler field to null:
        _clickHandler = null;
    }

    /**
     * 
     * METHOD: used to call the IEntityManager addEntity method to request to add a new FishFood entity to the world at the x,y position passed
     * 
     * @param   _mPos   the x and y position the FishFood entity should be placed at
     * 
     */
    private void callEntityManager(double[] _mPos)
    {
        //System.out.println("Calling _listManager");

        // CHECK if the _listManager field is not equal to null:
        if (_listManager != null) 
        {
            // IF not then call the _listManager addEntity method asking for a FishFood entity at the x and y positions
            _listManager.addEntity("FishFood", _mPos[0], _mPos[1]);
        }
    }

    /**
     * 
     * METHOD: used by the IObservable class to inform this class that an event occurred. This method will then
     * call getUpdate() method of IObservable to retrieve the mouse click x & y position and pass that to the callEntityManager method
     * 
     * @param   obj   the object that has an update
     * 
     */
    public void update(IObservable obj)
    {
        // System.out.println("MouseManager has been called");

        // CALL the callEntityManager() method passing the values from the obj.getUpdate method as a left mouse button has been clicked:
        callEntityManager(obj.getUpdate());

    }
    
    /**
     * @Deprecated
     * METHOD: used for testing another production class. This method shouldn't be used
     * 
     */
    @Deprecated
    public List rtnSubjects()
    {
        // RETURN a List containing the IObservable class _clickHandler:
        List<IObservable> _subjects = new ArrayList<IObservable>();
        _subjects.add(_clickHandler);
        return _subjects;
    }
}
