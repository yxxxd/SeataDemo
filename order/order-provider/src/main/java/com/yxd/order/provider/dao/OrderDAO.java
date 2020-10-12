package com.yxd.order.provider.dao;

import com.yxd.order.api.dto.OrderDTO;
import com.yxd.order.provider.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface OrderDAO {

    @Insert("INSERT INTO order_tbl (user_id, commodity_code, `count`, `money`) VALUES (#{order.userId}, #{order.commodityCode}, #{order.count}, #{order.money})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "order.id", before = false, resultType = int.class)
    int insert(@Param("order") Order order);
}
