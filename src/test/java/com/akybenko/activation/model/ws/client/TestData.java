package com.akybenko.activation.model.ws.client;

import java.util.Arrays;

class TestData {

    protected static Parameter getEmptyParameter() {
        return new Parameter();
    }

    protected static Parameter getNotEmptyParameter() {
        Parameter parameter = new Parameter();
        parameter.setAttribute(Arrays.asList(new Attribute(), new Attribute(), new Attribute()));
        return parameter;
    }
}
