package com.example.hazelcastCache.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseService {

    private final Map<String, String> database = new HashMap<>();

    public DatabaseService() {
        database.put("test", "test from DB");
        database.put("zhi", "zhi from DB");
    }

    public String getFromDatabase(String key) {
        return database.get(key);
    }
}
