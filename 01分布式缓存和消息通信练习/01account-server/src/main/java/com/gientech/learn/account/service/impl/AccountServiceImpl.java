package com.gientech.learn.account.service.impl;

import com.gientech.learn.account.api.AccountApi;
import com.gientech.learn.account.repository.AccountRepository;
import com.gientech.learn.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author xiefei
 * @date 2023/03/05
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountApi, AccountService {
    @Resource
    private AccountRepository accountRepository;

    @Override
    public boolean validate(Long accountId) {
        Optional.ofNullable(accountId).orElseThrow(() -> {
            log.error("需要accountId");
            throw new RuntimeException("需要accountId");
        });
        return accountRepository.hasAccount(accountId);
    }

    @Override
    public void add(Long accountId) {
        accountRepository.add(accountId);
        // TODO: 2023/3/6 mq通信
    }

    @Override
    public void remove(Long accountId) {
        accountRepository.delete(accountId);
        // TODO: 2023/3/6 mq通信
    }
}
