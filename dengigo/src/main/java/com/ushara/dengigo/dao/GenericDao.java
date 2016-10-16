package com.ushara.dengigo.dao;


public interface GenericDao<T> {
    int save(T object);

    void update(T object);

    void delete(T object);

    List<T> getAll();
}
