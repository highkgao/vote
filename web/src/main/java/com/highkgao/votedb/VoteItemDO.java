package com.highkgao.votedb;

import java.util.Date;

public class VoteItemDO {
    private Integer id;

    private String voteId;

    private String itemId;

    private String picUrl;

    private String itemName;

    private String itemDesc;

    private String superiority;

    private Integer count;

    private Date gmtCreate;

    private Date gmtModified;

    public VoteItemDO(Integer id, String voteId, String itemId, String picUrl, String itemName, String itemDesc, String superiority, Integer count, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.voteId = voteId;
        this.itemId = itemId;
        this.picUrl = picUrl;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.superiority = superiority;
        this.count = count;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public VoteItemDO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId == null ? null : voteId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    public String getSuperiority() {
        return superiority;
    }

    public void setSuperiority(String superiority) {
        this.superiority = superiority == null ? null : superiority.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}