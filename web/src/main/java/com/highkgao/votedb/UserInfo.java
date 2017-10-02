package com.highkgao.votedb;

import java.util.Date;

public class UserInfo {
    private Long id;

    private String userId;

    private String userName;

    private String password;

    private String status;

    private Date gmtCreate;

    private Date gmtModified;

    private String logonId;

    private String email;

    public UserInfo(Long id, String userId, String userName, String password, String status, Date gmtCreate, Date gmtModified, String logonId, String email) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.logonId = logonId;
        this.email = email;
    }

    public UserInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getLogonId() {
        return logonId;
    }

    public void setLogonId(String logonId) {
        this.logonId = logonId == null ? null : logonId.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}