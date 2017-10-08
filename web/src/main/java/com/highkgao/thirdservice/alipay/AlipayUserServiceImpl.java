package com.highkgao.thirdservice.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AlipayUserServiceImpl implements AlipayUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlipayUserServiceImpl.class);

    private static final String APP_ID = "2017092708963179";

    private static final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC3FYuyLFnroTWp\n" +
            "/rNhGAEEKuy+SeMCBgw0WwtZqp/jI7QgaM38cTKBMP8TzCv4o1TyBgd4k78sGox+\n" +
            "6mGdH9mPXuFMg5Sz26DXQjWZDMJ9BXTUGcXZl2s7sTZmMQ3CT/WaOVVLh41+K4di\n" +
            "xA7DoAx2GUWRojmheXRZwJR0gIR2BkbkmUBjWNRd0UtlRBK4GLIvzoCrMOX68kfJ\n" +
            "5DQUV03C6nFGM+Db8aJKnMAc2obWpZcPcA+cgt6SilqbMjzIS4LP/wmyz07oQs2E\n" +
            "Ssd9ND7szf3C9mTcxqkL4xR195riedhTwRY//kOV4CuwbsIfZAVCn5KLw/vgkd2t\n" +
            "T4snrP9tAgMBAAECggEBAJD1vD/8oc3RPJ42jmzIBrX4Dq6z7cuCYlNp6ti6IhJE\n" +
            "CLDIip/gOK7VzoEsXXxmRjHC2FN+GBWhh7BNf7BasXW1GAnu/ORTd0w4nhtqYOuA\n" +
            "UHpHVcHtA/ilXX8YQ96gVMQhtQkycLN/X5ixx0bZCETRyaV/nsXdVmRh+KktwLN4\n" +
            "+S1gZJTrS/yDF5t1aOG+haYkGW94eZfrv4wz3cJ7F9aQ1ii+H14Pd62ULRy9PJNI\n" +
            "gqhFaNuFtalz2BjLhcmU2s5zPwHdcIhxvibj9cb+dtxjVh2H5P8z29nU/lBFHGhk\n" +
            "QGW45+8iMqQue7QiHyg6lGUmFXlGKpSdw6m4DnN5r0ECgYEA6Abw9phmdkVyP4IE\n" +
            "bC7+rEuq/ffApjRWzjfetCL3tftrt//TQivZ4IlTSLn3q7xfs4+MqC+b2GddJjpS\n" +
            "Aw40yjn8qyGJ9eZ5Z3AfKKJnD9+RWUjVGM5sc09Pf3rHm51sBK7F/FTx93/mj0YX\n" +
            "9gTh7+vxh7SsZyfbDEKSFaGwqGUCgYEAygATYBNuNskxZCAzvUX6ra/Bg2nZwwjv\n" +
            "zRXMa1GuZjWCT87viIkVll/ZzsOe6jdinyqjCSvEdD1OA8Kre73iZ3Z0SXJQ2cWx\n" +
            "9ix46l9I7UilMOZ61ncdwmH7sDAvpgFVVswOxx0m8vwWmdPCXHnk2+x4BG4HoG4J\n" +
            "7TcEvNWuVmkCgYAB9h0PWJZ1JX0jwEudRoBsoG8fmnqMbSDWuW4ug6UoaqmscoMs\n" +
            "qgY7ea20ja3kS8FbWTlNKqncmHMXIaMT14jmtLrID46E/5/DGhWJWGYaoj8uTAlR\n" +
            "Hl2YU/FOGJGbZSdGmtudmHI7L1+ZknQdZkkqqAnwpbxXWuTlI6Lsf+NoaQKBgQCd\n" +
            "Ok/acWVRCWsDVzlOcqC6/llucz6HW3ZjuDrjsbFAZxfmDNlO+fyuji7XjFYuUivW\n" +
            "XfaG1eVU4L7PmH+nklYeWAoNfQhHaWSqi1UWgFIgN3I0zMECG7czLNcd/XOpD9Kf\n" +
            "+7bo7tz5NpRU6YmYN1yWfcmxEP+otN3PIQrz/JJ1OQKBgHzQM4Q+8FOEhoK9Q8wl\n" +
            "WoHgxUvnd+n1YKnSmK39ksL6on82JsAQHcvsZc7bQ8K+rexaqv6UAgSDKtx03Xhx\n" +
            "6B604zVTa4vokL4OcZjuyAXoQVUSGnsHuh8UIZjHFP++MlUGYbcef1JXNO3aB7tj\n" +
            "gHZv31bpiOuvepYrJXO+qWyc";
    private static final String APP_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp+c6GQFx0xb15dLuhITaYcLMtkV5WJqwfyU+q5/caQLwMLzutfQVPnJWPIuykDc+fHLCT7oUXiYYZRlFkDSvIJed4PdPVejHDJryFMzmAt5OUxyrtW/EUGVW4btE6DLgn0Kfl2mHu0PIiVwUwnzNufMexm3rgqh0KWFPvMutMWtClvdpdflWugj6N2wyWylnbOJxrlBGNtt86Q91EhbDWvMlSObhYTX6tW42U8bhZUcAeNk61iN1UZeF5UDHOXXREU95T7kXvHm3W1u2lfdrktIHAcNsL9BYtB0sm6xaWaa7SxW76UNOHIPKI+nopGnF1hylyTzOciLewqDofkeU7wIDAQAB";

    private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmw5fPkOdNDnbIC53kP39agb9d5U/o3SpQ17xK/ARhyYYK4gAHr/o67aWEhNoBQTNGig6yjzla8EH64hFcP+aOUD0xhk7hW5iZxdY/pXbKVKb8Uc9stIk36X9PkFDtEfrwp1m9vm0CMJ0R2fU4KZguE1ItMCmYnLwBsl+o4/Sv/pqWpLvxTIxodwo3yvSQr6tg1lMl/Hmj3Xyf/iYZqsRtSEEAU4hvjkHnj3y89Xl7+1nKBej6ownSYvVYiuFuEUJuGzMB+mg7Kvoai0IJuBCLUOtqzrAR1NQIx7kaK6gKpdoNGICP5vH91x+Z0Hf3NcW30xWI5FbJRUz1Uzn3iTE6QIDAQAB";


    public ThirdUserInfoModel alipayUserAuthorize(String authCode) {

        try {
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", "GBK", ALIPAY_PUBLIC_KEY, "RSA2");
            AlipaySystemOauthTokenRequest alipaySystemOauthTokenRequest = new AlipaySystemOauthTokenRequest();
            alipaySystemOauthTokenRequest.setGrantType("authorization_code");
            alipaySystemOauthTokenRequest.setCode(authCode);
            AlipaySystemOauthTokenResponse alipaySystemOauthTokenResponse = alipayClient.execute(alipaySystemOauthTokenRequest);
            if (alipaySystemOauthTokenResponse.isSuccess()) {
                LOGGER.info("alipay.system.oauth.token 调用成功 ");
            } else {
                LOGGER.info("alipay.system.oauth.token 调用失败 ");
                throw new RuntimeException("获取用户信息失败，alipay.system.oauth.token 调用失败");
            }
            alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", "GBK", ALIPAY_PUBLIC_KEY, "RSA2");
            AlipayUserInfoShareRequest alipayUserInfoShareRequest = new AlipayUserInfoShareRequest();
            AlipayUserInfoShareResponse alipayUserInfoShareResponse = alipayClient.execute(alipayUserInfoShareRequest, alipaySystemOauthTokenResponse.getAccessToken());
            if (alipayUserInfoShareResponse.isSuccess()) {
                LOGGER.info("alipay.user.info.share 调用成功");
            } else {
                LOGGER.info("alipay.user.info.share 调用失败 ");
                throw new RuntimeException("获取用户信息失败，alipay.user.info.share 调用失败");
            }
            ThirdUserInfoModel thirdUserInfoModel = new ThirdUserInfoModel();
            thirdUserInfoModel.setAvatar(alipayUserInfoShareResponse.getAvatar());
            thirdUserInfoModel.setCity(alipayUserInfoShareResponse.getCity());
            thirdUserInfoModel.setGender(alipayUserInfoShareResponse.getGender());
            thirdUserInfoModel.setIsCertified(alipayUserInfoShareResponse.getIsCertified());
            thirdUserInfoModel.setNikeName(alipayUserInfoShareResponse.getNickName());
            thirdUserInfoModel.setProvince(alipayUserInfoShareResponse.getProvince());
            thirdUserInfoModel.setUserIdThird(alipayUserInfoShareResponse.getUserId());
            thirdUserInfoModel.setUserIdChannel("alipay");

            return thirdUserInfoModel;
        } catch (AlipayApiException e) {
            LOGGER.error("获取支付宝会员信息失败，系统异常", e);
            throw new RuntimeException(e);
        }
    }
}
