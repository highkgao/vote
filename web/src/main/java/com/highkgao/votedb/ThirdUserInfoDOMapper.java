package com.highkgao.votedb;

import com.highkgao.votedb.ThirdUserInfoDO;
import org.apache.ibatis.annotations.Param;

public interface ThirdUserInfoDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ThirdUserInfoDO record);

    int insertSelective(ThirdUserInfoDO record);

    ThirdUserInfoDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ThirdUserInfoDO record);

    int updateByPrimaryKey(ThirdUserInfoDO record);

    ThirdUserInfoDO selectByUserIdAndChannel(@Param("userId") String userId, @Param("channel") String channel);
}