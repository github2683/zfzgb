package cn.zfz.pojo.entity;

import cn.zfz.pojo.base.Base;

public class Org extends Base {
    private String name;//组织名称
    private String icon;//组织图标
    private String pid;//组织父ID

    public Org() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
