package com.yxd.storage.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "storage", url = "localhost:9005")
public interface StorageService {

    /**
     * 扣除存储数量
     */
    @GetMapping("debuct")
    void deduct(@RequestParam("commodityCode") String commodityCode,
                @RequestParam("count") int count);
}
