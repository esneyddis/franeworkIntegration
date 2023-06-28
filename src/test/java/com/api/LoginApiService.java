package com.api;

import com.base.BaseService;
import com.dto.User;
import com.dto.UserResponse;
import com.google.gson.GsonBuilder;

public class LoginApiService extends BaseService {

    String url;

    public LoginApiService() {
        super("https://reqres.in/");
    }

    public LoginApiService(String url) {
        super(url);
        this.url = url;
    }

    public UserResponse logIn(String userName, String pass) {
       User user = new User();
       user.setUsername(userName);
       user.setPassword(pass);
       String payload = new GsonBuilder().serializeNulls().create().toJson(user);
      return   requestSpecification().body(payload)
               .post("/api/login")
               .as(UserResponse.class);
    }
}
