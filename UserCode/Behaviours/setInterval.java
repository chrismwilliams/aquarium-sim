package UserCode.Behaviours;

import UserCode.Misc.IRandomNumber;
import UserCode.Misc.RandomNumber;
import UserCode.Components.IComponent;
import java.util.concurrent.*;

/**
 * setInterval class defines the concrete implementation of the IIntervalRequest interface. This class is to be used to generate
 * request a a specified time, otherwise it will select one between 3 and 7 seconds. The class will then call the IComponent componentAction() method
 * at every interval
 * 
 * @author Chris Williams 
 * @version 3.0
 */
public class setInterval implements IIntervalRequest
{
    // DECLARE a RandomNumber to store an instance of RandomNumber, call it '_random':
    private IRandomNumber _random;

    // DECLARE an double field to store the minimum time period this class will generate a request, call it '_min':
    private double _min;

    // DECLARE an double field to store the maximum time period this class will generate a request, call it '_max':
    private double _max;

    // DECLARE a ScheduledExecutroService field to store a reference to the class that will generate the set interval call, call it 'executor':
    private ScheduledExecutorService executor = null;

    // DECLARE a Runnable class that will be called at intervals in seconds, call it '_runnable':
    private Runnable _runnable;

    // DECLARE an IComponent field to store a reference to the class that will be called for the set interval period generated/set
    private IComponent _requestComponent;

    /**
     * Constructor for objects of class setInterval
     * 
     * @param   request   the concrete implementation of an IComponent that will be informed at intervals via the componentAction() method. This will
     * default to a time between 3 - 7 seconds
     * 
     */
    public setInterval(IComponent request)
    {
        // CALL the second constructor with default values for min and max and pass the IRequest:
        this(request,3.0,7.0);
    }

    /**
     * 
     * Constructor for objects of class setInterval. This constructor includes the min and max params with which the generateRequest() method will use
     * to randomly choose a set interval request between
     * 
     * @param   request   the concrete implementation of type IComponent that will be called at intervals via the componentAction() method.
     * @param   min   the minimum amount of time in seconds that generateRequest() should use
     * @param   max   the maximum amount of time in seconds that generateRequest() should use
     * 
     */
    public setInterval(IComponent request, double min, double max)
    {
        // INITALISE the RandomNumber class held in the _random field:
        _random = RandomNumber.INSTANCE;

        // INITIALISE the _min and _max fields to the values passed:
        _min = min;
        _max = max;

        // INITIALISE the _requestComponent field with the IComponent passed:
        _requestComponent = request;
    }

    /**
     * 
     * METHOD: this method calls the componentAction method of the IComponent class held in the _requestComponent field to notify at intervals determined by the 
     * generateRequest() method
     * 
     */
    public void callRequest()
    {
        // CALL the componentAction method on the IComponent class held in the _requestComponent field:
        _requestComponent.componentAction();
    }

    /**
     * 
     * METHOD: this method will generate an event at set intervals in seconds between the values passed in construction (or default). It will then
     * call the callRequest() method. This will continue unless the stopRequest method is called.
     * 
     */
    public void generateRequest()
    {
        // CHECK if the ScheduledExecutorService is already running:
        if (executor == null) {

            // INITIALISE the Runnable class:
            _runnable = new Runnable() 
            {
                // // SET a run method that will be run by the executor:
                public void run() 
                {
                    //System.out.println("Making a request!");

                    // CALL the method callRequest: 
                    callRequest();
                }
            };

            // INITIALISE a random int with the _min and _max fields by calling the RandomNumber generateNumber(), call it '_d':    
            int _delay = (int) _random.generateNumber(_min, _max);

            // INITIALISE a ScheduledExevutorService to create a new single thread:
            executor = Executors.newScheduledThreadPool(1);

            // SET the schedule of _executor to run the _runnable run method with the initial delay and period between calls with the _delay field
            // intialise above:
            executor.scheduleAtFixedRate(_runnable, _delay, _delay, TimeUnit.SECONDS);
        }
    }

    /**
     * 
     * METHOD: used to end the interval request. This method will set the _runnable field to null and call shutdown() on the executor
     * 
     */
    public void stopRequest()
    {
        // CALL the method shutdown on the ScheduledExevutorService executor field if has been set:
        if(executor != null)
        {
            // System.out.println("Shutting down");
            // CALL the shutdown() method:
            executor.shutdown();
            
            // SET the executor to null:
            executor = null;

            // SET the _runnable to null:
            _runnable = null;        
        }
    }
    
    /**
     * @Deprecated
     * METHOD: used for testing to return the executor field
     * 
     */
    @Deprecated
    public ScheduledExecutorService getExecutor()
    {
        // RETURN executor field:
        return executor;
    }
    
    /**
     * @Deprecated
     * METHOD: used for testing to return the _runnable field
     * 
     */
    @Deprecated
    public Runnable getRunnable()
    {
        // RETURN the _runnable field:
        return _runnable;
    }
}
