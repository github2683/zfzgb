package cn.zfz.pojo.base;

import java.time.LocalDateTime;
import java.util.UUID;

public class Base extends Search {
    private String id;

    private Integer seg;
    private String remark;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String optId;

    public Base(){
    }

    private void addInit(){
        if( this.id == null || this.id.trim().length()==0 ){
            this.id = UUID.randomUUID().toString();
        }
        this.updateTime = LocalDateTime.now();
        this.createTime = this.updateTime;
    }

    private void updateInit(){
        this.updateTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSeg() {
        return seg;
    }

    public void setSeg(Integer seg) {
        this.seg = seg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }
}
