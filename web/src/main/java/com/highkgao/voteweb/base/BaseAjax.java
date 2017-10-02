package com.highkgao.voteweb.base;

import com.highkgao.voteCommon.ResultCode;
import com.highkgao.voteweb.contants.WebContants;
import org.springframework.ui.ModelMap;


/**
 * Created by gaofeng on 17/9/3.
 */
public class BaseAjax {

    protected void fillSuccess(ModelMap modelMap) {
        modelMap.put(WebContants.STATUS, WebContants.STATUS_SUCCESS);
    }

    protected void fillSuccess(ModelMap modelMap, Object object) {
        modelMap.put(WebContants.STATUS, WebContants.STATUS_SUCCESS);
        modelMap.put(WebContants.DATA, object);
    }

    protected void fillError(ModelMap modelMap, ResultCode resultCode) {
        modelMap.put(WebContants.STATUS, WebContants.STATUS_FAIL);
        modelMap.put(WebContants.errorCode, resultCode.getErrorCode());
        modelMap.put(WebContants.errorMsg, resultCode.getErrorMsg());

    }
}
