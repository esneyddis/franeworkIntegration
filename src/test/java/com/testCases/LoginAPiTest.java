package com.testCases;

import com.api.AbstractTest;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.mock.WireMockUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPiTest extends AbstractTest {


    @Test
    public void logIn() {
        Response response =
                services.getLoginService().logIn("eve.holt@reqres.in", "cityslicka");
        String token = response.jsonPath().get("token");
        System.out.println("token = " + token);
        Assert.assertNotNull(response.jsonPath().get("token"));
    }

    @Test
    public void logInUsingMock() {
        MappingBuilder mappingBuilder = WireMockUtils.createUser();
        String serverUrl = buildServerUrl();
        System.out.println("serverUrl = " + serverUrl);
        Response response =
                services.getLoginService(serverUrl).logIn("eve.holt@reqres.in", "cityslicka");
        WireMock.removeStub(mappingBuilder);
        String token = response.jsonPath().get("token");
        System.out.println("token = " + token);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X67");
    }

    private String buildServerUrl() {
        return String.format("https://localhost:%d", this.wireMockServer.httpsPort());
    }

}
