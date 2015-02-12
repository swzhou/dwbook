package com.swzhou.dwbook;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.swzhou.dwbook.representations.Contact;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by swzhou on 15/2/12.
 */
public class ApplicationTest {
    @ClassRule
    public static final DropwizardAppRule<DWBookConfiguration> RULE =
            new DropwizardAppRule<>(DWBookApplication.class, "config.yml");
    private Client client;
    private Contact contactForTest = new Contact(0, "Jane", "Doe", "+987654321");

    @Before
    public void setUp() {
        client = new Client();
        client.addFilter(new HTTPBasicAuthFilter("wsuser", "wspassword"));
    }

    @Test
    public void createAddRetrieveContact() {
        WebResource contactResource = client.resource("http://localhost:8080/contact");
        ClientResponse response = contactResource.type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, contactForTest);

        assertThat(response.getStatus()).isEqualTo(201);

        String newContactURL = response.getHeaders().get("Location").get(0);
        WebResource newContactResource = client.resource(newContactURL);
        Contact contact = newContactResource.get(Contact.class);

        assertThat(contact.getFirstName()).isEqualTo(contactForTest.getFirstName());
        assertThat(contact.getLastName()).isEqualTo(contactForTest.getLastName());
        assertThat(contact.getPhone()).isEqualTo(contactForTest.getPhone());
    }
}
