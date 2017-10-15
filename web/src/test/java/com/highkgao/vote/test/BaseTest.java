package com.highkgao.vote.test;

import com.highkgao.votedb.VoteThemeDO;
import com.highkgao.voteservice.UserService;
import com.highkgao.voteservice.VoteService;
import org.apache.ibatis.annotations.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_db.xml"
        , "classpath:applicationContext_service.xml"})
public class BaseTest {
    @Resource
    private VoteService voteService;


    @Test
    public void userTest() {
        List<VoteThemeDO> voteThemeDOList = voteService.queryVoteTheme("201709259034819", 1, 3, null);
        System.out.println(voteThemeDOList);
    }
}
