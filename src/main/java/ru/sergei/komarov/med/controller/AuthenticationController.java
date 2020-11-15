package ru.sergei.komarov.med.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.model.User;
import ru.sergei.komarov.med.service.UserService;

import java.util.Map;

@RestController
public class AuthenticationController {

    private BCryptPasswordEncoder passwordEncoder;
    private UserService userService;
    private AuthenticationManager authenticationManager;

    public AuthenticationController(BCryptPasswordEncoder passwordEncoder,
                                    UserService userService,
                                    AuthenticationManager authenticationManager) {

        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    @ResponseBody
    public JsonElement authenticate(@RequestBody Map<String, String> body) {

        String username = body.get("username");
        String password = body.get("password");

        JsonObject response = null;

        if (username != null && password != null) {
            response = new JsonObject();
            Authentication authentication = null;
            try {
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
                authentication = this.authenticationManager.authenticate(token);
                System.out.println("Logging in with `" + authentication.getPrincipal() + "`");

                response.addProperty("message", "OK");
                response.addProperty("authenticated", authentication.isAuthenticated());

                JsonObject session = new JsonObject();
                User user = userService.getById(username);
                session.addProperty("login", username);
                session.addProperty("role", user.getRole().getName());

                response.add("session", session);
            } catch (Exception e) {
                System.err.println("Failure in autoLogin: " + e);

                response.addProperty("message", "NOT_FOUND");
                response.addProperty("authenticated", false);
            }
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        return response;
    }
}
