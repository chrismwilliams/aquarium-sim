package UserCode.Pets;

import java.io.File;
import UserCode.Misc.ArgumentPathDoesNotExist;
import UserCode.Misc.ArgumentOutOfBoundsException;

/**
 * Token: class provides all the properties and method that are used to display the a token in the aquarium 
 * 
 * @author Chris Williams & Marc Price
 * @version 3.0
 */

public class Token implements IToken
{
    // DECLARE a variable for the 3D model of type String, call it 'model' set to default location:
    private String model = "models/billboard/billboard.obj";

    // DECLARE a variable for the path to the texture, call it 'texture':
    private String texture;

    // DECLARE a variable for the scale of the model of type double, call it 'scale', set to default 0.15:
    private double scale = 0.15;

    // DECLARE a variable for the transparency of the object, call it 'transparent', set to true:
    private boolean transparent = true;

    // DECLARE a variable for the x,y,z coordinates of the toekn with a default of 0,0,1, call them 'x', 'y' & 'z':
    private double x = 0.0, y = 0.0, z = 1.0;

    // DECLARE a variable for the Orientation of the token for x,y & z with a default of 0,-90,0:
    // call it 'rotateX', 'rotateY' & 'rotateZ':
    private double rotateX = 0.0, rotateY = -90.0, rotateZ = 0.0;

    /**
     * 
     * DEFAULT Constructor for objects of class Token, only used for testing
     * 
     */
    public Token()
    {
        // USED for tesing

    }

    /**
     * Constructor for objects of class Token which expects a texture string defining the path to find it, if not throws an ArgumentPathDoesNotExist exception
     * 
     * @param   tex  the string value of the texture path to use for the token 
     * 
     */
    public Token(String tex) throws ArgumentPathDoesNotExist
    {
        // CHECK if the file path exists:
        if(!new File(tex).exists())
        {
            // IF NOT throw an ArgumentPathDoesNotExist:
            throw new ArgumentPathDoesNotExist("The texture path cannot be found: " + tex );
        }
        else
        {
            // SET field texture to parameter tex:
            texture = tex;
        }

    }

    /**
     * 
     * Overloaded constructor
     * Constructor for objects of class Token which expects a texture string defining the path and a string path of the model. If the filename does not exist
     * then a ArgumentPathDoesNotExist exception is thrown
     * 
     * @param   tex   the string value of the texture path to use
     * @param   mod   the string value of the model path to use
     * 
     */
    public Token(String tex, String mod) throws ArgumentPathDoesNotExist
    {
        // CHECK is the file exists:
        if(!new File(tex).exists())
        {
            // IF NOT throw an ArgumentPathDoesNotExist
            throw new ArgumentPathDoesNotExist("The texture path cannot be found: " + tex );
        }
        else
        {

            // SET field texture to parameter tex:
            texture = tex; 

            // SET field model to parameter mod:
            model = mod;
        }
    }

    /**
     * GETTER
     * @deprecated  Method: getter to return the texture field
     *  
     * @return  texture   the string value of the path to the texture 
     *  
     */
    @Deprecated
    public String rtnTexture() {
        // RETURN the value of texture to the caller:
        return texture;
    }

    /**
     * SETTER
     * METHOD: used to set the scale of the token within the aquarium. The scale must be between 0.0 & 0.4 otherwise an Exception is thrown
     * 
     * @param   s   the value of the scale the pet should be as a double
     * 
     */
    public void setScale(double s) throws ArgumentOutOfBoundsException
    {
        // CHECK if the scale is between the allowed values 0.0 and 0.4:
        if((s > 0.0) && (s <= 0.4))
        {
            // IF it is:
            // SET field scale to the value passed:
            scale = s;
        }
        else
        {
            // SCALE is out of bounds, throw a new ArgumentOutOfBoundsException:
            throw new ArgumentOutOfBoundsException("The scale must be within the ranges: 0.0 & 0.4");
        }

    }

    /**
     * GETTER
     * METHOD: getter to return the scale field
     * 
     * @return  double   the value of the scale field
     * 
     */
    public double rtnScale() {
        // RETURN the value of scale to the caller:
        return scale;
    }

    /**
     * GETTER
     * @Deprecated Method: getter to return the model field
     * 
     * @return  String   the value of the model path 
     * 
     */
    @Deprecated
    public String rtnModel() {
        // RETURN the value of the model path:
        return model;
    }

    /**
     * 
     * GETTER
     * Method: used to return the orientation values held of the token of x, y and z
     * 
     * @return  array of the values of the orientation x, y and z
     * 
     */
    public double[] getOrientation()
    {
        // CREATE an array with the values of orientation fields, rotateX rotateY rotateZ:
        double[] _orientation = {rotateX, rotateY, rotateZ};

        // RETURN _orientation array
        return _orientation; 
    }

    /**
     * SETTER
     * METHOD: used to set the orientation of the token within the world
     * 
     * @param   _rotX   the x orientation of the token 
     * @param   _rotY   the y orientation of the token
     * @param   _rotZ   the z orientation of the token
     * 
     */
    public void setOrientation(double _rotX, double _rotY, double _rotZ)
    {
        // ASSIGN the value _rotX to rotateX:
        rotateX = _rotX;

        // ASSIGN the value _rotY to rotateY:
        rotateY = _rotY;

        // ASSIGN the value _rotZ to rotateZ:
        rotateZ = _rotZ;
    }

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
    public void setPosition(double _posX, double _posY, double _posZ)
    {
        // ASSIGN the fields x y and z to the arguments passed:
        x = _posX;

        y = _posY;

        z = _posZ;
    }

    /**
     * 
     * GETTER
     * Method: used to return a the positional fields x,y and z
     * 
     * @return  array of the current x and y and z coords
     * 
     */
    public double[] getPosition()
    {
        // INITIALISE an array of doubles to the x y and z fields:
        double[] _position = {x,y,z};

        // RETURN _position:
        return _position;
    }

}
