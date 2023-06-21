package com.dto;

import com.github.tomakehurst.wiremock.matching.ContentPattern;
import com.github.tomakehurst.wiremock.matching.MatchResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User  {

    private String username;

    private String password;

    public User() {;
    }
}
