package com.mock;

import com.dto.User;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class WireMockUtils {


    public WireMockUtils(){
    }

    public static StubMapping createStub(MappingBuilder mappingBuilder){
        WireMockServer server = new WireMockServer();
        server.start();
        return  stubFor(mappingBuilder);
    }

    public static void deleteStub(MappingBuilder mappingBuilder) {
        removeStub(mappingBuilder);
    }

  /*  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false); */

    public static MappingBuilder createUser(User user){
        MappingBuilder mock = post(urlEqualTo("https://api.demoblaze.com/login"))
                .atPriority(1)
             //   .withRequestBody(equalToJson(String.valueOf(user)))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("{\"id\":\"15\"}"));
        createStub(mock);
        return mock;

    }

}
