package Spring_Project.MicroLibAPI.controller;

import Spring_Project.MicroLibAPI.domain.Users;
import Spring_Project.MicroLibAPI.dto.*;
import Spring_Project.MicroLibAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    private UserService userService;
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("users/new")
    public String createUserForm() {
        return "users/createUserForm";
    }

    @PostMapping("users/new")
    public String register(UserCreateRequestDTO request) {
        Users user = new Users();
        user.setName(request.getName());
        user.setLogin_id(request.getLogin_id());
        user.setPassword(request.getPassword());

        Long userId = userService.signUp(user);

        return "redirect:/index";
    }
}
