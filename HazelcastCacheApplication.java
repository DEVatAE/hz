package com.example.hazelcastcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HazelcastCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(HazelcastCacheApplication.class, args);
    }
}
