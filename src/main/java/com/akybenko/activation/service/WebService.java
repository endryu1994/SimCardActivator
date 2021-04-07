package com.akybenko.activation.service;

import com.akybenko.activation.model.ActivateRequest;
import com.akybenko.activation.model.ws.server.Response;

public interface WebService {

    Response getActivateResponse(ActivateRequest request);

    Response getCreateResponse(ActivateRequest request);
}
