package com.mock;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import static com.github.tomakehurst.wiremock.client.WireMock.*;


public final class WireMockUtils {


    private WireMockUtils() {
        //prevent instantiation
    }

    public static StubMapping createStub(MappingBuilder mappingBuilder) {
        return WireMock.stubFor(mappingBuilder);
    }

    public static void removeStub(MappingBuilder mappingBuilder){
        System.out.println("deleting");
        WireMock.removeStub(mappingBuilder);
    }

    public static MappingBuilder createUser() {
        MappingBuilder mock = post(urlMatching("/api/login"))
                .atPriority(1)
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{\"token\": \"QpwL5tke4Pnpja7X67\"}"));
        createStub(mock);
        return mock;

    }

}
