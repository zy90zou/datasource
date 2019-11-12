package com.zouyi.dynamicDataSource;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: 邹义(Dimo)
 * @date: 2019/11/12
 * @Description:
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DataSourceConfigure.class)
public @interface EnableDynamicDataSource {
}
