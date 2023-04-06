package com.gientech.learn.order.service.impl;

import com.gientech.learn.account.api.AccountApi;
import com.gientech.learn.order.dataobj.OrderDO;
import com.gientech.learn.order.domain.Order;
import com.gientech.learn.order.repository.OrderRepository;
import com.gientech.learn.order.service.AccountService;
import com.gientech.learn.order.service.OrderService;
import com.gientech.learn.order.service.OrderTCCService;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
    @Resource
    private OrderTCCService orderTCCService;
    @Resource
    private AccountApi accountApi;

    @Override
    public void create(Long accountId) {
        boolean validateAccount = accountService.validate(accountId);
        if (!validateAccount){
            log.error(String.format("非法账户，accountId %d",accountId));
            throw new RuntimeException(String.format("非法账户，accountId %d",accountId));
        }
        orderRepository.save(Order.init(accountId));
    }

    @GlobalTransactional
    @Override
    public void newOrder(Long accountId) {
        log.info("------->分布式操作开始");
        String xid = System.currentTimeMillis() + "";
        BusinessActionContext actionContext = new BusinessActionContext();
        actionContext.setXid(xid);
        orderTCCService.createOrder(accountId);
        accountApi.pointAdd(accountId);
    }
}
