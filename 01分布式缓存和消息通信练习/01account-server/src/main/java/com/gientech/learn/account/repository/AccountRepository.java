package com.gientech.learn.account.repository;


import com.gientech.learn.account.dataobj.AccountDO;
import com.gientech.learn.account.mapper.AccountMapper;
import com.gientech.learn.account.wrapper.AccountWrapper;
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
    @Resource
    private AccountWrapper accountWrapper;

    public boolean hasAccount(Long accountId) {
        AccountDO accountDO = accountMapper.selectById(accountId);
        return accountDO != null;
    }

    public void add(Long accountId){
        if (!hasAccount(accountId)){
            AccountDO accountDO = new AccountDO();
            accountDO.setId(accountId);
            accountMapper.insert(accountDO);
            accountWrapper.add(accountId);
        }
    }

    public void delete(Long accountId){
        if (hasAccount(accountId)){
            accountMapper.deleteById(accountId);
            accountWrapper.remove(accountId);
        }
    }
}
