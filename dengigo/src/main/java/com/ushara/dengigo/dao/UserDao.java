package com.ushara.dengigo.dao;


public interface UserDao extends GenericDao<User> {
    User getByLogin(String login);
}
