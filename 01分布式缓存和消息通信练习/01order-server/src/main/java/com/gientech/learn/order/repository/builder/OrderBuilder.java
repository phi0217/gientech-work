package com.gientech.learn.order.repository.builder;

import com.gientech.learn.order.dataobj.OrderDO;
import com.gientech.learn.order.domain.Order;
import org.springframework.beans.BeanUtils;

/**
 * @author xiefei
 * @date 2023/03/06
 */
public class OrderBuilder {
    public static OrderDO fromOrder(Order order){
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(order,orderDO);
        return orderDO;
    }

    public static Order toOrder(OrderDO orderDO){
        Order order = new Order();
        BeanUtils.copyProperties(orderDO,order);
        return order;
    }
}
