package com.swzhou.dwbook.representations;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by swzhou on 15/2/12.
 */
public class User {

    @NotBlank
    @Length(min = 5, max = 20)
    private final String username;

    @NotBlank
    @Length(min = 8, max = 255)
    private final String password;

    public User() {
        this.username = null;
        this.password = null;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
