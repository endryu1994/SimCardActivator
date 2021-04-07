package com.akybenko.activation.model.ws.client;

import static com.akybenko.activation.model.ws.client.TestData.getEmptyParameter;
import static com.akybenko.activation.model.ws.client.TestData.getNotEmptyParameter;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ParameterTest {

    @Test
    public void testGetAttribute_shouldReturnEmptyList_whenAttributesIsNull() {
        Parameter actual = getEmptyParameter();
        assertThat(actual.getAttribute(), hasSize(0));
    }

    @Test
    public void testGetAttribute_shouldReturnNotEmptyList_whenAttributesIsNotNull() {
        Parameter actual = getNotEmptyParameter();
        assertThat(actual.getAttribute(), hasSize(3));
    }
}
