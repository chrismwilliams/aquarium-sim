package UserCode.Behaviours;

import UserCode.Components.IComponent;

import java.util.List;

/**
 * IBehaviour Interface defines the behaviours for all pets within the aquarium simulation and the helper methods they have
 * access to
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public interface IBehaviour
{

    /**
     * 
     * METHOD: Generate a random speed to assign to a _speed field, should be between 0.005 and 0.05
     * 
     */
    void generateSpeed();

    /**
     * Overloaded method
     * METHOD: Generate a random speed which will be either fast or slow. Fast is between - 0.05 & 0.0225, Slow is between 0.010 & 0.005
     * 
     * @param   s   a String, either "fast" or "slow" to generate a random number
     * 
     */
    void generateSpeed(String s);

    /**
     * GETTER
     * METHOD: Get the value held within the _speed field
     * 
     * @return  double   returns the field _speed to caller
     * 
     */
    double getSpeed();

    /**
     * SETTER
     * METHOD: Set the scale of the pet in the aquarium
     * 
     * @param   s   a double representing the scale of the pet
     * 
     */
    void setScale(double s);
    
    /**
     * GETTER
     * METHOD: Get the scale of the pet in the aquarium
     * 
     * @return  a value of type double representing the scale
     * 
     */
    double getScale();

    /**
     * SETTER
     * METHOD: Set the scale of the pet in the aquarium to a random value
     * 
     */
    void randomScale();

    /**
     * 
     * METHOD: Place the pet at a random position based on the param. Method randomises x & y position
     * 
     * @param   _placement   of type string representing the general position to set the y coord ("top", "bottom")
     * 
     */
    void setStartPosition(String _placement);

    /**
     * SETTER
     * METHOD: Set a new Orientation of the pet on the x and y axis. 
     * 
     * @param   _oriX   a double for the x Orientation
     * @param   _oriY   a double for the y Orientation
     * 
     * 
     */
    void setOrientation(double _oriX, double _oriY);

    /**
     * 
     * METHOD: Set a new Orientation of the pet on all axis
     * 
     * @param   _oriX   the new X orientation
     * @param   _oriY   the new Y orientation
     * @param   _oriZ   the new Z orientation
     * 
     */
    void setOrientation(double _oriX, double _oriY, double _oriZ);
    
    /**
     * GETTER
     * METHOD: GETTER to retrieve the orientation of the pet
     * 
     * @return  double[]   returns the value of the orientations as an array of doubles
     * 
     */
    double[] getOrientation();

    /**
     * SETTER
     * METHOD: Set a new position of the pet within the aquarium on the X and Y axis
     * 
     * @param   newX   the new X position
     * @param   newY   the new Y position
     * 
     */
    void setPosition(double newX, double newY);
    
    /**
     * OVERLOADED SETTER
     * METHOD: set the position of the pet on the x and y and z axis, method updates the IToken with the new values.
     * 
     * @param   newX   the x position
     * @param   newY   the y position
     * @param   newZ   the z position
     * 
     */
    void setPosition(double newX, double newY, double newZ);

    /**
     * GETTER
     * METHOD: Return the X Y and Z fields held in IToken
     * 
     * @return  an array of doubles {x,y,z}
     * 
     */
    double[] getPosition();

    /**
     * 
     * METHOD: to be used to add new IComponents to the _components HashMap. 
     * 
     * 
     * @param   _component   the new component to add
     * 
     */
    void addComponent(IComponent _component);
    
    /**
     * 
     * METHOD: used to get a specific IComponent within an IComponent's HashMap. This method will return
     * the HashMap value which is the IComponent
     * 
     * @param   _name   the 'key' String name of the component
     * 
     * @return  IComponent   the IComponent requested, if not found null will be returned
     * 
     */
    IComponent getIComponent(String _name);
    
    /**
     *
     * ABSTRACT
     * METHOD: Used to set-up any properties and components the class requires
     * 
     * @param   an arrayList of IComponents the IBehaviour concrete class requires
     *
     */
    abstract void Initialise(List<IComponent> _components);

    /**
     *
     * METHOD: Used to clean up any threads or active components that need shutting down
     *
     */
    abstract void Terminate();
    
    /**
     * ABSTRACT
     * METHOD: Used to update the pets specific properties based on the IComponents and the main method called by the Entity Manager
     *   
     */
    abstract void update();
}
