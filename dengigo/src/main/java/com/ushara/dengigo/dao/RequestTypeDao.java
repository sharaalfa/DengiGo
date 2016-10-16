package com.ushara.dengigo.dao;


public interface RequestTypeDao extends GenericDao<RequestType>{
    RequestType getById(Integer requestTypeId);

    void update(RequestType requestType);

    RequestType getByTitle(String title);
}
