package com.gientech.learn.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gientech.learn.order.dataobj.AccountDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiefei
 * @date 2023/03/06
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountDO> {
}
