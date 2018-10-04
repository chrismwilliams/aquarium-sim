package UserCode.Behaviours;

/**
 * IObservable describes the methods a concrete implementation should include to become an IObservable and how an
 * IObserver will access the concrete implementation
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public interface IObservable
{
    /**
     * 
     * METHOD: used to pass a reference to an IObserver concrete class which should be stored internally. This will then be notified
     * once an action/effect is detected
     * 
     * @param   _o   the IObserver class to be notified
     * 
     */
    void addObserver(IObserver _o);

    /**
     * 
     * METHOD: used to pass a reference of the IObserver to remove itself from being alerted when an effect/action occurs
     * 
     * @param   _o   the reference to the IObserver that should be removed
     * 
     */
    void removeObserver(IObserver _o);

    /**
     * 
     * METHOD:  used to notify all IObserver's of the event it is subscribed to. This method should update all IObservers that have been
     * added internally
     * 
     */
    void notifyObservers();

    /**
     * 
     * METHOD: used be the IObserver to access the array of doubles the action occurred at. This method should be used by an IObserver once it
     * has called using the notifyObserver method
     * 
     * @return  double[]   the event location as an array of doubles
     * 
     */
    double[] getUpdate();

    /**
     * 
     * @Deprecated
     * GETTER
     * METHOD: used for testing purposes to return the IObserver reference a concrete implementation should contain
     * 
     */
    @Deprecated
    IObserver getObserver();
    
}
