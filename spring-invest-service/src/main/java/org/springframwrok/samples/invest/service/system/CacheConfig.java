package org.springframwrok.samples.invest.service.system;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

 
@Configuration
@EnableCaching
@Profile("production")
class CacheConfig {
}
