package cn.zfz.pojo.entity;

import cn.zfz.pojo.base.Base;

public class Modular extends Base {
    private String name;//模块名称
    private String icon;//模块图标

    public Modular(){}

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
