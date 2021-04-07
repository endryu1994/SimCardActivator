package com.akybenko.activation.service;

import static com.akybenko.activation.Constants.STATUS_CODE_WS_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.akybenko.activation.service.impl.WebServiceResponseStatusAnalyzerImpl;

@RunWith(SpringRunner.class)
public class WebServiceResponseStatusAnalyzerTest {

    private static final Integer STATUS_OK = STATUS_CODE_WS_OK;
    private static final Integer STATUS_NOT_OK = STATUS_OK - 1;

    private WebServiceResponseStatusAnalyzer analyzer;

    @Before
    public void setUp() {
        analyzer = new WebServiceResponseStatusAnalyzerImpl();
    }

    @Test
    public void testIsErrorWebServiceStatus_shouldReturnTrue_whenStatusIsNotOk() {
        boolean actual = analyzer.isErrorWebServiceStatus(STATUS_NOT_OK);
        assertThat(actual, equalTo(true));
    }

    @Test
    public void testIsErrorWebServiceStatus_shouldReturnFalse_whenStatusIsOk() {
        boolean actual = analyzer.isErrorWebServiceStatus(STATUS_OK);
        assertThat(actual, equalTo(false));
    }
}
