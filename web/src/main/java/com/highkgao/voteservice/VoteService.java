package com.highkgao.voteservice;


import com.highkgao.votedb.VoteItemDO;
import com.highkgao.votedb.VoteThemeDO;

import java.util.List;

public interface VoteService {

    void addVote(VoteThemeDO voteThemeDO, List<VoteItemDO> voteItemDOList);

    List<VoteThemeDO> queryVoteTheme(String userId,int pageNo,int pageSize,String keyword);

    int queryVoteCount(String userId, String keyword);
}
