package UserCode.Misc;

import java.util.Random;

/**
 * Enumeration class RandomNumber defines a singleton Random Number generator containing one method. This
 * enum implements the IRandomNumber interface to define it's single method generateNumber()
 * 
 * @author Chris Williams
 * @version 3.0
 */
public enum RandomNumber implements IRandomNumber
{
    // DECLARE and Initialise an INSTANCE field of RandomNumber:
    INSTANCE;
    
    /**
     * 
     * METHOD: Generate a random double between the values passed as params.
     *
     * @param   min     minimum value of the random number required, of type double
     * @param   max     maximum value of the random number required, of type double
     * 
     * @return  returns a random double between the numbers passed
     * 
     */
    public double generateNumber(double min, double max)
    {
        // CREATE instance of the random class, call it '_random':
        Random _random = new Random();

        // CREATE a random double between the minimum and maximum values passed:

        // DECLARE a double to hold the random number generated, call it '_randNum' set to default value:
        double _randNum = 0.0;

        // CREATE a for loop to generate a unique number and assign it to _randNum:
        // Double will be between max & min:
        for(int i = 0; i < 50; i++)
        { 
            _randNum = (_random.nextDouble() * (max - min)) + min; 
        }

        // RETURN the number to the caller:
        return _randNum;

    }
}
