package UserCode.Misc;

/**
 * IRandomNumber interface defines a method a concrete implemention of RandomNumber should include and how it should be accessed
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public interface IRandomNumber
{
    /**
     * 
     * METHOD: Generate a random double between the minimum and maximum values provided as arguments which will be returned as a double.
     *
     * @param   min     minimum value of the random number required, of type double
     * @param   max     maximum value of the random number required, of type double
     * 
     * @return  returns a double between the numbers passed
     * 
     */
    double generateNumber(double min, double max);

}
