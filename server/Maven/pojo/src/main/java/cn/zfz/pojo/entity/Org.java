package cn.zfz.pojo.entity;

import cn.zfz.pojo.base.Base;

public class Org extends Base {
    private String name;//组织名称
    private String icon;//组织图标
    private String pid;//组织父ID
    private String pids;//所有父组织ID

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

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }
}
