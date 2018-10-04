package UserCode.Misc;

import UserCode.Behaviours.IObservable;

import env3d.Env;

/**
 * IMouseClickHandler defines an extended interface for an 'Observable' mouse handler. This interface adds a
 * checkMouse() method to the IObservable interface
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public interface IMouseClickHandler extends IObservable
{
    /**
     * 
     * METHOD: this method is used to check if the mouse has been clicked. If it has then notify an Observer and pass on the x and y
     * values using the IObservable method getUpdate()
     * 
     */
    void checkMouse();
    
    /**
     * 
     * @Deprecated
     * GETTER
     * METHOD: used for testing purposes to return the Env reference a concrete implementation requires to check if the Env has been click on
     * 
     */
    @Deprecated
    Env getWorldRef();
}
