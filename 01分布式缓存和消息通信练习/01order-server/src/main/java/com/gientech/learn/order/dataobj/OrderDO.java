package com.gientech.learn.order.dataobj;

import lombok.Data;

/**
 * @author xiefei
 * @date 2023/03/06
 */
@Data
public class OrderDO {
    private Long id;
    private Long accountId;
    private Integer orderType;
}
