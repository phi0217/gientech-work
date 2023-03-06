package com.gientech.learn.account.controller;

import com.gientech.learn.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiefei
 * @date 2023/03/06
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/add/{accountId}")
    public void add(@PathVariable Long accountId){
        accountService.add(accountId);
    }

    @GetMapping("/remove/{accountId}")
    public void remove(@PathVariable Long accountId){
        accountService.remove(accountId);
    }
}
