package UserCode.Factory;

import UserCode.Components.MoveHorizontal;
import UserCode.Components.MoveVertically;
import UserCode.Components.Prey;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ComponentFactoryTest for testing the ComponentFactory production class.
 *
 * @author  Chris Williams
 * @version 3.0
 * 
 * Test Conditions:
 * 
 * 1) Construction (default): all fields are initialised as expected apart from the _manager field, done via the object bench
 * 2) getComponent(): test the method returns an instance of an IComponent with the List returned
 * 3) getComponent(): test the method returns instances of IComponents in the List returned
 * 
 */
public class ComponentFactoryTest
{
    /**
     * Default constructor for test class ComponentFactoryTest
     */
    public ComponentFactoryTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * 
     * getComponent(): test the method returns an instance of an IComponent requested
     * 
     */
    @Test
    public void testCondition2()
    {
        // DECLARE and initialise an instance of the ComponentFactory, call it '_componentFactory':
        IComponentFactory _componentFactory = new ComponentFactory();
        
        // DECLARE and initialise a double of type String to sent to the getComponent method:
        String[] _requiredComp = {"movehorizontal"};
        
        // CALL the _componentFactory getComponent() method and assign it to a new list, call it '_compList':
        List _compList = _componentFactory.getComponent(_requiredComp);
        
        // CHECK the List is not empty:
        assertTrue(_compList.size() > 0);
        
        // CHECK the IComponent within _compList is a MoveHorizontal class:
        assertTrue(_compList.get(0) instanceof MoveHorizontal);
    }
    
    /**
     * 
     * getComponent(): test the method returns instances of IComponents requested
     * 
     */
    @Test
    public void testCondition3()
    {
        // DECLARE and initialise an instance of the ComponentFactory, call it '_componentFactory':
        IComponentFactory _componentFactory = new ComponentFactory();
        
        // DECLARE and initialise a double of type String to sent to the getComponent method:
        String[] _requiredComp = {"movevertically", "prey"};
        
        // CALL the _componentFactory getComponent() method and assign it to a new list, call it '_compList':
        List _compList = _componentFactory.getComponent(_requiredComp);
        
        // CHECK the IComponent within _compList[0] is an instance of the MoveVertically class:
        assertTrue(_compList.get(0) instanceof MoveVertically);
        
        // CHECK the IComponent _compList[1] is an instance of the Prey class:
        assertTrue(_compList.get(1) instanceof Prey);
    }
}
