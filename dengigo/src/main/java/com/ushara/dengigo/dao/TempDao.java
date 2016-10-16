package com.ushara.dengigo.dao;


public interface TempDao extends GenericDao<Temp>{
    Temp getById(Integer id);
}
