package com.yxd.order.provider.service;

import com.yxd.account.api.service.AccountService;
import com.yxd.order.api.dto.OrderDTO;
import com.yxd.order.api.service.OrderService;
import com.yxd.order.provider.dao.OrderDAO;
import com.yxd.order.provider.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private OrderDAO orderDAO;

    @Override
    public OrderDTO create(String userId, String commodityCode, int orderCount) {
        int orderMoney = calculate(commodityCode, orderCount);

//        log.info("【before】扣款  userId:{}, orderMoney:{}", userId, orderMoney);
        System.out.println("【before】扣款  userId:" + userId + " orderMoney:" + orderMoney);
        accountService.debit(userId, orderMoney);
//        log.info("【after】扣款成功");
        System.out.println("【after】扣款成功");
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);
//        log.info("【before】创建订单 {}", order.toString());
        System.out.println("【before】创建订单 " + order.toString());
//        order.insert();
        orderDAO.insert(order);
//        log.info("【after】创建订单成功 {}", order.toString());
        System.out.println("【after】创建订单成功 " + order.toString());
        OrderDTO orderDTO = new OrderDTO();
        if (orderCount == 2) {
            throw new RuntimeException("未知异常");
        }
        BeanUtils.copyProperties(order, orderDTO);
        return orderDTO;
    }


    private int calculate(String commodityCode, int orderCount) {
        return orderCount*10;
    }
}
