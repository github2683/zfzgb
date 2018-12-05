package cn.zfz.pojo.entity;

public class Permission {
    private String name;//权限 名称
    private String url;//权限请求url
    private String icon;//权限图标
    private Integer code;//权限代码
    private String modularId;//模块名称
    public Permission(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getModularId() {
        return modularId;
    }

    public void setModularId(String modularId) {
        this.modularId = modularId;
    }
}
