package com.coketea.dt.example.interceptor;

import com.coketea.dt.agent.interceptor.dubbo.DTTransactionManagerInterceptor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DTTransactionManager implements Ordered {

    static final Logger logger = LoggerFactory.getLogger(DTTransactionManager.class);

    @Override
    public int getOrder() {
        return 1;
    }

    @Autowired
    private DTTransactionManagerInterceptor transactionManagerInterceptor;

    @Around("execution(* com.coketea.dt.example.*.service.impl.*Impl.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        logger.info("start transaction");
        Object ret = transactionManagerInterceptor.around(point);
        logger.info("end transaction");
        return ret;
    }
}
