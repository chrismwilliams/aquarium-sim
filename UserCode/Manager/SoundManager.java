package UserCode.Manager;


import UserCode.Misc.ArgumentPathDoesNotExist;
import env3d.Env;
import java.io.File;

/**
 * SoundManager class used to play audio within the simulation
 * 
 * @author Chris Williams
 * @version 1.5
 */
public class SoundManager implements ISoundManager
{
    // DECLARE a Env variable to store the world reference needed to play sounds, call it '_world':
    Env _world;

    /**
     * DEFAULT Constructor for objects of class SoundManager used only for testing purposes
     * 
     */
    public SoundManager()
    {
       // Used for testing only 
    }
    
    /**
     * Constructor for objects of class SoundManager
     * 
     * @param   _w   the world reference required to play sounds in the simulation
     * 
     */
    public SoundManager(Env _w)
    {
        // INITIALISE the _world variable with the world reference passed:
        _world = _w;
    }

    /**
     * METHOD: used to play the sound passed. Throws an ArgumentPathDoesNotExist is the filepath to the audio cannot be found
     * 
     * @param  _audio   the url string of the audio's location
     */
    public void playSound(String _audio) throws ArgumentPathDoesNotExist
    {
        // CHECK if the file path exists:
        if(!new File(_audio).exists())
        {
            throw new ArgumentPathDoesNotExist("The audio path cannot be found: " + _audio);
        }
        else
        {
            // CALL the method soundPlay from the _world reference initialised in construction:
            _world.soundPlay(_audio);
        }
    }
}
