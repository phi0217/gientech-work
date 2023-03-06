package com.gientech.learn.order.repository;

import com.gientech.learn.order.dataobj.AccountDO;
import com.gientech.learn.order.mapper.AccountMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author xiefei
 * @date 2023/03/06
 */
@Repository
public class AccountRepository {
    @Resource
    private AccountMapper accountMapper;

    public boolean hasAccount(Long accountId) {
        AccountDO accountDO = accountMapper.selectById(accountId);
        return accountDO != null;
    }

    public void add(Long accountId){
        if (!hasAccount(accountId)){
            AccountDO accountDO = new AccountDO();
            accountDO.setId(accountId);
            accountMapper.insert(accountDO);
        }
    }

    public void delete(Long accountId){
        if (hasAccount(accountId)){
            accountMapper.deleteById(accountId);
        }
    }
}
