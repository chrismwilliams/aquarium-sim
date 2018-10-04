package UserCode.Manager;

import UserCode.Misc.ArgumentPathDoesNotExist;

/**
 * ISoundManager defines the behaviour a concrete implementation should place an audio file for an Env world
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public interface ISoundManager
{
    /**
     * METHOD: used to play the sound passed. Throws an ArgumentPathDoesNotExist is the filepath to the audio cannot be found
     * 
     * @param  _audio   the url string of the audio's location
     */
    void playSound(String _audio) throws ArgumentPathDoesNotExist;
}
