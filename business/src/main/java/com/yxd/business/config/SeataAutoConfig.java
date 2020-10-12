package com.yxd.business.config;

import com.yxd.business.filter.SeataXidFilter;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: heshouyou
 * @Description  seata global configuration
 * @Date Created in 2019/1/24 10:28
 */
@Configuration
public class SeataAutoConfig {
    /**
     * 初始化seataXid过滤器
     *
     * @return
     * @author sly
     * @time 2019年6月12日
     */
    @Bean
    public SeataXidFilter fescarXidFilter() {
        return new SeataXidFilter();
    }
}
