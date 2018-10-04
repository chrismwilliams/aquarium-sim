package UserCode.Misc;

/**
 * Enumeration class Screen - Sets the constant values of the screen x and y boundaries
 * 
 * @author Chris Williams
 * @version 3.0
 */
public enum Screen
{
    // SET the minimum and maximum values for the x and y axis:
    MIN_X(1.0), MAX_X(9.0), MIN_Y(1.0), MAX_Y(6.8);
    
    // DECLARE a double to hold the value of the screen size, call it '_value':
    private double _value;
    
    /**
     * 
     * Constructor for Enum class Screen
     * 
     * @param   v   the value to be set
     * 
     */
    Screen(double v)
    {
        // SET value equal to v:
        _value = v;
    }
    
    /**
     * 
     * METHOD: Return the value to caller
     * 
     * @return  returns the double held in the _value field set to the constants set in the fields
     * 
     */
    public double getValue()
    {
        // RETURN the value to caller:
        return _value;
    }
}
