package com.zouyi.dynamicDataSource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 邹义(Dimo)
 * @date: 2019/11/12
 * @Description:
 **/
@Configuration
@ComponentScan({"com.zouyi.dynamicDataSource.aspect", "com.zouyi.dynamicDataSource.bean"})
public class DataSourceConfigure {
}
