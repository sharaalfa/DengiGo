package com.ushara.dengigo.dao.impl;

import com.ushara.dengigo.dao.RequestTypeDao;
import com.ushara.dengigo.entity.RequestType;

@Repository
public class RequestTypeDaoImpl extends GenericDaoImpl<RequestType> implements RequestTypeDao{
    public RequestTypeDaoImpl() {
        super(RequestType.class);
    }

    @Override
    public RequestType getById(Integer id) {
        return getSession().get(RequestType.class, id);
    }

    @Override
    public void update(RequestType requestType) {
        getSession().update(requestType);
    }

    @Override
    public RequestType getByTitle(String title) {
        return (RequestType) getSession().createCriteria(RequestType.class)
                .add(Restrictions.eq("title", title)).uniqueResult();
    }

}
