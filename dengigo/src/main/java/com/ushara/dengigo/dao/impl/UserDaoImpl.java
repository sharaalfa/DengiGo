package com.ushara.dengigo.dao.impl;

import com.ushara.dengigo.dao.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByLogin(String login) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }
}
