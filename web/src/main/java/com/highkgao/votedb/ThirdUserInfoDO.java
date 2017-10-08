package com.highkgao.votedb;

public class ThirdUserInfoDO {
    private Integer id;

    private String userIdThird;

    private String userIdChannel;

    private String relationOwnerUserId;

    private String nikeName;

    private String avatar;

    private String province;

    private String city;

    private String gender;

    private String isCertified;

    public ThirdUserInfoDO(Integer id, String userIdThird, String userIdChannel, String relationOwnerUserId, String nikeName, String avatar, String province, String city, String gender, String isCertified) {
        this.id = id;
        this.userIdThird = userIdThird;
        this.userIdChannel = userIdChannel;
        this.relationOwnerUserId = relationOwnerUserId;
        this.nikeName = nikeName;
        this.avatar = avatar;
        this.province = province;
        this.city = city;
        this.gender = gender;
        this.isCertified = isCertified;
    }

    public ThirdUserInfoDO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserIdThird() {
        return userIdThird;
    }

    public void setUserIdThird(String userIdThird) {
        this.userIdThird = userIdThird == null ? null : userIdThird.trim();
    }

    public String getUserIdChannel() {
        return userIdChannel;
    }

    public void setUserIdChannel(String userIdChannel) {
        this.userIdChannel = userIdChannel == null ? null : userIdChannel.trim();
    }

    public String getRelationOwnerUserId() {
        return relationOwnerUserId;
    }

    public void setRelationOwnerUserId(String relationOwnerUserId) {
        this.relationOwnerUserId = relationOwnerUserId == null ? null : relationOwnerUserId.trim();
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName == null ? null : nikeName.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getIsCertified() {
        return isCertified;
    }

    public void setIsCertified(String isCertified) {
        this.isCertified = isCertified == null ? null : isCertified.trim();
    }
}