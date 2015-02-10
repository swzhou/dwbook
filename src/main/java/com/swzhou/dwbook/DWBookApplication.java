package com.swzhou.dwbook;

import com.swzhou.dwbook.resources.ContactResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
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
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabase(), "mysql");
        environment.jersey().register(new ContactResource(jdbi));
    }

    public static void main(String[] args) throws Exception {
        new DWBookApplication().run(args);
    }
}
