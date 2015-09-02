package com.datinko.prototype.datagenerator.core.firer;

import org.junit.Test;

/**
 * Created by Neil on 26/08/2015.
 */
public class DemoFirerTests {

    @Test
    public void canFireEvents() throws InterruptedException {
        DemoFirer firer = new DemoFirer();
        firer.fireEvents();
    }

}
