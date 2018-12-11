package cn.zfz.user.service.impl;

import cn.zfz.pojo.entity.Role;
import cn.zfz.user.dao.RoleDao;
import cn.zfz.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色的个性化功能实现
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,RoleDao> implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.dao = roleDao;
    }
}
