package com.zouyi.dynamicDataSource.aspect;


import com.zouyi.dynamicDataSource.annotation.DataSource;
import com.zouyi.dynamicDataSource.bean.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: 邹义(Dimo)
 * @date: 2019/11/12
 * @Description:多数据源，切面处理类 处理带有注解的方法类
 **/
@Aspect
@Component
@Slf4j
public class DataSourceAspect implements Ordered {

    @Pointcut("@annotation(com.zouyi.dynamicDataSource.annotation.DataSource)")//注意：这里的xxxx代表的是上面public @interface DataSource这个注解DataSource的包名
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);
        if(null != ds)  {
            DynamicDataSource.setDataSource(ds.name());
            log.debug("Switch dataSource to" + ds.name());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            log.debug("clean dataSource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

