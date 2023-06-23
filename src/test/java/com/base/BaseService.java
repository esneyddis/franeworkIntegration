package com.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    /**
     * rest service inicialization configurations Base URL, Resource, Query, or Path Parameters.
     */

    String baseUrl;

    String resource;

    RequestSpecification requestSpecification;

    public BaseService(String url) {
        this.baseUrl = url;
        this.requestSpecification = RestAssured.given()
                .baseUri(url)
                .contentType(ContentType.JSON);
    }

    public RequestSpecification requestSpecification()
    {
        return this.requestSpecification;
    }
}
