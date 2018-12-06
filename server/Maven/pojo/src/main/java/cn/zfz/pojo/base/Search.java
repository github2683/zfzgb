package cn.zfz.pojo.base;

import java.time.LocalDateTime;

public class Search {

    private String key;
    private LocalDateTime startCreateTime;
    private LocalDateTime endCreateTime;

    private LocalDateTime startUpdateTime;
    private LocalDateTime endUpdateTime;

    private Integer page;//第几页
    private Integer limit;//一页几条
    private Integer total;//总数


    public Search() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LocalDateTime getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(LocalDateTime startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public LocalDateTime getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(LocalDateTime endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public LocalDateTime getStartUpdateTime() {
        return startUpdateTime;
    }

    public void setStartUpdateTime(LocalDateTime startUpdateTime) {
        this.startUpdateTime = startUpdateTime;
    }

    public LocalDateTime getEndUpdateTime() {
        return endUpdateTime;
    }

    public void setEndUpdateTime(LocalDateTime endUpdateTime) {
        this.endUpdateTime = endUpdateTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
