package org.geon.study.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@PropertySources({
        @PropertySource(value = "src/main/resources/application.properties", ignoreResourceNotFound = true),
//        @PropertySource(value = "file:d:/application-dbinfo.yml",factory = YamlLoadFactory.class, ignoreResourceNotFound = true),
        @PropertySource(value = "file:/home/username/.koyeb.yaml",factory = YamlLoadFactory.class, ignoreResourceNotFound = true)
})
@Getter
@Setter
public class GlobalPropertySources {

    private String driverClassName;

    private String url;

    private String username;

    private String password;

}
