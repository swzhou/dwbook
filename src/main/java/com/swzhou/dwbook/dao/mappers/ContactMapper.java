package com.swzhou.dwbook.dao.mappers;

import com.swzhou.dwbook.representations.Contact;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by swzhou on 15/2/10.
 */
public class ContactMapper implements ResultSetMapper<Contact> {
    @Override
    public Contact map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Contact(
                r.getInt("id"),
                r.getString("firstName"),
                r.getString("lastName"),
                r.getString("phone")
        );
    }
}
