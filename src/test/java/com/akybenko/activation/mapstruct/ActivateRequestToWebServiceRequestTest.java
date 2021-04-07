package com.akybenko.activation.mapstruct;

import static com.akybenko.activation.Constants.ORDER;
import static com.akybenko.activation.mapstruct.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.akybenko.activation.model.Header;
import com.akybenko.activation.model.ws.server.Parameter;
import com.akybenko.activation.model.ws.server.Request;
import com.akybenko.activation.model.ws.server.RequestHeader;

@RunWith(SpringRunner.class)
public class ActivateRequestToWebServiceRequestTest {

    private ActivateRequestToWebServiceRequest mapper;

    @Before
    public void setUp() {
        mapper = ActivateRequestToWebServiceRequest.INSTANCE;
    }

    @Test
    public void testGetRequestHeader_shouldReturnNull_whenValueIsNull() {
        RequestHeader actual = mapper.getRequestHeader(null);
        assertThat(actual, nullValue());
    }

    @Test
    public void testGetRequestHeader_shouldReturnNotNull_whenValueIsNotNull() {
        RequestHeader actual = mapper.getRequestHeader(new Header(getHeaderParameters()));
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("type", equalTo(TYPE_VALUE)),
                hasProperty("order", equalTo(ORDER_VALUE)),
                hasProperty("priority", equalTo(PRIORITY_INTEGER_VALUE)),
                hasProperty("user", equalTo(USER_VALUE))));
    }

    @Test
    public void testGetParameter_shouldReturnNull_whenNameIsNullAndValueIsNull() {
        Parameter actual = mapper.getParameter(null, null);
        assertThat(actual, nullValue());
    }

    @Test
    public void testGetParameter_shouldReturnNotNull_whenNameIsNotNullAndValueIsNull() {
        Parameter actual = mapper.getParameter(ORDER, null);
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("name", equalTo(ORDER)),
                hasProperty("value", nullValue())));
    }

    @Test
    public void testGetParameter_shouldReturnNotNull_whenNameIsNullAndValueIsNotNull() {
        Parameter actual = mapper.getParameter(null, ORDER_VALUE);
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("name", nullValue()),
                hasProperty("value", equalTo(ORDER_VALUE))));
    }

    @Test
    public void testGetParameter_shouldReturnNotNull_whenNameIsNotNullAndValueIsNotNull() {
        Parameter actual = mapper.getParameter(ORDER, ORDER_VALUE);
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("name", equalTo(ORDER)),
                hasProperty("value", equalTo(ORDER_VALUE))));
    }

    @Test
    public void testGetRequest_shouldReturnNull_whenRequestHeaderIsNullAndRequestParametersIsNull() {
        Request actual = mapper.getRequest(null, null);
        assertThat(actual, nullValue());
    }

    @Test
    public void testGetRequest_shouldReturnNotNull_whenRequestHeaderIsNotNullAndRequestParametersIsNull() {
        Request actual = mapper.getRequest(EMPTY_REQUEST_HEADERS, null);
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("requestHeader", equalTo(EMPTY_REQUEST_HEADERS)),
                hasProperty("requestParameters", nullValue())));
    }

    @Test
    public void testGetRequest_shouldReturnNotNull_whenRequestHeaderIsNullAndRequestParametersIsNotNull() {
        Request actual = mapper.getRequest(null, EMPTY_REQUEST_PARAMETERS);
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("requestHeader", nullValue()),
                hasProperty("requestParameters", equalTo(EMPTY_REQUEST_PARAMETERS))));
    }

    @Test
    public void testGetRequest_shouldReturnNotNull_whenRequestHeaderIsNotNullAndRequestParametersIsNotNull() {
        Request actual = mapper.getRequest(EMPTY_REQUEST_HEADERS, EMPTY_REQUEST_PARAMETERS);
        assertThat(actual, notNullValue());
        assertThat(actual, allOf(
                hasProperty("requestHeader", equalTo(EMPTY_REQUEST_HEADERS)),
                hasProperty("requestParameters", equalTo(EMPTY_REQUEST_PARAMETERS))));
    }
}
