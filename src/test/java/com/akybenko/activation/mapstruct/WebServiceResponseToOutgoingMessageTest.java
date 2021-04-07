package com.akybenko.activation.mapstruct;

import static com.akybenko.activation.Constants.ACTIVATE;
import static com.akybenko.activation.Constants.STATUS_CODE_WS_OK;
import static com.akybenko.activation.mapstruct.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.akybenko.activation.model.OutgoingMessage;

@RunWith(SpringRunner.class)
public class WebServiceResponseToOutgoingMessageTest {

    private WebServiceResponseToOutgoingMessage mapper;

    @Before
    public void setUp() {
        mapper = WebServiceResponseToOutgoingMessage.INSTANCE;
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNull_whenStepIsNullAndResponseIsNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(null, null);
        assertThat(actual, nullValue());
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNotNullAndResponseIsNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(ACTIVATE, null);
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("step", equalTo(ACTIVATE)),
                hasProperty("order", nullValue()),
                hasProperty("status", nullValue())));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNullAndResponseIsNotNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(null, EMPTY_RESPONSE);
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("step", nullValue()),
                hasProperty("order", nullValue()),
                hasProperty("status", nullValue())));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNotNullAndResponseIsNotNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(ACTIVATE, EMPTY_RESPONSE);
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("step", equalTo(ACTIVATE)),
                hasProperty("order", nullValue()),
                hasProperty("status", nullValue())));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNotNullAndResponseHeaderIsEmpty() {
        OutgoingMessage actual = mapper.getOutgoingMessage(ACTIVATE, getResponseWithEmptyResponseHeader());
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("step", equalTo(ACTIVATE)),
                hasProperty("order", nullValue()),
                hasProperty("status", nullValue())));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNotNullAndResponseHeaderIsNotEmpty() {
        OutgoingMessage actual = mapper.getOutgoingMessage(ACTIVATE, getResponseWithNotEmptyResponseHeader());
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("step", equalTo(ACTIVATE)),
                hasProperty("order", equalTo(ORDER_VALUE)),
                hasProperty("status", equalTo(STATUS_CODE_WS_OK))));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNull_whenStepIsNullAndOrderIsNullAndStatusIsNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(null, null, null);
        assertThat(actual, nullValue());
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNotNullAndOrderIsNullAndStatusIsNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(ACTIVATE, null, null);
        assertThat(actual, allOf(
                hasProperty("step", equalTo(ACTIVATE)),
                hasProperty("order", nullValue()),
                hasProperty("status", nullValue())));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNullAndOrderIsNotNullAndStatusIsNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(null, ORDER_VALUE, null);
        assertThat(actual, allOf(
                hasProperty("step", nullValue()),
                hasProperty("order", equalTo(ORDER_VALUE)),
                hasProperty("status", nullValue())));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNullAndOrderIsNullAndStatusIsNotNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(null, null, STATUS_CODE_WS_OK);
        assertThat(actual, allOf(
                hasProperty("step", nullValue()),
                hasProperty("order", nullValue()),
                hasProperty("status", equalTo(STATUS_CODE_WS_OK))));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNotNullAndOrderIsNotNullAndStatusIsNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(ACTIVATE, ORDER_VALUE, null);
        assertThat(actual, allOf(
                hasProperty("step", equalTo(ACTIVATE)),
                hasProperty("order", equalTo(ORDER_VALUE)),
                hasProperty("status", nullValue())));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNotNullAndOrderIsNullAndStatusIsNotNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(ACTIVATE, null, STATUS_CODE_WS_OK);
        assertThat(actual, allOf(
                hasProperty("step", equalTo(ACTIVATE)),
                hasProperty("order", nullValue()),
                hasProperty("status", equalTo(STATUS_CODE_WS_OK))));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNullAndOrderIsNotNullAndStatusIsNotNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(null, ORDER_VALUE, STATUS_CODE_WS_OK);
        assertThat(actual, allOf(
                hasProperty("step", nullValue()),
                hasProperty("order", equalTo(ORDER_VALUE)),
                hasProperty("status", equalTo(STATUS_CODE_WS_OK))));
    }

    @Test
    public void testGetOutgoingMessage_shouldReturnNotNull_whenStepIsNotNullAndOrderIsNotNullAndStatusIsNotNull() {
        OutgoingMessage actual = mapper.getOutgoingMessage(ACTIVATE, ORDER_VALUE, STATUS_CODE_WS_OK);
        assertThat(actual, allOf(
                hasProperty("step", equalTo(ACTIVATE)),
                hasProperty("order", equalTo(ORDER_VALUE)),
                hasProperty("status", equalTo(STATUS_CODE_WS_OK))));
    }
}
