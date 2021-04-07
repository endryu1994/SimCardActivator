package com.akybenko.activation.task;

import static com.akybenko.activation.Constants.STATUS_CODE_WS_OK;
import static com.akybenko.activation.task.TestData.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SimPreActivateTaskTest extends AbstractTaskTest {

    @InjectMocks
    private SimPreActivateTask task;

    @Before
    public void setUp() {
        when(webService.getSimPreActivateResponse(any())).thenReturn(getResponse(STATUS_CODE_WS_OK));
    }

    @Test
    public void testExecute_whenResponseIsNotNullAndRequestHasNotEmptyData() {
        when(execution.getVariable(any())).thenReturn(getSimActivateRequest());
        task.execute(execution);
    }

    @Test
    public void testExecute_whenResponseIsNotNullAndRequestHasEmptyData() {
        when(execution.getVariable(any())).thenReturn(getSimActivateRequestWithEmptyData());
        task.execute(execution);
    }

    @Test
    public void testExecute_whenResponseIsNotNullAndRequestHasNullData() {
        when(execution.getVariable(any())).thenReturn(getSimActivateRequestWithNullData());
        task.execute(execution);
    }
}
