package com.gientech.learn.order.service;

import com.gientech.learn.order.dataobj.OrderDO;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author : XieFei
 */
@LocalTCC
public interface OrderTCCService {
    @TwoPhaseBusinessAction(name = "createOrder", commitMethod = "commitOrder", rollbackMethod = "rollbackOrder")
    public boolean createOrder(Long accountId);

    public boolean commitOrder(BusinessActionContext businessActionContext);

    public boolean rollbackOrder(BusinessActionContext businessActionContext);
}
