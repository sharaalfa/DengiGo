package com.ushara.dengigo.dao;

import jdk.nashorn.internal.ir.RuntimeNode;

public interface RequestDao extends GenericDao<Request> {

    Request getByName(String name);


    Request getByRequestId(Integer requestId);


}
