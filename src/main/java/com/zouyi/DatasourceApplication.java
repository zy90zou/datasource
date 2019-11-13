package com.zouyi;

import com.zouyi.test.config.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.zouyi.test.mapper")
@Import({DynamicDataSourceConfig.class})
public class DatasourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatasourceApplication.class, args);
    }

}
