package com.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class AbstractTest {
    public WebDriver driver;
    public AllServices services;
    public WireMockServer wireMockServer;

    @BeforeSuite
    public void startServer() {
       this.wireMockServer = new WireMockServer(options().dynamicPort().dynamicHttpsPort());
       this.wireMockServer.start();
       configureFor("localhost", this.wireMockServer.port());
    }


    @BeforeClass
    public void apiSetUp() {
        if (services == null) {
            services = new AllServices();
        }

    }

    @AfterSuite
    public void deleteServer() {
        if (this.wireMockServer != null) {
            System.out.println("entro aqui = ");
            this.wireMockServer.stop();
        }
    }


}
