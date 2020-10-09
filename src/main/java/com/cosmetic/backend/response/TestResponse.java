package com.cosmetic.backend.response;

import lombok.Data;

@Data
public class TestResponse {
    private String email;
    private String password;
    public TestResponse(String email, String password ) {
        this.email = email;
        this.password = password;
    }
}
