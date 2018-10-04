package UserCode.Pets;

import UserCode.Behaviours.IBehaviour;

/**
 * Entity: A class that contains both the token and the behaviour of the pet. Class is used to access both elements
 * and by the manager to update the the behaviours.
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class Entity implements IEntity
{
    // DECLARE a variable to store the instance of IToken, call it _token:
    private IToken _token;

    // DECLARE a variable to store the instance of IBehaviour, call it _behaviour:
    private IBehaviour _behaviour;

    /**
     * 
     * Constructor for objects of class Entity
     * 
     * @param   token   the token to be stored in the class
     * @param   behaviour   the behaviour to be stored in the class
     * 
     */
    public Entity(IToken token, IBehaviour behaviour)
    {
        // INITIALISE the _token field with the param token:
        _token = token;

        // INITIALISE the _behaviour field with the param behaviour:
        _behaviour = behaviour;
    }

    /**
     * 
     * METHOD: used to get the instance of the token held in the _token field
     * 
     * @return  _token   the instance of the IToken the entity contains
     * 
     */
    public IToken getToken()
    {
        // RETURN _token:
        return _token;        
    }

    /**
     * 
     * METHOD: used to get the instance of the behaviour held in the _behaviour field
     * 
     * @return  _behaviour   the instance of the IBehaviour the entity contains
     * 
     */
    public IBehaviour getBehaviour()
    {
        // RETURN _behaviour:
        return _behaviour;        
    }

    /**
     * 
     * METHOD: used to call the update method within the _behaviour field to update the behaviour of the pets
     * 
     */
    public void update()
    {
        // CALL behaviour update:
        _behaviour.update();
    }
}
