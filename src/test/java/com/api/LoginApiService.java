package com.api;

import com.base.BaseService;
import com.dto.User;
import io.restassured.response.Response;

public class LoginApiService extends BaseService {

    public LoginApiService() {
        super("https://api.demoblaze.com/", "login");
    }

    public Response logIn(String userName, String pass) {
       User user = new User();
       user.setUsername(userName);
       user.setPassword(pass);
      return   requestSpecification().body(user)
               .post()
               .andReturn();
    }
}
