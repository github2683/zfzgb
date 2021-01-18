package cn.zfz.user.service.impl;

import cn.zfz.pojo.entity.Permission;
import cn.zfz.user.dao.PermissionDao;
import cn.zfz.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 权限的个性化功能实现
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, PermissionDao> implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    public void setPermissionDao(PermissionDao permissionDao) {
        this.dao = permissionDao;
    }
}
