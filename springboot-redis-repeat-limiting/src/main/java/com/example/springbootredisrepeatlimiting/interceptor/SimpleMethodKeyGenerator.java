package com.example.springbootredisrepeatlimiting.interceptor;

import com.example.springbootredisrepeatlimiting.annotation.CacheLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.StringJoiner;

/**
 * @author Una Ma
 * @className SimpleMethodKeyGenerator
 * @description
 * @date 2020/1/19 5:27 下午
 **/
public class SimpleMethodKeyGenerator implements CacheKeyGenerator {

    /**
     * 获取AOP参数,生成指定缓存Key
     *
     * @param pjp PJP
     * @return 缓存KEY
     */
    @Override
    public String getLockKey(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        CacheLock lockAnnotation = method.getAnnotation(CacheLock.class);
        StringJoiner joiner = new StringJoiner(",");
        final Object[] params = pjp.getArgs();
        for (Object param : params) {
            joiner.add(param.getClass().getName());
        }
        return pjp.getTarget().getClass().getName().concat(lockAnnotation.delimiter()).concat(method.getName()).concat(lockAnnotation.delimiter())
                .concat(joiner.toString());
    }

}
