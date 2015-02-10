package com.swzhou.dwbook.representations;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by swzhou on 15/2/10.
 */
public class Contact {

    private final int id;

    @NotBlank
    @Length(min = 2, max = 255)
    private final String firstName;

    @NotBlank
    @Length(min = 2, max = 255)
    private final String lastName;

    @NotBlank
    @Length(min = 2, max = 30)
    private final String phone;

    public Contact() {
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.phone = null;
    }

    public Contact(int id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }
}
