package com.testCases;

import com.api.AbstractTest;
import com.dto.User;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.mock.WireMockUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginAPiTest extends AbstractTest {
    @Test
    public void logIn(){
      Response response =
              services.getLoginService().logIn("Nany", "Welcome123");
        System.out.println("response = " + response.prettyPrint());
    }

    @Test
    public void logInUsingMock(){
        User user = new User();
        user.setUsername("esneyddis");
        user.setPassword("123");
        MappingBuilder mappingBuilder = null;
        mappingBuilder = WireMockUtils.createUser(user);
        Response response =
                services.getLoginService().logIn("esneyddis", "123");

        System.out.println("response.prettyPrint() = " + response.prettyPrint());
        WireMockUtils.deleteStub(mappingBuilder);

    }

}
