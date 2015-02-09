package com.swzhou.dwbook;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by swzhou on 15/2/9.
 */
public class DWBookApplication extends Application<DWBookConfiguration> {
    private static final Logger LOGGER= LoggerFactory.getLogger(DWBookApplication.class);

    @Override
    public void initialize(Bootstrap<DWBookConfiguration> bootstrap) {

    }

    @Override
    public void run(DWBookConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Method DWBookApplication#run() called");
        for (int i = 0; i < configuration.getMessageRepetitions(); i++) {
            System.out.println(configuration.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        new DWBookApplication().run(args);
    }
}
