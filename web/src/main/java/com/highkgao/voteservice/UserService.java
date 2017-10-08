package com.highkgao.voteservice;

import com.highkgao.votedb.UserInfo;


public interface UserService {

    /**
     * 注册正式用户
     * @param account 账号名
     * @param name 用户名
     * @param md5password 密码
     * @return {@link UserInfo}
     */
    UserInfo registerUser(String account, String name, String md5password);


    /**
     * 支付宝用户授权,在这里针对一个支付宝用户，会静默创建一个用户，并进行关联
     * @param authCode 支付宝的授权码
     * @return {@link UserInfo}
     */
    UserInfo alipayUserAuthorize(String authCode);
}
