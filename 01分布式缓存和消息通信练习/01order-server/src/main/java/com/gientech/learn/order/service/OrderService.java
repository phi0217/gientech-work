package com.gientech.learn.order.service;

/**
 * @author xiefei
 * @date 2023/03/05
 */
public interface OrderService {
    void create(Long accountId);

    void newOrder(Long accountId);
}
