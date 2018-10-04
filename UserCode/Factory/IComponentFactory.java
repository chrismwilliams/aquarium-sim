package UserCode.Factory;

import java.util.List;

/**
 * IComponentFactory defines the behaviour a concrete class that creates IComponent's should implement.
 *
 * @author Chris Williams
 * @version 3.0
 */
public interface IComponentFactory
{
    /**
     * 
     * METHOD: used to return a List of IComponents based on the String array param
     * 
     * @param   _c   an array of Strings of all the IComponents required
     * 
     * @return   List   all the IComponents created
     * 
     */
    List getComponent(String[] _c);
}
