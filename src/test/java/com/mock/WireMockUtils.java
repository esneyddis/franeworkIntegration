package com.mock;

import com.dto.UserResponse;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.http.Fault;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static com.utilities.CommonUtils.objectToString;

@Log4j
public final class WireMockUtils {

    public static WireMockServer wireMockServer;

    private WireMockUtils() {
        //prevent instantiation
    }

    @Step("Building wiremock server")
    public static String buildServerUrl() {
        return String.format("http://localhost:%d", wireMockServer.port());
    }

    public static StubMapping createStub(MappingBuilder mappingBuilder) {
        log.info("Starting wiremock server");
        wireMockServer = new WireMockServer(options().dynamicPort().dynamicHttpsPort());
        wireMockServer.start();
        log.info("Configuring wiremock server");
      //  wireMockServer.setGlobalFixedDelay(2000);
        configureFor(wireMockServer.port());
        return stubFor(mappingBuilder);
    }

    public static void removeStub(MappingBuilder mappingBuilder){
        System.out.println("deleting");
        wireMockServer.removeStub(mappingBuilder);
    }

    // the response is not going to return until the period of time have passed
    public static MappingBuilder createUser() {
        MappingBuilder mock = post(urlMatching("/api/login"))
                .atPriority(1)
                .willReturn(aResponse()
                        .withStatus(200)
                        .withFixedDelay(20000));
        createStub(mock);
        return mock;
    }

    // to simulate corrupted responses
    public static MappingBuilder createUserFaultResponse() {
        MappingBuilder mock = post(urlMatching("/api/login"))
                .atPriority(1)
                .willReturn(aResponse()
                        .withStatus(200)
                        .withFault(Fault.CONNECTION_RESET_BY_PEER));
        createStub(mock);
        return mock;
    }

   //to simulate a slow network and time out (chunk)
   public static MappingBuilder createUser(String userResponseToken) {
        MappingBuilder mock = post(urlMatching("/api/login"))
                .atPriority(1)
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody(objectToString(getUserResponseToken(userResponseToken)))
                        .withChunkedDribbleDelay(2, 90));
        createStub(mock);
        return mock;
    }

    private static String getUserResponseToken(String responseToken) {
      return   UserResponse.builder().token(responseToken)
                .build()
                .toString();
    }

}
