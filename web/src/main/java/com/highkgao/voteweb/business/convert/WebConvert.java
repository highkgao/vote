package com.highkgao.voteweb.business.convert;

import com.highkgao.votedb.VoteThemeDO;
import com.highkgao.voteweb.business.form.VoteThemeVO;
import com.highkgao.voteweb.util.DateUtil;

public class WebConvert {

    public static VoteThemeVO convertToThemeVO(VoteThemeDO voteThemeDO) {
        VoteThemeVO voteThemeVO = new VoteThemeVO();
        voteThemeVO.setVoteId(voteThemeDO.getVoteId());
        voteThemeVO.setUserId(voteThemeDO.getUserId());
        voteThemeVO.setStartTime(DateUtil.getStringFromDate(voteThemeDO.getStartTime(), DateUtil.DATE_YYYY_MM_DD_HH_MM_SS));
        voteThemeVO.setFinishTime(DateUtil.getStringFromDate(voteThemeDO.getFinishTime(), DateUtil.DATE_YYYY_MM_DD_HH_MM_SS));
        voteThemeVO.setParticipantsNumber(voteThemeDO.getParticipantsNumber());
        voteThemeVO.setTheme(voteThemeDO.getTheme());
        voteThemeVO.setVoteStatus(voteThemeDO.getVoteStatus());
        return voteThemeVO;
    }
}
