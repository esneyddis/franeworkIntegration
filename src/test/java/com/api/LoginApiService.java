package com.api;

import com.base.BaseService;
import com.dto.User;
import io.restassured.response.Response;

public class LoginApiService extends BaseService {

    String url;

    public LoginApiService() {
        super("https://reqres.in/");
    }

    public LoginApiService(String url) {
        super(url);
        this.url = url;
    }

    public Response logIn(String userName, String pass) {
       User user = new User();
       user.setUsername(userName);
       user.setPassword(pass);
      return   requestSpecification().body(user)
               .post("/api/login")
               .andReturn();
    }
}
