package UserCode.Pets;

import UserCode.Behaviours.IBehaviour;

/**
 * IEntity Interface: defines the behaviour of the Entity class that contains both the token and the behaviour within
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public interface IEntity
{
    /**
     * 
     * METHOD: used to get the instance of the token held in the entity class
     * 
     * @return  IToken   the instance of the IToken the entity contains
     * 
     */
    IToken getToken();

    /**
     * 
     * METHOD: used to get the instance of the behaviour held in the entity class
     * 
     * @return  IBehaviour   the instance of the IBehaviour the entity contains
     * 
     */
    IBehaviour getBehaviour();

    /**
     * 
     * METHOD: used to update the behaviour update method
     * 
     */
    void update();
}
