package com.example.hazelcastCache.controller;

import com.example.hazelcastCache.service.CacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {
    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/populate")
    public String populate(@RequestParam String key, @RequestParam String value) {
        cacheService.populateInfo(key, value);
        return "Data populated in cache: " + key;
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        return cacheService.getInfo(key);
    }
}
