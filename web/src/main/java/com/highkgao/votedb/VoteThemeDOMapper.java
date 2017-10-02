package com.highkgao.votedb;

import com.highkgao.votedb.VoteThemeDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteThemeDOMapper {
    int deleteByPrimaryKey(String voteId);

    int insert(VoteThemeDO record);

    int insertSelective(VoteThemeDO record);

    VoteThemeDO selectByPrimaryKey(String voteId);

    int updateByPrimaryKeySelective(VoteThemeDO record);

    int updateByPrimaryKey(VoteThemeDO record);

    List<VoteThemeDO> selectByUserId(@Param("userId") String userId, @Param("keyword") String keyword, @Param("offset") int offset, @Param("limit") int limit);

    int selectCount(@Param("userId") String userId, @Param("keyword") String keyword);
}