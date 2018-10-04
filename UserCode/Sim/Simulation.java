package UserCode.Sim;

///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////
import env3d.Env;
import Framework.Core;

import UserCode.Manager.IManager;
import UserCode.Manager.Manager;

/**
 * Simulation is the top-level class for the Aquarium simulation. This class updates the IManager class per frame whilst
 * listening to the escape key which ends the simulation.
 * 
 * @author Chris Williams & Marc Price
 * @version 3.0
 */
public class Simulation implements ISim
{
    // DECLARE a reference to the instance of the Core class, call it '_core':
    private Core _core;

    // DECLARE a reference to the instance of the 'Env' (environment) class, call it '_world':
    private Env _world;

    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;

    // DECLARE a Manager field that will be called for each frame, call it '_manager':
    private IManager _manager;
    
    /**
     * Constructor for objects of class Simulation which initialises the aquarium simulation
     * 
     * @param   core   the initialised Core class
     * @param   world   the initialised Env class
     * 
     */
    public Simulation(Core core, Env world)
    {
        // INITIALISE the _core field with the Core ref passed:
        _core = core;
        
        // INITIALISE the _world field with the world Env ref passed:
        _world = world;
        
        // INITIALISE a new Manager class passing this instance to this and the Env reference:
        _manager = new Manager(_world);
       
    }
                
    /**
     * METHOD: Run the simulation loop.  User presses escape to exit. This should only be accessed once the _world, _core &
     * _manager fields are initialised
     *
     */
    public void run()
    {
        // Start simulation loop:
        while (!endSim)
        {
            // UPDATE STAGE:
            // IF: user has requested simulation loop exit (ie escape pressed):
            if (_world.getKey() == 1)
            {
                // SET: render loop exit condition
                endSim = true;
            }

            // CALL the manager update() method:
            _manager.update();
            
            // RENDER STAGE
            // UPDATE: the environment
            _core.updateWorld();
        }

        // EXIT: cleanly by closing-down the environment:
        _core.destroyWorld();

    }

}
