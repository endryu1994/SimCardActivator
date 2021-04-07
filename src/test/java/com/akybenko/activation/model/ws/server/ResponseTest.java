package com.akybenko.activation.model.ws.server;

import static com.akybenko.activation.model.ws.server.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ResponseTest {

    @Test
    public void testGetParameters_shouldReturnEmptyList_whenParametersIsNull() {
        Response response = getResponseWithEmptyResponseParameters();
        List<Parameter> actual = response.getResponseParameters().getParameters();
        assertThat(actual, hasSize(0));
    }

    @Test
    public void testGetParameters_shouldReturnNotEmptyList_whenParametersIsNotNull() {
        Response response = getResponseWithNotEmptyResponseParameters();
        List<Parameter> actual = response.getResponseParameters().getParameters();
        assertThat(actual, hasSize(3));
    }
}
