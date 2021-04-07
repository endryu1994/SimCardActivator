package com.akybenko.activation.model.ws.client;

import static com.akybenko.activation.model.ws.client.Type.DELETE;
import static com.akybenko.activation.model.ws.client.Type.fromValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TypeTest {

    private static final String UNKNOWN_VALUE = "modify";
    private static final String KNOWN_VALUE = "delete";

    @Test(expected = IllegalArgumentException.class)
    public void testFromValue_shouldThrowAnException_whenValueIsUnknown() {
        fromValue(UNKNOWN_VALUE);
    }

    @Test
    public void testFromValue_shouldReturnEnum_whenValueIsKnown() {
        Type actual = fromValue(KNOWN_VALUE);
        assertThat(actual, equalTo(DELETE));
    }
}
