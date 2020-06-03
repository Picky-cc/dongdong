package com.dongdong.aspect;

import com.dongdong.annotation.DataSourceSelector;
import com.dongdong.config.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhaodexu
 */
@Slf4j
@Component
@Order(value = 1)
@Aspect
public class DataSourceContextAop {

    @Around("@annotation(com.dongdong.annotation.DataSourceSelector)")
    public Object setDynamicDataSource(ProceedingJoinPoint pjp) throws Throwable{
        boolean clear = true;
        try {
            Method method = this.getMethod(pjp);
            DataSourceSelector dataSourceAnnotation = method.getAnnotation(DataSourceSelector.class);
            clear = dataSourceAnnotation.clear();
            DataSourceContextHolder.set(dataSourceAnnotation.value().getDateSourceName());
            log.info("----------------数据源切换至: {}----------------", dataSourceAnnotation.value().getDateSourceName());
            return pjp.proceed();
        } finally {
            if (clear) {
                DataSourceContextHolder.clear();
            }
        }
    }

    private Method getMethod(JoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        return signature.getMethod();
    }
}
