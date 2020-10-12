package com.yxd.business.service.impl;

import com.yxd.business.service.BusinessService;
import com.yxd.order.api.service.OrderService;
import com.yxd.storage.api.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    private static final Logger log = LoggerFactory.getLogger(BusinessServiceImpl.class);

    @Autowired
    private StorageService storageService;
    @Autowired
    private OrderService orderService;

    /**
     * 采购
     */
    @GlobalTransactional
    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {

        System.out.println("【before】 减库存");
        storageService.deduct(commodityCode, orderCount);

        System.out.println("【after】 减库存成功");


        System.out.println("【before】 创建订单");
        orderService.create(userId, commodityCode, orderCount);

        System.out.println("【after】创建订单成功");
    }
}
