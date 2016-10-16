package com.ushara.dengigo.service.impl;

@Service
@CrossOrigin(origins = "*")
public class RoleServiceImpl {
    @Autowired
    RoleDao roleDao;

    public Role getById(Integer id){
        return roleDao.getById(id);
    }
    public Role getByName(String name){
        return null;
    }
}
