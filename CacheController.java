package com.example.hazelcastcache.controller;

import com.example.hazelcastcache.service.CacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/{key}")
    public String getValue(@PathVariable String key) {
        return cacheService.getCachedValue(key);
    }
}
