package com.gientech.learn.order.wrapper;

import com.gientech.learn.account.api.AccountApi;
import com.gientech.learn.account.dto.AccountMsgDTO;
import com.gientech.learn.order.service.AccountService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xiefei
 * @date 2023/03/05
 */
@Component
@RocketMQMessageListener(consumerGroup = "01account", topic = "account")
public class AccountWrapper implements RocketMQListener {
    @Resource
    private AccountApi     accountApi;
    @Resource
    private AccountService accountService;

    public boolean find(Long accountId) {
        return accountApi.validate(accountId);
    }

    @Override
    public void onMessage(Object message) {
        AccountMsgDTO accountMsgDTO = (AccountMsgDTO) message;
        if (accountMsgDTO.getMsgId() == null
                || !idempotent(accountMsgDTO.getMsgId())
                || accountMsgDTO.getOperationType() == null
                || accountMsgDTO.getAccountId() == null) {
            return;
        }
        if (accountMsgDTO.getOperationType() == 1) {
            accountService.add(accountMsgDTO.getAccountId());
        } else if (accountMsgDTO.getOperationType() == 0) {
            accountService.remove(accountMsgDTO.getAccountId());
        }
    }

    private boolean idempotent(String msgId) {
        // TODO: 2023/3/8 幂等逻辑
        return true;
    }
}
