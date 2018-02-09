package br.com.lancheria.controller;

import br.com.lancheria.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Eduardo on 05/02/2018.
 */
@RestController
public class UserEndpoints {

    private UserService userService;

    public UserEndpoints(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

}
