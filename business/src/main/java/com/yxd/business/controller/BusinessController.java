package com.yxd.business.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.yxd.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @GetMapping("purchase")
    public R<Object> purchase(@RequestParam("userId") String userId,
                              @RequestParam("commodityCode") String commodityCode,
                              @RequestParam("orderCount") int orderCount) {
        businessService.purchase(userId, commodityCode, orderCount);
        return R.ok("购买成功");
    }
}
