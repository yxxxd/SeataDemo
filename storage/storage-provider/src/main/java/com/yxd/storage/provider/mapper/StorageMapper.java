package com.yxd.storage.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageMapper {
    @Select("SELECT `count` FROM storage_tbl WHERE commodity_code = #{commodityCode}")
    Integer count(@Param("commodityCode") String commodityCode);

    @Update("UPDATE storage_tbl SET `count` = #{count} WHERE commodity_code = #{commodityCode}")
    int update(@Param("commodityCode") String commodityCode, @Param("count") int count);
}
