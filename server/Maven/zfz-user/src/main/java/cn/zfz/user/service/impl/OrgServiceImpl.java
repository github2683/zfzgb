package cn.zfz.user.service.impl;

import cn.zfz.pojo.entity.Org;
import cn.zfz.user.dao.OrgDao;
import cn.zfz.user.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 组织的个性化功能实现
 */
@Service
public class OrgServiceImpl extends BaseServiceImpl<Org,OrgDao> implements OrgService {

    @Autowired
    private OrgDao orgDao;

    @Autowired
    public void setOrgDao(OrgDao orgDao) {
        this.dao = orgDao;
    }

}
