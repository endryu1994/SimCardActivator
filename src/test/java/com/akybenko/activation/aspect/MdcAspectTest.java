package com.akybenko.activation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MdcAspectTest {

    private static final String ORDER_VALUE = "9155901180513467490";

    @Mock
    private ProceedingJoinPoint joinPoint;

    @Mock
    private DelegateExecution execution;

    @InjectMocks
    private MdcAspect aspect;

    @Test
    public void testAddBusinessKey_shouldProceed_whenJoinPointIsNotNullAndExecutionIsNotNull() throws Throwable {
        aspect.addBusinessKey(joinPoint, execution);
    }

    @Test
    public void testAddBusinessKey_shouldProceed_whenJoinPointIsNotNullAndOrderIsNotNull() throws Throwable {
        aspect.addBusinessKey(joinPoint, ORDER_VALUE);
    }
}
