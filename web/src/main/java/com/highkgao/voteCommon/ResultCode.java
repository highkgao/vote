package com.highkgao.voteCommon;

public enum ResultCode {

    ACCOUNT_NOT_EXSIT("ACCOUNT_NOT_EXSIT","账号不存在"),
    LOGON_PASSWORD_ERROR("LOGON_PASSWORD_ERROR","登录密码错误"),
    SESSION_OUT("SESSION_OUT","请重新登录"),
    ;


    private String errorCode;

    private String errorMsg;

    ResultCode(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
