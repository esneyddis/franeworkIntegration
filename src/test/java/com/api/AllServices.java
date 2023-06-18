package com.api;

public class AllServices {

    LoginApiService loginApiService;


    public LoginApiService getLoginService(){
        if (loginApiService == null) {
            loginApiService = new LoginApiService();
        }
        return loginApiService;
    }
}
