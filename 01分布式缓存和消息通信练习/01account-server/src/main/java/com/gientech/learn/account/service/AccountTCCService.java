package com.gientech.learn.account.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author : XieFei
 */
@LocalTCC
public interface AccountTCCService {
    @TwoPhaseBusinessAction(name = "pointAdd", commitMethod = "commitPointAdd", rollbackMethod = "rollbackPointAdd")
    boolean pointAdd(Long id);

    boolean commitPointAdd(BusinessActionContext businessActionContext);

    boolean rollbackPointAdd(BusinessActionContext businessActionContext);
}
