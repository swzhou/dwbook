package com.swzhou.dwbook.views;

import com.swzhou.dwbook.representations.Contact;
import io.dropwizard.views.View;

/**
 * Created by swzhou on 15/2/12.
 */
public class ContactView extends View {

    public Contact getContact() {
        return contact;
    }

    private final Contact contact;

    public ContactView(Contact contact) {
        super("/views/contact.mustache");
        this.contact = contact;
    }
}
