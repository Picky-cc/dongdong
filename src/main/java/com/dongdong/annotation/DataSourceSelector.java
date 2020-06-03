package com.dongdong.annotation;

import com.dongdong.config.DynamicDateSourceEnum;

import java.lang.annotation.*;

/**
 * @author zhaodexu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSourceSelector {

    DynamicDateSourceEnum value() default DynamicDateSourceEnum.MASTER;
    boolean clear() default true;
}
