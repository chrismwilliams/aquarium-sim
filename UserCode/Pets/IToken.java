package UserCode.Pets;

import UserCode.Misc.ArgumentOutOfBoundsException;

/**
 * Interface IToken: defines all the methods needed to display and update the properties of the token in the aquarium
 * 
 * @author Chris Williams
 * @version 1.5
 */
public interface IToken
{
    /**
     * 
     * METHOD: used to return the value of the texture field
     * 
     * @return  String   the value of the texture field
     * 
     */
    String rtnTexture();
    
    /**
     * 
     * METHOD: used to set the scale of the pet. The scale must be between 0.0 & 1.0 otherwise an Exception is thrown
     * 
     * @param   scale   the value of the scale the pet should be
     * 
     */
    void setScale(double s) throws ArgumentOutOfBoundsException;
    
    /**
     * GETTER
     * Method: getter to return the scale field
     * 
     * @return  double   the value of the scale field
     * 
     */
    double rtnScale();
    
    /**
     * GETTER
     * Method: getter to return the model field
     * 
     * @return  String   the value of the model path 
     * 
     */
    String rtnModel();

    /**
     * 
     * METHOD: used to set the orientation of the pet within the world
     * 
     * @param   _rotX   the x orientation of the pet 
     * @param   _rotY   the y orientation of the pet
     * @param   _rotZ   the z orientation of the pet
     * 
     */
    void setOrientation(double _rotX, double _rotY, double _rotZ);

    /**
     * 
     * METHOD: used to return an array of the vaules of the orientation x y and z fields
     * 
     * @return  an array of the orientation values
     * 
     */
    double[] getOrientation();

    /**
     * 
     * SETTER
     * METHOD: used to set the position of the token
     * 
     * @param   _posX   the x position
     * @param   _posY   the y position
     * @param   _posZ   the z position
     * 
     */
    public void setPosition(double _posX, double _posY, double _posZ);
    
    /**
     * 
     * GETTER
     * Method: used to return a the positional fields x,y and z 
     * 
     * @return  array of the current x and y and z coords
     * 
     */
    double[] getPosition();
}
