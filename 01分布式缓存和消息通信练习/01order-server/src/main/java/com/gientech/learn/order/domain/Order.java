package com.gientech.learn.order.domain;

import lombok.Data;

/**
 * @author xiefei
 * @date 2023/03/05
 */
@Data
public class Order {
    private Long id;
    private Long accountId;
    private Integer orderType;

    public static Order init(Long accountId){
        Order order = new Order();
        order.setAccountId( accountId );
        order.setOrderType(1);
        return order;
    }
}
