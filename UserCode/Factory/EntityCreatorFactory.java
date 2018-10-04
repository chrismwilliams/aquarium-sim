package UserCode.Factory;

import UserCode.Pets.*;
import UserCode.Behaviours.IBehaviour;
import UserCode.Behaviours.IObserver;
import UserCode.Components.IComponent;
import UserCode.Misc.Screen;

import java.util.List;

/**
 * EntityCreatorFactory: A factory to create the different types of pets that can be used within the aquarium. This class
 * also creates the ComponentFactory and TokenFactory in order to create a concrete implementation of an IEntity
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class EntityCreatorFactory implements IEntityCreatorFactory
{
    // DECLARE an instance of the ComponentFactory which will create all the required components, call it _'componentFactory':
    private IComponentFactory _componentFactory;

    // DECLARE an instance of the ITokenFactory which will create all the Token with the correct images, call it '_tokenFactory':
    private ITokenFactory _tokenFactory;

    /**
     * @Deprecated
     * Constructor for objects of class EntityCreatorFactory, used only for testing
     * 
     * 
     */
    public EntityCreatorFactory()
    {     
        //USED only for testing:
        
        // INITIALISE the _componentFactory field for testing:
        _componentFactory = new ComponentFactory();

        // INTIALISE the _tokenFactory field by creating a new TokenFactory class:
        _tokenFactory = new TokenFactory();
    }
    
    
    /**
     * Constructor for objects of class EntityCreatorFactory
     * 
     * @param   bubbleRequestObserver   the IObserver class required to be used by the IComponentFactory when creating RequestBubble classes
     * 
     */
    public EntityCreatorFactory(IObserver bubbleRequestObserver)
    {     
        // INITIALISE the _componentFactory field by creating a new class:
        _componentFactory = new ComponentFactory(bubbleRequestObserver);

        // INTIALISE the _tokenFactory field by creating a new TokenFactory class:
        _tokenFactory = new TokenFactory();
    }

    /**
     * METHOD: getEntity - returns an IEntity consisting on an IBehaviour and IToken to the caller based on the String passed
     * 
     * @param   entityType   name of the entity to be returned
     * @param   ...coords   used to create and position a bubble or FishFood with the x and y coords passed
     * 
     * @return     return the Entity based on the parameters passed 
     * 
     */
    public IEntity getEntity(String entityType, double ...coords)
    {
        // CHECK the param entityType using IF statements for the different 'pets' known:

        // CHECK if the param is NULL or empty and return NULL to the caller if true:
        if(entityType == null && entityType.isEmpty())
        {
            // System.out.println("oops, type cannot be null");
            // RETURN null as the entityType is null or empty:
            return null;
        }

        // INITIALISE an instance of a Token by calling the TokenFactory getToken and pass the entityType param:
        IToken _token = getToken(entityType);
        
        // CHECK the _token is not null:
        if(_token == null)
        {
            // RETURN
            return null;
        }

        // CHECK if the entityType param is 'JavaFish':
        if(entityType.equalsIgnoreCase("JavaFish"))
        {
            // INTIALISE an instance of a JavaFish with the _token created and pass the _manager reference:
            IBehaviour _javaFish = new JavaFish(_token);

            // INITIALISE a String of doubles of the IComponents required by a JavaFish:
            String[] _requiredComp = {"movehorizontal", "requestbubble", "prey", "feed"};
            
            // INITIALISE and assign a list of components by calling the _componentFactory with the param _requiredComp:
            List<IComponent> _c = _componentFactory.getComponent(_requiredComp);;
            
            // ADD components for JavaFish:
            _javaFish.Initialise(_c);

            // RETURN an entity instance by calling the method createEntity with the token and pet created:
            return createEntity(_token,_javaFish);

        }

        // CHECK if the entityType param is 'JavaUrchin':
        else if(entityType.equalsIgnoreCase("JavaUrchin"))
        {
            // INITALISE an instance of a JavaUrchin with the _token created:
            IBehaviour _javaUrchin = new JavaUrchin(_token);
            
            // INITIALISE a String of doubles of the IComponents required by a JavaUrchin:
            String[] _requiredComp = {"movehorizontal", "feed"};
            
            // INITIALISE and assign a list of components by calling the _componentFactory with the param _requiredComp:
            List<IComponent> _c = _componentFactory.getComponent(_requiredComp);;

            // ADD components for JavaUrchin:
            _javaUrchin.Initialise(_c);

            // RETURN an entity instance by calling the method createEntity with the token and pet created:
            return createEntity(_token,_javaUrchin);

        }

        // CHECK if the entityType param is 'JavaSeaHorse':
        else if(entityType.equalsIgnoreCase("JavaSeaHorse"))
        {
            // INITIALISE an instance of a JavaSeaHorse with the _token created:
            IBehaviour _javaSeaHorse = new JavaSeaHorse(_token);
            
            // INITIALISE a String of doubles of the IComponents required by a JavaSeaHorse:
            String[] _requiredComp = {"movediag", "prey", "feed"};
            
            // INITIALISE and assign a list of components by calling the _componentFactory with the param _requiredComp:
            List<IComponent> _c = _componentFactory.getComponent(_requiredComp);

            // ADD components for JavaSeaHorse:
            _javaSeaHorse.Initialise(_c);

            // RETURN an entity instance by calling the method createEntity with the token and pet created:
            return createEntity(_token,_javaSeaHorse);

        }

        // CHECK if the entityType param is 'Bubble':
        else if(entityType.equalsIgnoreCase("Bubble"))
        {
            // CHECK the coords:
            if(coords.length < 2)
            {
                // RETURN null as a bubble requires and x and y position: 
                return null;
            }
            
            // INITIALISE an instance of Bubble with the _token created, the coordinates passed
            IBehaviour _bubble = new Bubble(_token, coords[0], coords[1]);

            // INITIALISE a String of doubles of the IComponents required by a Bubble:
            String[] _requiredComp = {"movevertically"};
            
            // INITIALISE and assign a list of components by calling the _componentFactory with the param _requiredComp:
            List<IComponent> _c = _componentFactory.getComponent(_requiredComp);
                        
            // ADD components for Bubble:
            _bubble.Initialise(_c);

            // RETURN an entity instance by calling the method createEntity with the token and pet created:
            return createEntity(_token, _bubble);

        }

        // CHECK if the entityType param is 'FishFood':
        else if (entityType.equalsIgnoreCase("FishFood"))
        {
            // CHECK the coords:
            if(coords.length < 2)
            {
                // RETURN null as a FishFood requires and x and y position: 
                return null;
            }
            
            // INITIALISE an instance of FishFood with the _token created, the coords passed:
            IBehaviour _fishFood = new FishFood(_token, coords[0], coords[1]);

            // INITIALISE a String of doubles of the IComponents required by a FishFood pet:
            String[] _requiredComp = {"foodfall"};
            
            // INITIALISE and assign a list of components by calling the _componentFactory with the param _requiredComp:
            List<IComponent> _c = _componentFactory.getComponent(_requiredComp);
            
            // CALL the movevertically IComponent componentAction method to change it's velocity:
            _c.get(0).componentAction();
            
            // ADD components for FishFood:
            _fishFood.Initialise(_c);

            // RETURN an entity instance from createEntity() passing the _token and _fishFood created:
            return createEntity(_token, _fishFood);
        }

        // CHECK if the entityType param is 'JavaBubbler':
        else if(entityType.equalsIgnoreCase("JavaBubbler"))
        {
            // INITIALISE an insance of a JavaBubbler with the _token created:
            IBehaviour _javaBubbler = new JavaBubbler(_token);

            // INITIALISE a String of doubles of the IComponents required by a JavaBubbler:
            String[] _requiredComp = {"requestbubble"};
            
            // INITIALISE and assign a list of components by calling the _componentFactory with the param _requiredComp:
            List<IComponent> _c = _componentFactory.getComponent(_requiredComp);
            
            // ADD components for JavaBubbler:
            _javaBubbler.Initialise(_c);

            // RETURN an entity instance by calling the method createEntity with the token and fish created:
            return createEntity(_token, _javaBubbler);
        }

        // CHECK if the entityType param is 'Piranha':
        else if (entityType.equalsIgnoreCase("Piranha"))
        {
            // INITIALISE an instance of a Piranha with the _token created:
            IBehaviour _piranha = new Piranha(_token);

            // INITIALISE a String of doubles of the IComponents required by a JavaBubbler:
            String[] _requiredComp = {"movehorizontal", "preditor", "feed"};
            
            // INITIALISE and assign a list of components by calling the _componentFactory with the param _requiredComp:
            List<IComponent> _c = _componentFactory.getComponent(_requiredComp);
            
            // ADD components for Piranha:
            _piranha.Initialise(_c);

            // RETURN an entity instance by calling createEntity() with the _token and _piranha created:
            return createEntity(_token,_piranha);
        }


        // RETURN NULL if no matches have been found:
        return null;
    }

    /**
     * 
     * METHOD: create a new Entity with the newly created token and behaviour's passed and return it to the caller
     * 
     * @param   IToken token - the token of the pet with the texture already set
     * @param   IBehaviour behaviour - the behaviour of the pet
     * 
     * @return  Entity   returns the created entity with the token and behaviour sent within
     * 
     */
    private IEntity createEntity(IToken token, IBehaviour behaviour)
    {
        // CREATE a new Entity with the token and behaviour params in a variable, call it _entity:
        IEntity _entity = new Entity(token,behaviour);

        // RETURN the new _entity to the caller:
        return _entity;
    }

    /**
     * 
     * METHOD: used to call the _tokenFactory and request an IToken based on the param passed
     * 
     * @param   _name   the name of the pet required, can also be the name of the texture: "PiranhaGreen"
     * 
     */
    private IToken getToken(String _name)
    {
        // CALL the _tokenFactory with the _name param and return the result to the caller:
        return _tokenFactory.getToken(_name);
    }
}
