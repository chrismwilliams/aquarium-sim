package UserCode.Factory;

import UserCode.Components.*;
import UserCode.Behaviours.IObserver;
import UserCode.Behaviours.IObservable;
import UserCode.Misc.Screen;

import java.util.List;
import java.util.ArrayList;

/**
 * ComponentFactory defines the behaviour of the concrete implementation of the IComponentFactory interface. This factory
 * creates and returns IComponents based on the String value passed to the method getComponent.
 *
 * @author Chris Williams
 * @version 3.0
 */
public class ComponentFactory implements IComponentFactory
{
    // DECLARE an instance of the IObserver class that so that it can watch new RequestBubble IComponents, call it '_bubbleObserver 
    private IObserver _bubbleObserver;

    // DECLARE a double to store the aquarium's minimum x value, call it '_screenMinX':
    private double _screenMinX;

    // DECLARE a double to store the aquarium's maximum x value, call it '_screenMaxX':
    private double _screenMaxX;

    // DECLARE a double to store the aquarium's minimum y value, call it '_screenMinY':
    private double _screenMinY;

    // DECLARE a double to store the aquarium's maximum y value, call it '_screenMaxY':
    private double _screenMaxY;

    /**
     * @Deprecated
     * Constructor for objects of class ComponentFactory, used only for testing
     * 
     */
    @Deprecated
    public ComponentFactory()
    {
        // USED for testing only:
        
        // INITIALISE the _screenMinX field with the value returned from calling Screen.MIN_X.getValue():
        _screenMinX = Screen.MIN_X.getValue();

        // INITIALISE the _screenMaxX field with the value returned from calling Screen.MAX_X.getValue()
        _screenMaxX = Screen.MAX_X.getValue();

        // INITIALISE the _screenMinY field by calling Screen.MIN_Y.getValue():
        _screenMinY = Screen.MIN_Y.getValue();

        // INITIALISE the _screenMaxY field by calling Screen.MAX_X.getValue():
        _screenMaxY = Screen.MAX_Y.getValue();
    }
    
    /**
     * Constructor for objects of class ComponentFactory
     * 
     * @param   bubbleRequestObserver   the IObserver class which all IObservable RequestBubble classes will notify when a bubble
     * has been requested
     * 
     */
    public ComponentFactory(IObserver bubbleRequestObserver)
    {
        // INITIALISE the _bubbleObserver field with the param passed:
        _bubbleObserver = bubbleRequestObserver;

        // INITIALISE the _screenMinX field with the value returned from calling Screen.MIN_X.getValue():
        _screenMinX = Screen.MIN_X.getValue();

        // INITIALISE the _screenMaxX field with the value returned from calling Screen.MAX_X.getValue()
        _screenMaxX = Screen.MAX_X.getValue();

        // INITIALISE the _screenMinY field by calling Screen.MIN_Y.getValue():
        _screenMinY = Screen.MIN_Y.getValue();

        // INITIALISE the _screenMaxY field by calling Screen.MAX_X.getValue():
        _screenMaxY = Screen.MAX_Y.getValue();
    }

    /**
     * 
     * METHOD: used to create the IComponents based on the String value passed. All instances of RequestBubble IComponents will
     * be attached to the IObserver _bubbleObserver field
     * 
     * @param   _name   the name of the component required
     * 
     * @return  an instance of IComponent based on the param field
     * 
     */
    private IComponent getComponent(String _name)
    {
        // CHANGE the _name param to lower case to be used by a switch:
        _name = _name.toLowerCase();

        // DECLARE and initialise an IComponent field to be return to the caller, call it _component:
        IComponent _component = null;

        // START a switch statement using the _name param
        switch(_name)
        {
            // CHECK if the _name is for the RotateObj class:
            case "rotateobj" :
            _component = new RotateObj();
            break;

            // CHECK if the _name param is for the RequestBubble class:
            case "requestbubble" :
            _component = new RequestBubble();
            _bubbleObserver.observeObj((IObservable) _component);
            break;

            // CHECK if the _name param is for the Preditor class:
            case "preditor" :
            _component = new Preditor();
            break;

            // CHECK if the _name param is for the Prey class:
            case "prey" :
            _component = new Prey();
            break;

            // CHECK if the _name param is for the MoveHorizontal class:
            case "movehorizontal" :
            _component = new MoveHorizontal(_screenMinX, _screenMaxX);
            break;

            // CHECK if the _name param is for the MoveVertically class:
            case "movevertically" :
            _component = new MoveVertically();
            break;

            // CHECK if the _name param is for the MoveDiag class:
            case "movediag" :
            _component = new MoveDiag(_screenMinX, _screenMaxX, _screenMinY, _screenMaxY);
            break;
            
            // CHECK if the _name param is for the Feed class:
            case "feed" :
            _component = new Feed();
            break;
            
            // CHECK if the _name param is for the FoodFall class:
            case "foodfall" :
            _component = new FoodFall(_screenMinY);
            break;

            // IF no cases are found, set _component to null:
            default:
            _component = null;
        }

        // RETURN the _component field to caller:
        return _component;
    }

    /**
     * 
     * METHOD: used to return a List of all the components required, based on the array of Strings provided
     * 
     * @param   _c   an array of Strings corresponding to the IComponents required
     * 
     * @return  List   an array of all the IComponents requested
     * 
     */
    public List getComponent(String[] _c)
    {
        // CHECK if the array is empty first:
        if(_c.length == 0)
        {
            // RETURN null:
            return null;
        }

        // DECLARE and initialise a new list to return to the caller, call it 'components':
        List<IComponent> _components = new ArrayList<IComponent>();

        // LOOP through the String array _c and add all components to the List _components:
        for (String c : _c)
        {
            // ASSIGN an IComponent field and call the getComponent method with the Strings provided:
            IComponent component = getComponent(c);

            // ADD the returned IComponent to the _component List:
            _components.add(component);
        }

        // RETURN the _components array to the caller:
        return _components;
    }

}
