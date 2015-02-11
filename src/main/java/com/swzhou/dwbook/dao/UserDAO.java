package com.swzhou.dwbook.dao;

import com.swzhou.dwbook.dao.mappers.UserMapper;
import com.swzhou.dwbook.representations.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by swzhou on 15/2/12.
 */
public interface UserDAO {

    @SqlQuery("select count(*) from users where username = :username and password = :password")
    int getUser(@Bind("username") String username, @Bind("password") String password);

    @Mapper(UserMapper.class)
    @SqlQuery("select * from users limit 1")
    User findOneUser();
}
