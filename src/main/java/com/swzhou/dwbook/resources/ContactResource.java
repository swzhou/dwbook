package com.swzhou.dwbook.resources;

import com.google.common.base.Supplier;
import com.swzhou.dwbook.dao.ContactDAO;
import com.swzhou.dwbook.representations.Contact;
import org.skife.jdbi.v2.DBI;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by swzhou on 15/2/10.
 */
@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {

    private final ContactDAO contactDao;
    private final Validator validator;

    public ContactResource(DBI jdbi, Validator validator) {
        this.validator = validator;
        contactDao = jdbi.onDemand(ContactDAO.class);
    }

    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        Contact contact = contactDao.getContactById(id);
        return Response.ok(contact).build();
    }

    @POST
    public Response createContact(Contact contact) throws URISyntaxException {
        return validateAndReturn(contact, () -> {
            int newContactId = contactDao.createContact(contact.getFirstName(),
                    contact.getLastName(), contact.getPhone());
            return Response.created(new URI(String.valueOf(newContactId))).build();
        });
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        contactDao.deleteContact(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(@PathParam("id") int id, Contact contact) throws URISyntaxException {
        return validateAndReturn(contact, () -> {
            contactDao.updateContact(id, contact.getFirstName(),
                    contact.getLastName(), contact.getPhone());
            return Response
                    .ok(new Contact(id, contact.getFirstName(), contact.getLastName(), contact.getPhone()))
                    .build();
        });
    }

    private Response validateAndReturn(Contact contact, ResponseGetter responseGetter) throws URISyntaxException {
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
        if (!violations.isEmpty()) {
            List<String> validationMessages = violations.stream()
                    .map(v -> v.getPropertyPath().toString() + ":" + v.getMessage())
                    .collect(Collectors.toList());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(validationMessages).build();
        }
        return responseGetter.get();
    }
}
