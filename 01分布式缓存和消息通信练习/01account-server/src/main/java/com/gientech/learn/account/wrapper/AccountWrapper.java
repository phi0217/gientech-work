package com.gientech.learn.account.wrapper;

import com.gientech.learn.account.dto.AccountMsgDTO;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xiefei
 * @date 2023/03/08
 */
@Component
public class AccountWrapper {
    private static String topic = "account";
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void add(Long accountId) {
        AccountMsgDTO accountMsgDTO = new AccountMsgDTO();
        accountMsgDTO.setMsgId(accountId+"-1-"+System.currentTimeMillis());
        accountMsgDTO.setOperationType(1);
        accountMsgDTO.setAccountId(accountId);
        rocketMQTemplate.convertAndSend(topic, accountMsgDTO);
    }

    public void remove(Long accountId) {
        AccountMsgDTO accountMsgDTO = new AccountMsgDTO();
        accountMsgDTO.setMsgId(accountId+"-0-"+System.currentTimeMillis());
        accountMsgDTO.setOperationType(0);
        accountMsgDTO.setAccountId(accountId);
        rocketMQTemplate.convertAndSend(topic, accountMsgDTO);
    }
}
