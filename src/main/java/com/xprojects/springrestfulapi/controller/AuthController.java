package com.xprojects.springrestfulapi.controller;

import com.xprojects.springrestfulapi.entity.User;
import com.xprojects.springrestfulapi.model.LoginUserRequest;
import com.xprojects.springrestfulapi.model.TokenResponse;
import com.xprojects.springrestfulapi.model.WebResponse;
import com.xprojects.springrestfulapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(
            path = "/api/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TokenResponse> login(@RequestBody LoginUserRequest request){
        TokenResponse tokenResponse = authService.login(request);
        return WebResponse.<TokenResponse>builder().data(tokenResponse).build();
    }

//    @DeleteMapping(
//            path = "/api/auth/logout",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public WebResponse<String> logout(User user) {
//        authService.logout(user);
//        return WebResponse.<String>builder().data("OK").build();
//    }
}
