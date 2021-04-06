package com.akybenko.activation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MdcAspect {

    private static final String PROCESS_BUSINESS_KEY_FIELD_NAME = "processBusinessKey";

    @Around("execution(* execute(..)) && args(execution)")
    public Object addBusinessKey(ProceedingJoinPoint joinPoint, DelegateExecution execution) throws Throwable {
        return proceed(joinPoint, execution.getBusinessKey());
    }

    @Around("execution(* com.akybenko.activation.service.NotificationService.execute(..)) && args(order)")
    public Object addBusinessKey(ProceedingJoinPoint joinPoint, String order) throws Throwable {
        return proceed(joinPoint, order);
    }

    private Object proceed(ProceedingJoinPoint joinPoint, String businessKey) throws Throwable {
        try {
            MDC.put(PROCESS_BUSINESS_KEY_FIELD_NAME, businessKey);
            return joinPoint.proceed();
        } finally {
            MDC.remove(PROCESS_BUSINESS_KEY_FIELD_NAME);
        }
    }
}
