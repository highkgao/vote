package com.highkgao.votedb;

import com.highkgao.votedb.VoteItemDO;

public interface VoteItemDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VoteItemDO record);

    int insertSelective(VoteItemDO record);

    VoteItemDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VoteItemDO record);

    int updateByPrimaryKey(VoteItemDO record);
}