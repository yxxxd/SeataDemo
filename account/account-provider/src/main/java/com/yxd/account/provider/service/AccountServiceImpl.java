package com.yxd.account.provider.service;


import com.yxd.account.api.service.AccountService;
import com.yxd.account.provider.entity.Account;
import com.yxd.account.provider.mapper.AccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountServiceImpl implements AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void debit(String userId, int money) {
        Account account = new Account();
        Account a = accountMapper.selectOne(userId);
        if (a.getMoney() >= money) {
            System.out.println("【before】扣款 " + a.getMoney() + "--> " + money);
            accountMapper.update(userId, a.getMoney()-money);
            System.out.println("【after】扣款成功");
        } else {
            throw new RuntimeException("账户余额不足");
        }
    }
}
