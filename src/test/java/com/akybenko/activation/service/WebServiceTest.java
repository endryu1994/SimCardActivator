package com.akybenko.activation.service;

import static com.akybenko.activation.Constants.STATUS_CODE_WS_OK;
import static com.akybenko.activation.service.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.akybenko.activation.ApplicationProperties;
import com.akybenko.activation.model.ws.server.Response;
import com.akybenko.activation.service.impl.WebServiceImpl;

@RunWith(SpringRunner.class)
public class WebServiceTest {

    @Mock
    private WebServiceTemplate webServiceTemplate;

    @Mock
    private ApplicationProperties properties;

    @InjectMocks
    private WebServiceImpl service;

    @Before
    public void setUp() {
        when(webServiceTemplate.marshalSendAndReceive(any(), any(), any())).thenReturn(getResponse(STATUS_CODE_WS_OK));
    }

    @Test
    public void testGetSimPreActivateResponse_shouldReturnResponse_whenSimActivateRequestIsNotNull() {
        Response actual = service.getSimPreActivateResponse(getSimActivateRequest());
        check(actual);
    }

    @Test
    public void testGetSpsCreateSimResponse_shouldReturnResponse_whenSimActivateRequestIsNotNull() {
        Response actual = service.getSpsCreateSimResponse(getSimActivateRequest());
        check(actual);
    }

    private void check(Response actual) {
        assertThat(actual, notNullValue());
        assertThat(actual.getResponseHeader(), notNullValue());
        assertThat(actual.getResponseParameters(), nullValue());
        assertThat(actual.getResponseHeader(), allOf(
                hasProperty("type", equalTo(TYPE_VALUE)),
                hasProperty("order", equalTo(ORDER_VALUE)),
                hasProperty("priority", equalTo(PRIORITY_VALUE)),
                hasProperty("user", equalTo(USER_VALUE)),
                hasProperty("status", equalTo(STATUS_CODE_WS_OK))));
    }
}
