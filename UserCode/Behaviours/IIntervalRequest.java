package UserCode.Behaviours;

import java.util.concurrent.*;

/**
 * IIntervalRequest defines how a concrete implemention should behave in order to start and stop a request at set/random intervals.
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public interface IIntervalRequest
{
    /**
     * 
     * METHOD: used by a concrete class to start its internal mechanism to start generating interval requests
     * 
     */
    void generateRequest();
    
    /**
     * 
     * METHOD: used by a concrete class to stop generating interval request, either calling itself or another parent class
     * 
     */
    void stopRequest();
    
    /**
     * @Deprecated
     * METHOD: used for testing to return the executor field
     * 
     * @return  ScheduledExecutorService   the executor set
     * 
     */
    @Deprecated
    ScheduledExecutorService getExecutor();
    
    /**
     * @Deprecated
     * METHOD: used for testing to return the _runnable field
     * 
     * @return  Runnable   the runnable field set
     * 
     */
    @Deprecated
    Runnable getRunnable();
}
