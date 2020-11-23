package com.project.FlightJDBC.config;

import java.util.HashMap;
import java.util.Map;
/*import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Configurable;
import org.redisson.spring.cache.CacheConfig;
import org.springframework.context.annotation.Bean;*/

/**
 *
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
//@Configurable
public class ConfigRedis {

    /*//@Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }

    //@Bean
    public RedissonSpringCacheManager cacheManager(RedissonClient redissonClient) {

        Map<String, CacheConfig> config = new HashMap<>();
        // create "testMap" cache with ttl = 24 minutes and maxIdleTime = 12 minutes
        config.put("testMap", new CacheConfig(24*60*1000, 12*60*1000));    
        return new RedissonSpringCacheManager(redissonClient,config);
    }*/
}
