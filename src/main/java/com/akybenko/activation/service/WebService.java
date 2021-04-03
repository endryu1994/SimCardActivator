package com.akybenko.activation.service;

import com.akybenko.activation.model.SimActivateRequest;
import com.akybenko.activation.model.ws.Response;

public interface WebService {

    Response getSimPreActivateResponse(SimActivateRequest request);

    Response getSpsCreateSimResponse(SimActivateRequest request);
}
