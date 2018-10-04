package UserCode.Behaviours;

import java.util.List;

/**
 * IObserver defines the concrete implementation of a class that observes an IObservable class and the methods required
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public interface IObserver
{
    /**
     * 
     * METHOD: used by an IObservable class to notify an IObserver that an event occurred
     * 
     * @param   obj   a reference to the IObservable class the event occurred on
     * 
     */
    void update(IObservable obj);
    
    /**
     *
     * METHOD: used to pass a reference of an IObservable class that an IObserver implementation should keep a reference of
     *
     * @param   obj  an IObservable class that a concrete implementation should store
     * 
     */
    void observeObj(IObservable obj);
    
    /**
     * 
     * METHOD: used to end 'watching' an IObservable class and remove it's internal reference
     * 
     * @param   obj   an IObservable class that a concrete implementation should remove and 'forget'
     * 
     */
    void endObserving(IObservable obj);
    
    /**
     * @Deprecated
     * METHOD: used only for testing to return the _subjects array
     * 
     */
    @Deprecated
    public List rtnSubjects();
}
