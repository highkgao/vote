package com.highkgao.voteweb.business.form;

import java.util.Date;

public class VoteThemeVO {
    /** 投票Id */
    private String voteId;

    /** 所属用户 */
    private String userId;

    /** 主题 */
    private String theme;

    /** 开始时间 yyyy-MM-dd hh:mm:ss */
    private String startTime;

    /** 结束时间  yyyy-MM-dd hh:mm:ss */
    private String finishTime;

    /** 参与人数 */
    private Integer participantsNumber;

    /** 状态 */
    private String voteStatus;

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getParticipantsNumber() {
        return participantsNumber;
    }

    public void setParticipantsNumber(Integer participantsNumber) {
        this.participantsNumber = participantsNumber;
    }

    public String getVoteStatus() {
        return voteStatus;
    }

    public void setVoteStatus(String voteStatus) {
        this.voteStatus = voteStatus;
    }
}
