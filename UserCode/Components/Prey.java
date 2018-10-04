package UserCode.Components;

import UserCode.Behaviours.IBehaviour;

/**
 * Prey defines the behaviour of an IComponent implementation to be used by pets that are 'eaten' by a preditor. The unique
 * componentAction method will then inform the IBehaviour to Terminate as it will be deleted
 * 
 * @author Chris Williams
 * @version 3.0
 */
public class Prey implements IComponent
{
    // DECLARE and initialise a String of the name of the component, call it _name:
    private String _name = "prey";
    
    // DECLARE an IBehaviour field that will store the behaviour this component will call Terminate on,
    // call it '_behaviour':
    private IBehaviour _behaviour;

    /**
     * Constructor for objects of class Prey
     */
    public Prey()
    {
        // Fields initialised in the Initialise method
    }
    
    /**
     * 
     * METHOD: used to assign the _behaviour field with the param passed
     * 
     * @param   _b   the IBehaviour class this component will call Terminate on when the eaten method is called
     * 
     */
    public void Initialise(IBehaviour _b)
    {
        // INITIALISE the _behaviour field with the param passed:
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
     * METHOD: used to end operations of the IBehaviour within the aquarium. This method calls the Terminate
     * method of the IBehaviour which calls TearDown on all IComponents it contains as it will be removed
     * 
     */
    private void eaten()
    {        
        // CALL Terminate on the _behaviour IBehaviour:
        _behaviour.Terminate();
    }
    
    /**
     * 
     * METHOD used to call the unique method this component adds to the IBehaviour. This method calls the eatean private method
     * when an IBehaviour is required to be removed
     * 
     */
    public void componentAction()
    {
        // CALL the unique method for this component eaten();
        eaten();
    }
    
    /**
     * 
     * METHOD: this method is left empty as the component is primarily used by a prey 
     * 
     */
    public void update()
    {
        // METHOD is not used
    }
}
