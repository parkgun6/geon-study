package org.geon.study.common.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@Log4j2
@EnableAspectJAutoProxy
public class CommonConfig {

    @Bean
    public String test() {
        log.info("common config.................");
        return "common config";
    }

    // DB.........
}
