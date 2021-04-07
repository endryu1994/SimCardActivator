package com.akybenko.activation.model.ws.server;

class TestData {

    protected static Request getRequestWithEmptyRequestParameters() {
        Request request = new Request();
        request.setRequestParameters(new Request.RequestParameters());
        return request;
    }

    protected static Response getResponseWithEmptyResponseParameters() {
        Response response = new Response();
        response.setResponseParameters(new Response.ResponseParameters());
        return response;
    }

    protected static Request getRequestWithNotEmptyRequestParameters() {
        Request.RequestParameters requestParameters = new Request.RequestParameters();
        requestParameters.setParameters(new Parameter(), new Parameter(), new Parameter());
        Request request = new Request();
        request.setRequestParameters(requestParameters);
        return request;
    }

    protected static Response getResponseWithNotEmptyResponseParameters() {
        Response.ResponseParameters responseParameters = new Response.ResponseParameters();
        responseParameters.setParameters(new Parameter(), new Parameter(), new Parameter());
        Response response = new Response();
        response.setResponseParameters(responseParameters);
        return response;
    }
}
