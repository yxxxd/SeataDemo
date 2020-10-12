package com.yxd.storage.provider.service;

import com.yxd.storage.api.service.StorageService;
import com.yxd.storage.provider.mapper.StorageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageServiceImpl implements StorageService {
    private static final Logger log = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageMapper storageMapper;

    @Transactional
    @Override
    public void deduct(String commodityCode, int count) {
        Integer storageCount = storageMapper.count(commodityCode);
        if (storageCount == null) {
            throw new RuntimeException("不存在的商品");
        }

        System.out.println("商品库存：" + storageCount);
        if (storageCount >= count) {
//            log.info("更新商品库存：{} --> {}", storageCount, storageCount-count);
            System.out.println("更新商品库存：" + storageCount + " --> " + (storageCount-count));
            storageMapper.update(commodityCode, storageCount-count);
//            log.info("更新库存成功");
            System.out.println("更新库存成功");
        } else {
            throw new RuntimeException("库存不足");
        }
    }
}
