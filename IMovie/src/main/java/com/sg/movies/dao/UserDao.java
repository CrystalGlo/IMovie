package com.sg.movies.dao;

import com.sg.movies.models.User;

public interface UserDao {

    User getUser(String email, String userPassword);
    User addUserAccount(User user);
}
