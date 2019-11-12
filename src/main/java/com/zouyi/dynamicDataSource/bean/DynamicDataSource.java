package com.zouyi.dynamicDataSource.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 邹义(Dimo)
 * @date: 2019/11/12
 * @Description:
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
    //用来保存数据源与获取数据源
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public DynamicDataSource(javax.sql.DataSource defaultTargetDataSource, Map<String, javax.sql.DataSource> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(new HashMap<Object, Object>(targetDataSources));
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }

}

