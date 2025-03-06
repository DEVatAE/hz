package com.example.hazelcastCache.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.TcpIpConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class HazelcastConfig {

    @Bean(name = "hazelcastCustomConfig")
    public Config hazelcastConfig() {
        Config config = new Config()
                .setClusterName("hazelcast-cluster")
                .addMapConfig(new MapConfig()
                        .setName("cache-map")
                        .setTimeToLiveSeconds(30));

        NetworkConfig networkConfig = config.getNetworkConfig();
        JoinConfig joinConfig = networkConfig.getJoin();

        joinConfig.getMulticastConfig().setEnabled(false);
        TcpIpConfig tcpIpConfig = joinConfig.getTcpIpConfig();
        tcpIpConfig.setEnabled(true)
                .setMembers(Arrays.asList(
                        "127.0.0.1:5701",
                        "127.0.0.1:5702"
                ));

        return config;
    }

    @Bean
    public HazelcastInstance hazelcastInstance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }
}
