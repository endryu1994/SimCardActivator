package com.akybenko.activation.listener;

import com.akybenko.activation.model.ws.client.Notification;
import com.akybenko.activation.model.ws.client.Parameter;

class TestData {

    protected static final String ORDER_VALUE = "9155901180513467490";
    protected static final byte[] DATA = new byte[]{123, 34, 104, 101, 97, 100, 101, 114, 34, 58, 123, 34,
            116, 121, 112, 101, 34, 58, 34, 77, 79, 66, 73, 76, 69, 34, 44, 34, 117, 115, 101, 114, 34, 58,
            34, 66, 83, 83, 34, 44, 34, 115, 116, 101, 112, 34, 58, 34, 115, 105, 109, 80, 114, 101, 65, 99,
            116, 105, 118, 97, 116, 101, 34, 44, 34, 112, 114, 105, 111, 114, 105, 116, 121, 34, 58, 34, 53,
            34, 44, 34, 111, 114, 100, 101, 114, 34, 58, 34, 57, 49, 53, 53, 57, 48, 49, 49, 56, 48, 53, 49,
            51, 52, 54, 55, 52, 57, 48, 34, 44, 34, 105, 109, 115, 105, 34, 58, 34, 52, 52, 48, 49, 49, 48,
            48, 49, 48, 48, 48, 48, 52, 49, 51, 34, 125, 125};

    protected static Notification getNotificationRequest(String order) {
        Parameter parameter = new Parameter();
        parameter.setOrder(order);
        Notification notification = new Notification();
        notification.setParameter(parameter);
        return notification;
    }
}
