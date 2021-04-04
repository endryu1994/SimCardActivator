package com.akybenko.activation.service.impl;

import org.springframework.stereotype.Service;

import com.akybenko.activation.service.WebServiceResponseStatusAnalyzer;

@Service
public class WebServiceResponseStatusAnalyzerImpl implements WebServiceResponseStatusAnalyzer {

    @Override
    public boolean analyze(Integer status) {
        return status != 0 && status != 9;
    }
}
