package com.example.hazelcastcache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @Cacheable(value = "my-cache", key = "#key")
    public String getCachedValue(String key) {
        simulateSlowService();
        return "Value for key: " + key;
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000); // 模拟耗时计算
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
