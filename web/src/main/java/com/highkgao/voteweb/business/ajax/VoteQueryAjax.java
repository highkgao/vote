package com.highkgao.voteweb.business.ajax;

import com.highkgao.votedb.VoteThemeDO;
import com.highkgao.voteservice.VoteService;
import com.highkgao.voteweb.base.BaseAjax;
import com.highkgao.voteweb.business.convert.WebConvert;
import com.highkgao.voteweb.business.form.VoteThemeVO;
import com.highkgao.voteweb.contants.SessionContants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "vote")
public class VoteQueryAjax extends BaseAjax {

    @Resource
    private VoteService voteService;

    /**
     * 获取投票的列表
     *
     * @param modelMap
     * @param pageNo   页码
     * @param pageSize 单页大小
     * @param keyword  搜索词
     */
    @RequestMapping(value = "getVoteTheme.json", method = RequestMethod.GET)
    public void getTheme(ModelMap modelMap, int pageNo, int pageSize, String keyword, HttpSession session) {
        String userId = (String) session.getAttribute(SessionContants.LOGON_USER_ID);
        List<VoteThemeDO> voteThemeDOList = voteService.queryVoteTheme(userId, pageNo, pageSize, keyword);
        List<VoteThemeVO> voteThemeVOList = new ArrayList<VoteThemeVO>();
        for (VoteThemeDO voteThemeDO : voteThemeDOList) {
            voteThemeVOList.add(WebConvert.convertToThemeVO(voteThemeDO));
        }
        modelMap.put("rows", voteThemeVOList);
        modelMap.put("total", voteService.queryVoteCount(userId, keyword));
    }
}
