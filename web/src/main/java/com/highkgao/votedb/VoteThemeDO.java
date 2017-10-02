package com.highkgao.votedb;

import java.util.Date;

public class VoteThemeDO {
    private String voteId;

    private String userId;

    private String theme;

    private Date startTime;

    private Date finishTime;

    private Integer participantsNumber;

    private Date gmtCreate;

    private Date gmtModified;

    private String voteStatus;

    public VoteThemeDO(String voteId, String userId, String theme, Date startTime, Date finishTime, Integer participantsNumber, Date gmtCreate, Date gmtModified, String voteStatus) {
        this.voteId = voteId;
        this.userId = userId;
        this.theme = theme;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.participantsNumber = participantsNumber;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.voteStatus = voteStatus;
    }

    public VoteThemeDO() {
        super();
    }

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId == null ? null : voteId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getParticipantsNumber() {
        return participantsNumber;
    }

    public void setParticipantsNumber(Integer participantsNumber) {
        this.participantsNumber = participantsNumber;
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

    public String getVoteStatus() {
        return voteStatus;
    }

    public void setVoteStatus(String voteStatus) {
        this.voteStatus = voteStatus == null ? null : voteStatus.trim();
    }
}