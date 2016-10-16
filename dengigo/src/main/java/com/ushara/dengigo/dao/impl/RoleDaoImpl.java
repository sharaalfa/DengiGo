package com.ushara.dengigo.dao.impl;

@Repository
public class RoleDaoImpl extends  GenericDaoImpl<Role> implements RoleDao{
    public RoleDaoImpl() {
        super(Role.class);
    }

    @Override
    public Role getById(Integer id) {
        return getSession().get(Role.class, id);
        //return (Role) getSession().getNamedQuery("Role.findById").uniqueResult();
    }

    @Override
    public Role getByName(String name) {
        return (Role) getSession().createCriteria(Role.class)
                .add(Restrictions.eq("name", name)).uniqueResult();
    }
}
