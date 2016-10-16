package com.ushara.dengigo.dao.impl;

import com.ushara.dengigo.dao.TempDao;
import com.ushara.dengigo.entity.Temp;

@Repository
public class TempDaoImpl extends GenericDaoImpl<Temp> implements TempDao{
    public TempDaoImpl() {
        super(Temp.class);
    }

    @Override
    public Temp getById(Integer id) {
        return getSession().get(Temp.class, id);
    }

}
