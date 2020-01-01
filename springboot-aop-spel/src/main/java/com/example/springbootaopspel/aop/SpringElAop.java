package com.example.springbootaopspel.aop;

import com.example.springbootaopspel.annotation.SpelLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;


/**
 * spel aop实现
 *
 * @author maxiucheng
 * @date 2020/01/01 12:22:24
 */
@Aspect
@Slf4j
@Component
public class SpringElAop {


    @Autowired
    @Qualifier("applicationTaskExecutor")
    private Executor executor;

    @Pointcut("@annotation(spelLog)")
    public void springElAop(SpelLog spelLog) {
    }

    @Around("springElAop(spelLog)")
    public Object ar(ProceedingJoinPoint point ,SpelLog spelLog) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();

        executor.execute(() -> {
            if (spelLog != null) {
                EvaluationContext context = getContext(point.getArgs(), signature.getMethod());
                String value = getValue(context, spelLog.value(), String.class);
                if (log.isInfoEnabled()) {
                    log.info(" SpelLog {}", value);
                }
            }
        });

        return point.proceed();
    }

    /**
     * 获取spel 定义的参数值
     *
     * @param context 参数容器
     * @param key     key
     * @param clazz   需要返回的类型
     * @param <T>     返回泛型
     * @return 参数值
     */
    private <T> T getValue(EvaluationContext context, String key, Class<T> clazz) {
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression expression = spelExpressionParser.parseExpression(key);
        return expression.getValue(context, clazz);
    }

    /**
     * 获取参数容器
     *
     * @param arguments       方法的参数列表
     * @param signatureMethod 被执行的方法体
     * @return 装载参数的容器
     */
    private EvaluationContext getContext(Object[] arguments, Method signatureMethod) {

        String[] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(signatureMethod);
        if (parameterNames == null) {
            throw new RuntimeException("参数列表不能为null");
        }

        EvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < arguments.length; i++) {
            context.setVariable(parameterNames[i], arguments[i]);
        }
        return context;
    }

}