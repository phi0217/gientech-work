package com.gientech.learn.order.service;

/**
 * @author xiefei
 * @date 2023/03/05
 */
public interface AccountService {
    boolean validate(Long accountId);

    void add(Long accountId);

    void remove(Long accountId);
}
