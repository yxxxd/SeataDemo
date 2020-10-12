package com.yxd.order.api.service;

import com.yxd.order.api.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "order", url = "localhost:9002")
public interface OrderService {

    /**
     * 创建订单
     */
    @GetMapping("create")
    OrderDTO create(@RequestParam("userId") String userId,
                 @RequestParam("commodityCode") String commodityCode,
                 @RequestParam("orderCount") int orderCount);
}
