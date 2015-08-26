package com.datinko.prototype.datagenerator.core.firer;

import java.io.Console;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Neil on 26/08/2015.
 */
public class DemoFirer {

    public static void main(String[] args) throws InterruptedException {
        DemoFirer firer = new DemoFirer();
        firer.fireEvents();
    }

    public void fireEvents() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(100);  //means a limit of 100 concurrent runnables

        //create a runnable task that we can execute
        Runnable task = () -> {
            System.out.println("Scheduling: " + System.nanoTime());
            System.out.println("yo!");
        };

        //Schedule the runnable task to run after a delay of three seconds
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        //sleep for 2 seconds
        TimeUnit.MILLISECONDS.sleep(1337);

        //print out how long our future has left before it will execute
        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);

        //get a list of events to fire with times
        //log the start time of the whole thing
        //for each message, calculate the diff from the start time to the time of the event
        //schedule the tasks

        //(DO THIS)
        //OR
        //grab the first event, calc the time between its start and now.. schedule accordingly
        //grab the next event, repeat.. if the time between its start and now is <=0 then just schedule for now


    }


}
