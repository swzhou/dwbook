package com.swzhou.dwbook;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by swzhou on 15/2/9.
 */
public class DWBookApplication extends Application<Configuration> {
    private static final Logger LOGGER= LoggerFactory.getLogger(DWBookApplication.class);

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {

    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        LOGGER.info("Method DWBookApplication#run() called");
        System.out.println("Hello world, by Dropwizard!");
    }

    public static void main(String[] args) throws Exception {
        new DWBookApplication().run(args);
    }
}
