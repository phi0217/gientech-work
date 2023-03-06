package com.gientech.learn.order.service.impl;

import com.gientech.learn.order.domain.Order;
import com.gientech.learn.order.repository.OrderRepository;
import com.gientech.learn.order.service.AccountService;
import com.gientech.learn.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiefei
 * @date 2023/03/05
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private AccountService accountService;
    @Resource
    private OrderRepository orderRepository;

    @Override
    public void create(Long accountId) {
        boolean validateAccount = accountService.validate(accountId);
        if (!validateAccount){
            log.error(String.format("非法账户，accountId %d",accountId));
            throw new RuntimeException(String.format("非法账户，accountId %d",accountId));
        }
        orderRepository.save(Order.init(accountId));
    }
}
