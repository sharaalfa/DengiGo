package com.ushara.dengigo.dao;


public interface RoleDao extends GenericDao<Role> {
    Role getById(Integer id);

    Role getByName(String name)
}
