package com.highkgao.thirdservice.alipay;


/**
 * 支付宝用户服务
 */
public interface AlipayUserService {

    /**
     * 支付宝用户授权行为
     * @param authCode 支付宝用户授权码
     * @return
     */
    ThirdUserInfoModel alipayUserAuthorize(String authCode);
}
