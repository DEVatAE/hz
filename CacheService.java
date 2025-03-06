package com.example.hazelcastCache.service;

import com.hazelcast.map.IMap;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {
    private final IMap<String, String> cache;
    private final DatabaseService databaseService;

    public CacheService(HazelcastInstance hazelcastInstance, DatabaseService databaseService) {
        this.cache = hazelcastInstance.getMap("cache");
        this.databaseService = databaseService;
    }

    public void populateInfo(String key, String value) {
        cache.set(key, value);
    }

    public String getInfo(String key) {

        String cachedValue = cache.get(key);
        if (cachedValue != null) {
            return "From Hazelcast Cache: " + cachedValue;
        }


        String dbValue = databaseService.getFromDatabase(key);


        if (dbValue != null) {
            cache.set(key, dbValue);
            return "From Database (Now Cached): " + dbValue;
        }

        return "Data not found";
    }
}
