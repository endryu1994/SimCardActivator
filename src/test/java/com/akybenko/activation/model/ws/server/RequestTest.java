package com.akybenko.activation.model.ws.server;

import static com.akybenko.activation.model.ws.server.TestData.getRequestWithEmptyRequestParameters;
import static com.akybenko.activation.model.ws.server.TestData.getRequestWithNotEmptyRequestParameters;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RequestTest {

    @Test
    public void testGetParameters_shouldReturnEmptyList_whenParametersIsNull() {
        Request request = getRequestWithEmptyRequestParameters();
        List<Parameter> actual = request.getRequestParameters().getParameters();
        assertThat(actual, hasSize(0));
    }

    @Test
    public void testGetParameters_shouldReturnNotEmptyList_whenParametersIsNotNull() {
        Request request = getRequestWithNotEmptyRequestParameters();
        List<Parameter> actual = request.getRequestParameters().getParameters();
        assertThat(actual, hasSize(3));
    }
}
