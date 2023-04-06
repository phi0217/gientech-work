package com.gientech.learn.account.dataobj;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author xiefei
 * @date 2023/03/06
 */
@Data
public class AccountDO {
    @TableId
    private Long id;

    private Long point;
}
