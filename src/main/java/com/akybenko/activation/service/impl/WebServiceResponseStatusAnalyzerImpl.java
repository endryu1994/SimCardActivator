package com.akybenko.activation.service.impl;

import static com.akybenko.activation.Constants.STATUS_CODE_WS_OK;

import org.springframework.stereotype.Service;

import com.akybenko.activation.service.WebServiceResponseStatusAnalyzer;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WebServiceResponseStatusAnalyzerImpl implements WebServiceResponseStatusAnalyzer {

    @Override
    public boolean isErrorWebServiceStatus(Integer status) {
        boolean isError = !STATUS_CODE_WS_OK.equals(status);
        log.debug("Is error: {}", isError);
        return isError;
    }
}
