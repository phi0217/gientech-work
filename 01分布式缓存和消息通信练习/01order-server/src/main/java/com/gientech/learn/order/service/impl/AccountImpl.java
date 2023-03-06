package com.gientech.learn.order.service.impl;

import com.gientech.learn.order.wrapper.AccountWrapper;
import com.gientech.learn.order.repository.AccountRepository;
import com.gientech.learn.order.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author xiefei
 * @date 2023/03/05
 */
@Slf4j
@Service
public class AccountImpl implements AccountService {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private AccountWrapper                accountWrapper;
    @Resource
    private AccountRepository             accountRepository;

    @Override
    public boolean validate(Long accountId) {
        Optional.ofNullable(accountId).orElseThrow(() -> {
            log.error("需要accountId");
            throw new RuntimeException("需要accountId");
        });
        //查询分布式缓存
        boolean hasKey = redisTemplate.hasKey(accountId + "");
        if (hasKey) {
            return true;
        }
        //查询本地数据库
        if (accountRepository.hasAccount(accountId)) {
            return true;
        }
        // 查询账户服务
        boolean hasAccount = accountWrapper.find(accountId);
        if (!hasAccount) {
            return false;
        }
        return true;
    }

    @Override
    public void add(Long accountId) {
        boolean hasKey = redisTemplate.hasKey(accountId + "");
        if (!hasKey) {
            redisTemplate.opsForValue().set(accountId + "", "");
        }
        accountRepository.add(accountId);
    }

    @Override
    public void remove(Long accountId) {
        boolean hasKey = redisTemplate.hasKey(accountId + "");
        if (hasKey) {
            redisTemplate.delete(accountId + "");
        }
        accountRepository.delete(accountId);
    }
}
