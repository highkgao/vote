package com.highkgao.votedb;

/**
 * 用户状态枚举
 */
public enum UserStatusEnum {

    Valid("Valid");

    private String status;

    UserStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
