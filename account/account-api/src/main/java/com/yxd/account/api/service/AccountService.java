package com.yxd.account.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "account", url = "localhost:9003")
public interface AccountService {
    /**
     * 从用户账户中借出
     */
    @GetMapping("debit")
    void debit(@RequestParam("userId") String userId,
               @RequestParam("money") int money);
}
