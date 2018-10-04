package UserCode.Sim;

import env3d.Env;
import Framework.Core;

/**
 * WorldInit defines the class that instantiates the Env3D world and starts the simulation through the static main method
 *
 * @author Chris Williams & Marc Price
 * @version 3.0
 */
public class WorldInit implements IWorldInit
{
    // DECLARE a reference to the instance of the Core class, call it '_core':
    private Core _core;

    // DECLARE a reference to the instance of the 'Env' (environment) class, call it '_world':
    private Env _world;

    // DECLARE a reference to the simulation class, call it '_sim':
    private ISim _sim;

    /**
     * Static Main method to create the Core and World
     *
     * @param   args the command-line arguments
     */
    public static void main(String[] args)
    {
        // DECLARE and initialise a instance of the WorldInit class, call it _worldInit:
        WorldInit _worldInit = new WorldInit();

        // CALL the start sim method:
        _worldInit.startSim();
    }

    /**
     * Constructor for objects of class WorldInit
     */
    public WorldInit()
    {
        // INITIALISE the _core field by creating a new Core class:
        _core = new Core();

        // INITIALISE the _world field by calling the createWorld method on _core:
        _world = _core.createWorld();

    }

    /**
     * 
     * METHOD: used to create the Simulation class and pass through the _core and _world fields. This method then calls the
     * run method of the Simulation class
     * 
     */
    public void startSim()
    {
        // CHECK if both the _core and _world fields have been initialised:
        if(!(_core == null || _world == null))
        {
            // INITIALISE the _sim field and pass the _core and _world references
            _sim = new Simulation(_core, _world);

            // CALL the run method of the simulation:
            _sim.run();
        }

    }
}
