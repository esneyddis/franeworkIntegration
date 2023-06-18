package com.testCases;

import com.api.AbstractTest;
import org.testng.annotations.Test;

public class LoginAPiTest extends AbstractTest {



    @Test
    public void logIn(){
       services.getLoginService().logIn("Nanita", "123");
    }

}
