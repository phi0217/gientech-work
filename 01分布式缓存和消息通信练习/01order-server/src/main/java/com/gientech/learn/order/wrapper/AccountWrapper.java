package com.gientech.learn.order.wrapper;

import com.gientech.learn.account.api.AccountApi;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xiefei
 * @date 2023/03/05
 */
@Component
public class AccountWrapper {
    @Resource
    private AccountApi accountApi;

    public boolean find(Long accountId){
        return accountApi.validate(accountId);
    }
}
