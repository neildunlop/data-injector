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


    }


}
