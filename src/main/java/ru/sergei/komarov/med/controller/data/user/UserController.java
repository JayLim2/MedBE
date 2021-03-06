package ru.sergei.komarov.med.controller.data.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.model.User;
import ru.sergei.komarov.med.service.user.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController extends BasicUserController<User> {

    public UserController(UserService service) {
        super(service);
    }
}
