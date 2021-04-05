package com.akybenko.activation.service.impl;

import static com.akybenko.activation.Constants.STATUS_CODE_WS_OK;

import org.springframework.stereotype.Service;

import com.akybenko.activation.service.WebServiceResponseStatusAnalyzer;

@Service
public class WebServiceResponseStatusAnalyzerImpl implements WebServiceResponseStatusAnalyzer {

    @Override
    public boolean isErrorWebServiceStatus(Integer status) {
        return !STATUS_CODE_WS_OK.equals(status);
    }
}
