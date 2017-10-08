package com.highkgao.voteservice;

import com.highkgao.votedb.VoteItemDO;
import com.highkgao.votedb.VoteItemDOMapper;
import com.highkgao.votedb.VoteThemeDO;
import com.highkgao.votedb.VoteThemeDOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;


public class VoteServiceImpl implements VoteService {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(VoteServiceImpl.class);

    @Resource
    VoteItemDOMapper voteItemDOMapper;

    @Resource
    VoteThemeDOMapper voteThemeDOMapper;

    @Resource
    TransactionTemplate voteTransactionTemplate;


    public void addVote(final VoteThemeDO voteThemeDO, final List<VoteItemDO> voteItemDOList) {
        boolean isAddSuccess = voteTransactionTemplate.execute(new TransactionCallback<Boolean>() {
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                try {
                    voteThemeDOMapper.insert(voteThemeDO);
                    for (VoteItemDO voteItemDO : voteItemDOList) {
                        voteItemDOMapper.insert(voteItemDO);
                    }
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    LOGGER.error("插入投票信息失败", e);
                    return false;
                }
                return true;
            }
        });

        if (!isAddSuccess) {
            LOGGER.error("新增投票失败 voteTheme={0} voteItemList={1}", voteThemeDO, voteItemDOList);
            throw new RuntimeException("新增投票失败");
        }
    }

    public List<VoteThemeDO> queryVoteTheme(String userId, int pageNo, int pageSize, String keyword) {
        int offset = (pageNo - 1) * pageSize;
        int limit = offset + pageSize;
        return voteThemeDOMapper.selectByUserId(userId, keyword, offset, limit);
    }

    public int queryVoteCount(String userId, String keyword) {
        return voteThemeDOMapper.selectCount(userId, keyword);
    }

}
