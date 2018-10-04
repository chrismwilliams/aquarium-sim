package UserCode.Behaviours;

import UserCode.Pets.IToken;
import UserCode.Misc.IRandomNumber;
import UserCode.Misc.RandomNumber;
import UserCode.Misc.ArgumentOutOfBoundsException;
import UserCode.Misc.Screen;
import UserCode.Components.IComponent;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Behaviour: an abstract class that defines the basic behaviour of the pets that will extend it. This contains helper classes
 * to access the token methods to update its properties or general helper methods to generate random starting positions and/or speeds
 * 
 * @author Chris Williams
 * @version 3.0
 */
public abstract class Behaviour implements IBehaviour
{
    // DECLARE a reference to the Token class, call it '_token':
    private IToken _token;

    // DECLARE a variable of type double to store the speed, call it '_speed':
    protected double _speed;

    // DECLARE a reference to the instance of the RandomNumber class, call it '_randomNumeber':
    protected IRandomNumber _randomNumber;

    // DECLARE a HashMap that stores all the components utilised by the extending behaviour, call it '_components';
    protected Map<String,IComponent> _components;

    /**
     * Constructor for objects of class Behaviour
     * 
     * @param   _rtoken   the IToken that the 'pet' shall interact with and update its properties
     * 
     */
    public Behaviour(IToken _rtoken)
    {
        // INITIALISE the reference to the token in _token:
        _token = _rtoken;

        // INITIALISE RandomNumber class and store instance in _randomNumber:
        _randomNumber = RandomNumber.INSTANCE;

        // INITIALISE _speed field to a default value of 0.0:
        _speed = 0.0;

        // INITALISE the _componets field to a new HashMap;
        _components = new HashMap<String,IComponent>();

    }

    /**
     * 
     * METHOD: Generate a random speed between 0.005 - 0.05 which is assigned to the _speed field by calling the RandomNumber method
     * generateNumber in the _randomNumber field
     * 
     */
    public void generateSpeed()
    {
        // INITIALISE a random number for the speed:
        this._speed = _randomNumber.generateNumber(0.005, 0.05);
    }

    /**
     * 
     * Overloaded method
     * METHOD: Generate a random speed based on the string passed, either "slow" or "fast" to the _speed field
     * If string doesn't match, the method calls standard method generateSpeed to assign the _speed field
     * 
     * @param   s   a String, either "fast" or "slow" to generate a number
     */
    public void generateSpeed(String s)
    {
        // IF string is equal to slow:
        if(s == "slow")
        {
            // Assign _speed to a random number with lower values between 0.005 and 0.010 by calling the RandomNumber method
            // generateNumber in the _randomNumber field:
            this._speed = _randomNumber.generateNumber(0.005, 0.010);
        } 
        // ELSE IF string is equal to fast:
        else if(s == "fast")
        {
            // Assign _speed to a random number with a higher value between 0.0225 and 0.05 by calling the RandomNumber method
            // generateNumber in the _randomNumber field:
            this._speed = _randomNumber.generateNumber(0.0225, 0.05);
        }
        // ELSE string not found:
        else
        {
            // CALL other generateSpeed method to assign a basic speed between 0.005 & 0.05 to the _speed field:
            generateSpeed();
        }
    }

    /**
     * GETTER
     * METHOD: Get the value held within the _speed field
     * 
     * @return  double   returns the field _speed to caller
     * 
     */
    public double getSpeed()
    {
        // RETURN _speed field
        return _speed;
    }

    /**
     * SETTER
     * METHOD: Set the scale of the pet within the aquarium. Method changes values held within the _token by calling the Token method setScale
     * This method catches an ArgumentOutOfBoundsException if the value is too great or too small
     * 
     * @param   s   a double representing the scale of the pet
     * 
     */
    public void setScale(double s)
    {
        // TRY to update the _token scale value by calling token setScale method with value passed:
        try
        {
            // CALL the _token's setScale method and pass the value of s:
            _token.setScale(s);
        }
        // IF exception thrown catch it:
        catch(ArgumentOutOfBoundsException e)
        {
            System.out.println("The value of scale is too large");
            
        }

    }

    /**
     * GETTER
     * METHOD: returns the current scale of the pet by calling _token rtnScale()
     * 
     * @return  a value of type double representing the scale
     * 
     */
    public double getScale()
    {
        // RETURN the scale value for calling _token rtnScale() method:
        return _token.rtnScale();
    }

    /**
     * SETTER
     * METHOD: Set a random scale of the pet within the aquarium between 0.1 - 0.15. Method will update the value in the _token
     * 
     */
    public void randomScale()
    {
        // TRY to update the _token scale value by calling token setScale method a random value generated from RandomNumber class:
        try
        {
            // CALL the _token's setScale method by calling the _randomNumber generateNumber method to generate a number between 0.1-0.15:
            _token.setScale(_randomNumber.generateNumber(0.1,0.15));
        }
        // IF exception thrown catch it:
        catch(ArgumentOutOfBoundsException e)
        {
            System.out.println("The random value of the scale is too large");
        }
    }

    /**
     *
     * METHOD: Place the pet at a random Y axis position based on the string passed, either "top" or "bottom", 
     * default places pet in the center  
     *
     * @param   _placement   of type string representing the general position to set the y coord ("top", "bottom")
     *
     */
    public void setStartPosition(String _placement)
    {
        // INITIALISE and set a random number from _randomNumber for the x, call it _startX:
        double _startX = _randomNumber.generateNumber(Screen.MIN_X.getValue(),Screen.MAX_X.getValue());

        // INITIALISE a field to hold the Y value that will be generated next, call it _startY:
        double _startY;

        // INITIALISE a random number based on the _placement param using a switch and passing the _placement param:
        switch(_placement)
        {
            // CHECK if the value in _placement is "top":
            case "top":

            // ASSIGN a random number to the _startY field that is near the top of the aquarium:
            _startY = _randomNumber.generateNumber(2.0, 6.8);

            // ESCAPE switch:
            break;

            // CHECK if the value in _placement is "bottom":
            case "bottom":

            // ASSIGN a random number to the _startY field that is near the bottom of the aquarium:
            _startY = _randomNumber.generateNumber(1.0,1.5);

            // ESCAPE switch:
            break;

            // SET a default value if cases don't match:
            default:

            // ASSIGN a default value that is based in the middle of the screen:
            _startY = _randomNumber.generateNumber(3.0,4.0);

        }

        //System.out.println("My start x in Behaviour: " + _startX);
        //System.out.println("My start y in Behaviour: " + _startY);

        // CALL setPosition method to update the values in the IToken:
        setPosition(_startX,_startY);       

    }

    /**
     * SETTER
     * METHOD: Set a new Orientation of the pet on the x and y axis. This method passes the values in the params to the Token
     * by calling the setOrientation method of the Token class. It will set a default value of 0.0 for the Z orientation.
     * 
     * @param   _oriX   a double for the x Orientation
     * @param   _oriY   a double for the y Orientation
     * 
     * 
     */
    public void setOrientation(double _oriX, double _oriY)
    {
        // UPDATE the orientation of the IToken by calling the method setOrientation of the _token with the default value for Z:
        _token.setOrientation(_oriX,_oriY,0.0);

    }

    /**
     * SETTER
     * METHOD: Set a new Orientation of the pet on the x y and z axis. This method passes the values in the params to the Token
     * by calling the setOrientation method of the Token class
     * 
     * @param   _oriX   a double for the x Orientation
     * @param   _oriY   a double for the y Orientation
     * @param   _oriZ   a double for the z Orientation
     * 
     */
    public void setOrientation(double _oriX, double _oriY, double _oriZ)
    {
        // SET the orientation of the model by calling the method setOrientation of the _token:
        _token.setOrientation(_oriX,_oriY,_oriZ);

    }

    /**
     * GETTER
     * METHOD: GETTER to retrieve the orientation of the pet
     * 
     * @return  double[]   returns the value of the orientations in IToken as an array of 3 doubles
     * 
     */
    public double[] getOrientation()
    {
        // RETURN the values from the IToken:
        return _token.getOrientation();
    }

    /**
     * SETTER
     * METHOD: set the position of the pet on the x and y axis, method updates the IToken with the new values. It will set the Z
     * position to the default value of 1.0
     * 
     * @param   newX   the x position of the pet
     * @param   newY   the y position of the pet
     * 
     */
    public void setPosition(double newX, double newY)
    {
        // System.out.println("My new _x in Behaviour: " + newX);
        // System.out.println("My new _y in Behaviour: " + newY); 

        // UPDATE the IToken's positional values, the z position is set to the default value of '1.0':
        _token.setPosition(newX, newY, 1.0);

    }

    /**
     * OVERLOADED SETTER
     * METHOD: set the position of the pet on the x and y and z axis, method updates the IToken with the new values.
     * 
     * @param   newX   the x position of type double
     * @param   newY   the y position of type double
     * @param   newZ   the z position of type double
     * 
     */
    public void setPosition(double newX, double newY, double newZ)
    {
        // System.out.println("My new _x in Behaviour: " + newX);
        // System.out.println("My new _y in Behaviour: " + newY);
        // System.out.println("My new _y in Behaviour: " + newZ);

        // UPDATE the IToken's positional values:
        _token.setPosition(newX, newY, newZ);

    }

    /**
     * GETTER
     * METHOD: returns x y and z fields held in IToken
     * 
     * @return  an array of doubles {x,y,z}
     * 
     */
    public double[] getPosition()
    {
        // RETURN an array of doubles of the x,y and z to the caller:
        return _token.getPosition();
    }

    /**
     * 
     * METHOD: used to add new IComponents to the _components HashMap. This method checks if it already exists before adding it to 
     * the _components HashMap.
     * 
     * @param   _component   the new component to add
     * 
     */
    public void addComponent(IComponent _component)
    {
        if(_components.containsKey(_component.getName()))
        {
            // RETURN as it already exists:  
            return;
        }

        // ADD the argument into the _components HashMap:
        _components.put(_component.getName(), _component);
    }

    /**
     * GETTER
     * METHOD: used to return the HashMap _components containing all the key,value pairs
     * 
     * @return  Map   the HashMap of the _components field
     * 
     */
    @Deprecated
    public Map getComponents()
    {
        // RETURN the _components field to caller:
        return _components;
    }

    /**
     * 
     * METHOD: used to get retrieve an IComponent within _components field. This method will return
     * the HashMap value which is the IComponent
     * 
     * @param   _name   the 'key' String name of the component
     * 
     * @return  IComponent   the IComponent requested, if it doesn't exist null will be returned
     * 
     */
    public IComponent getIComponent(String _name)
    {
        // RETURN the IComponent to the caller, using the _name param as the get value:
        return _components.get(_name);
    }

    /**
     *
     * ABSTRACT
     * METHOD: Used to set-up any properties and components the class requires
     * 
     * @param   an arrayList of IComponents the Behaviour concrete class requires in the simulation
     *
     */
    public abstract void Initialise(List<IComponent> _components);

    /**
     *
     * METHOD: Used to tear-down any active threads or computations that are no longer needed. This method loops through all the _components
     * HashMap and calls the Terminate(); method for each IComponent
     *
     */
    public void Terminate()
    {
        // LOOP through all the IComponents in the HashMap _components
        for (Map.Entry<String, IComponent> _entry : _components.entrySet()) 
        {
            // GET the value:
            IComponent _component = (IComponent) _entry.getValue();

            // CALL the TearDown method for each IComponent:
            _component.TearDown();

        }
    }

    /**
     * ABSTRACT
     * METHOD: Used by each pet to run through any IComponents they have and any additional requirements they have.
     *  
     */
    public abstract void update();
}
