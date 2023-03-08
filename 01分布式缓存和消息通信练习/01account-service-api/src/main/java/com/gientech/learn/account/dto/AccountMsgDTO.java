package com.gientech.learn.account.dto;

import lombok.Data;

/**
 * @author xiefei
 * @date 2023/03/08
 */
@Data
public class AccountMsgDTO {
    /**
     * 消息唯一id，用作幂等校验
     */
    private String msgId;
    /**
     * 0，删除；1、添加
     */
    private Integer operationType;
    private Long accountId;
}
