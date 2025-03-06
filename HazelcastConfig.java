package com.example.hazelcastCache.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean(name = "hazelcastCustomConfig")
    public Config hazelcastConfig() {
        return new Config()
                .setClusterName("hazelcast-cluster")
                .addMapConfig(new MapConfig()
                        .setName("cache-map")
                        .setTimeToLiveSeconds(30));
    }

    @Bean
    public HazelcastInstance hazelcastInstance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }
}
