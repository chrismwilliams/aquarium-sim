package UserCode.Manager;

import UserCode.Pets.IToken;

import env3d.Env;

/**
 * WorldManager defines the class which manages the world by added and removing objects from the simulation. This class
 * contains two methods that add and remove an IToken from the aquarium
 *
 * @author Chris Williams
 * @version 3.0
 */
public class WorldManager implements IWorldManager
{
    // DECLARE an instance of the Env class, call it '_world':
    Env _world;

    /**
     * Constructor for objects of class WorldManager
     */
    public WorldManager(Env world)
    {
        // INITIALISE the _world field with the param passed:
        _world = world;
    }

    /**
     * 
     * METHOD: Add an IToken to the _world which will be displayed on screen
     * 
     * @param   token - IToken to be added to the _world
     * 
     */
    public void addToken(IToken t)
    {
        // ADD the token to the world
        //System.out.println("I got a token" + t);
        //System.out.println(t.rtnTexture());
        _world.addObject(t);
        
       
    }
    
    /**
     * 
     * METHOD: Used to remove the IToken from the world
     * 
     * @param   t   the IToken to be removed from the aquarium
     * 
     */
    public void removeToken(IToken t)
    {
        // System.out.println("Removeing token");
        _world.removeObject(t);
    }
    
}
