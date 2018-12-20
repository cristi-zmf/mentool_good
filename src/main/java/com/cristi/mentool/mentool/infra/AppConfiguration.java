package com.cristi.mentool.mentool.infra;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = AppConfiguration.BASE_PACKAGES)
@ComponentScan(basePackages = AppConfiguration.BASE_PACKAGES)
public class AppConfiguration {
    static final String BASE_PACKAGES = "com.cristi.mentool.mentool";
}
