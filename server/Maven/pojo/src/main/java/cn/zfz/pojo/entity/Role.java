package cn.zfz.pojo.entity;

import cn.zfz.pojo.base.Base;

public class Role extends Base {

    private String name;//角色名称
    private String icon;//角色图标
    public Role(){}

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
}
