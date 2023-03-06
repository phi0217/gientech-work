package com.gientech.learn.order.repository;

import com.gientech.learn.order.dataobj.OrderDO;
import com.gientech.learn.order.domain.Order;
import com.gientech.learn.order.mapper.OrderMapper;
import com.gientech.learn.order.repository.builder.OrderBuilder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author xiefei
 * @date 2023/03/06
 */
@Repository
public class OrderRepository {
    @Resource
    private OrderMapper orderMapper;

    public Order save(Order order){
        OrderDO orderDO = OrderBuilder.fromOrder(order);
        if (order.getId()==null){
            orderMapper.insert(orderDO);
        } else {
            orderMapper.updateById(orderDO);
        }
        return OrderBuilder.toOrder(orderDO);
    }
}
