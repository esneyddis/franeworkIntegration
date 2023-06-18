package com.api;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class AbstractTest {
    public WebDriver driver;
    public AllServices services;

   @BeforeSuite
    public void apiSetUp(){
       if (services == null) {
           services = new AllServices();
       }
   }


}
