package com.api;

public class AllServices {

    LoginApiService loginApiService;


    public LoginApiService getLoginService(){
        if (loginApiService == null) {
            loginApiService = new LoginApiService();
        }
        return loginApiService;
    }

    public LoginApiService getLoginService(String serverUrl){
        if (loginApiService == null) {
            loginApiService = new LoginApiService(serverUrl);
        }
        return loginApiService;
    }
}
