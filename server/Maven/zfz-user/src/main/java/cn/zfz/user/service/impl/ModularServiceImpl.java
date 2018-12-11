package cn.zfz.user.service.impl;


import cn.zfz.pojo.entity.Modular;
import cn.zfz.user.dao.ModularDao;
import cn.zfz.user.service.ModularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 模块的个性化功能实现
 */
@Service
public class ModularServiceImpl extends BaseServiceImpl<Modular,ModularDao> implements ModularService {

    @Autowired
    private ModularDao modularDao;
    @Autowired
    public void setModularDao(ModularDao modularDao) {
        this.dao = modularDao;
    }
}
