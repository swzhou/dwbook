package com.swzhou.dwbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by swzhou on 15/2/10.
 */
public class DWBookConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    private String message;

    @JsonProperty
    @Max(10)
    private int messageRepetitions;

    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty
    @NotEmpty
    private String authUser;

    @JsonProperty
    @NotEmpty
    private String authPassword;

    public String getMessage() {
        return message;
    }

    public int getMessageRepetitions() {
        return messageRepetitions;
    }

    public DataSourceFactory getDatabase() {
        return database;
    }

    public String getAuthUser() {
        return authUser;
    }

    public String getAuthPassword() {
        return authPassword;
    }
}
