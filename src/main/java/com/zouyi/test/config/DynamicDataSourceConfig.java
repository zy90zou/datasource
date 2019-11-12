package com.zouyi.test.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.zouyi.dynamicDataSource.EnableDynamicDataSource;
import com.zouyi.dynamicDataSource.bean.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 邹义(Dimo)
 * @date: 2019/11/12
 * @Description:
 **/
@Configuration
@EnableDynamicDataSource//启用动态数组源组件
public class DynamicDataSourceConfig {
    @Bean(DataSourceName.TEST1)
    @ConfigurationProperties("spring.datasource.druid.test1")
    public DataSource test1DataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(DataSourceName.TEST2)
    @ConfigurationProperties("spring.datasource.druid.test2")
    public DataSource test2DataSource(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    public DynamicDataSource dataSource(
            @Autowired @Qualifier(DataSourceName.TEST1) DataSource test1DataSource,
            @Autowired @Qualifier(DataSourceName.TEST2) DataSource test2DataSource
    ) {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceName.TEST1, test1DataSource);
        targetDataSources.put(DataSourceName.TEST2, test2DataSource);
        return new DynamicDataSource(test1DataSource, targetDataSources);
    }
}

