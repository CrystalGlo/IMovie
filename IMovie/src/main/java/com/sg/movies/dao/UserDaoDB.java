package com.sg.movies.dao;

import com.sg.movies.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoDB implements UserDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public User getUser(String email, String userPassword) {
        try {
            final String GET_USER = "SELECT * FROM USER WHERE email = ? and userPassword = ?";
            return jdbc.queryForObject(GET_USER, new UserMapper(), email, userPassword);
        } catch (DataAccessException ex){
            return null;
        }
    }

    @Override
    @Transactional
    public User addUserAccount(User user) {
        final String ADD_USER = "INSERT INTO user(firstName, lastName, email, userPassword, isAdmin)" +
                "VALUES(?,?,?,?,?)";

        jdbc.update(ADD_USER,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUserPassword(),
                user.getIsAdmin());

        return user;
    }

    // mapper
    public static final class UserMapper implements  RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int index) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("email"));
            user.setUserPassword(rs.getString("userPassword"));
            user.setIsAdmin(rs.getInt("isAdmin"));

            return user;
        }
    }
}
