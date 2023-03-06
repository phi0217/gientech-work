package com.gientech.learn.account.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xiefei
 * @date 2023/03/06
 */

@FeignClient(name="account-server", url ="/account")
public interface AccountApi {
    @GetMapping("/validate")
    boolean validate(Long accountId);
}
