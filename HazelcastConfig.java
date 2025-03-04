package com.example.hazelcastcache.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean
    public Config hazelcastConfig1() {
        return new Config()
                .setClusterName("dev-cluster")
                .addMapConfig(new MapConfig()
                        .setName("my-cache")
                        .setTimeToLiveSeconds(300)); // 5分钟后过期
    }
}
