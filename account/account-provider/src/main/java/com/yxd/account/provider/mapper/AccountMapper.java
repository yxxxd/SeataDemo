package com.yxd.account.provider.mapper;

import com.yxd.account.provider.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountMapper {

    @Select("SELECT * FROM account_tbl WHERE user_id = #{userId}")
    Account selectOne(@Param("userId") String userId);

    @Update("UPDATE account_tbl SET `money` = #{money} WHERE user_id = #{userId}")
    int update(@Param("userId") String userId, @Param("money") Integer money);
}
