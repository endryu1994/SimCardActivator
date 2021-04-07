package com.akybenko.activation.listener;

import static com.akybenko.activation.listener.TestData.ORDER_VALUE;
import static com.akybenko.activation.listener.TestData.getNotificationRequest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.akybenko.activation.model.ws.client.NotificationResponse;
import com.akybenko.activation.service.NotificationService;

@RunWith(SpringRunner.class)
public class NotificationListenerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private NotificationListener listener;

    @Test
    public void testGetNotification_shouldReturnResponse_whenRequestIsNotNull() {
        NotificationResponse actual = listener.getNotification(getNotificationRequest(ORDER_VALUE));
        assertThat(actual, notNullValue());
        assertThat(actual, hasProperty("value", equalTo(ORDER_VALUE)));
    }
}
