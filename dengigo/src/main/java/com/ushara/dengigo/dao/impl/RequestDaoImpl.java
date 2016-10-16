package com.ushara.dengigo.dao.impl;

import com.ushara.dengigo.dao.RequestDao;

@Repository
public class RequestDaoImpl extends GenericDaoImpl<Request> implements RequestDao {
    public RequestDaoImpl() {
        super(Request.class);
    }

    @Override
    public Request getByRequestId(Integer requestId) {
        return getSession().get(Request.class, requestId);
    }

    @Override
    public Request getByName(String name) {
        return (Request) getSession().createCriteria(Request.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
    }
}
