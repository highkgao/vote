package com.highkgao.voteweb.business.form;

import java.util.List;

public class AddVoteForm {

    private String theme;
    private String desc;
    private String startTime;
    private String endTime;
    private List<ItemVO> items;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<ItemVO> getItems() {
        return items;
    }

    public void setItems(List<ItemVO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "AddVoteForm{" +
                "theme='" + theme + '\'' +
                ", desc='" + desc + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", items=" + items +
                '}';
    }
}
