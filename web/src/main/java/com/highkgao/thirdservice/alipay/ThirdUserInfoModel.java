package com.highkgao.thirdservice.alipay;

/**
 * 第三方公司的用户数据
 */
public class ThirdUserInfoModel {
    /** 第三方用户的userId */
    private String userIdThird;

    /** 第三方用户的渠道 alipay、wx */
    private String userIdChannel;

    /** 映射我方的userId */
    private String relationOwnerUserId;

    /** 第三方的昵称 */
    private String nikeName;

    /** 第三方的用户头像 */
    private String avatar;

    /** 省 */
    private String province;

    /** 市 */
    private String city;

    /** 性别 */
    private String gender;

    /** 实名认证信息 */
    private String isCertified;

    public String getUserIdThird() {
        return userIdThird;
    }

    public void setUserIdThird(String userIdThird) {
        this.userIdThird = userIdThird;
    }

    public String getUserIdChannel() {
        return userIdChannel;
    }

    public void setUserIdChannel(String userIdChannel) {
        this.userIdChannel = userIdChannel;
    }

    public String getRelationOwnerUserId() {
        return relationOwnerUserId;
    }

    public void setRelationOwnerUserId(String relationOwnerUserId) {
        this.relationOwnerUserId = relationOwnerUserId;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsCertified() {
        return isCertified;
    }

    public void setIsCertified(String isCertified) {
        this.isCertified = isCertified;
    }

    @Override
    public String toString() {
        return "ThirdUserInfoModel{" +
                "userIdThird='" + userIdThird + '\'' +
                ", userIdChannel='" + userIdChannel + '\'' +
                ", relationOwnerUserId='" + relationOwnerUserId + '\'' +
                ", nikeName='" + nikeName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", isCertified='" + isCertified + '\'' +
                '}';
    }
}
