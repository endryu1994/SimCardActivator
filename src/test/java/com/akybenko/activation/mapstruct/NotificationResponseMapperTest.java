package com.akybenko.activation.mapstruct;

import static com.akybenko.activation.mapstruct.TestData.ORDER_VALUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.akybenko.activation.model.ws.client.NotificationResponse;

@RunWith(SpringRunner.class)
public class NotificationResponseMapperTest {

    private NotificationResponseMapper mapper;

    @Before
    public void setUp() {
        mapper = NotificationResponseMapper.INSTANCE;
    }

    @Test
    public void testGetNotificationResponse_shouldReturnNull_whenValueIsNull() {
        NotificationResponse actual = mapper.getNotificationResponse(null);
        assertThat(actual, nullValue());
    }

    @Test
    public void testGetNotificationResponse_shouldReturnNotNull_whenValueIsNotNull() {
        NotificationResponse actual = mapper.getNotificationResponse(ORDER_VALUE);
        assertThat(actual, notNullValue());
        assertThat(actual, hasProperty("value", equalTo(ORDER_VALUE)));
    }
}
