package com.testCases;

import com.api.AbstractTest;
import com.dto.UserResponse;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.mock.WireMockUtils;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.mock.WireMockUtils.buildServerUrl;


@Log4j
public class LoginAPiTest extends AbstractTest {

     String tokenCreated = getProperties("tokenCreated");


    @Test
    public void logIn() {
        UserResponse response =
                services.getLoginService().logIn("eve.holt@reqres.in", "cityslicka");
        String token = response.getToken();
        log.info("Getting response" + token);
        Assert.assertNotNull(response.getToken());
    }

    @Test
    public void logInUsingMock() {
        MappingBuilder mappingBuilder = WireMockUtils.createUser(tokenCreated);
        UserResponse response =
                services.getLoginService(buildServerUrl()).logIn("eve.holt@reqres.in", "cityslicka");
        WireMockUtils.removeStub(mappingBuilder);
        String tokenResp = response.getToken();
        log.info("Getting response using mock: " + tokenResp);
        Assert.assertEquals(tokenResp, tokenCreated);
    }


}
