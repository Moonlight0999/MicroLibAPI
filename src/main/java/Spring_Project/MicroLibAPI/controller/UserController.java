package Spring_Project.MicroLibAPI.controller;

import Spring_Project.MicroLibAPI.domain.Users;
import Spring_Project.MicroLibAPI.dto.users.UserCreateRequestDTO;
import Spring_Project.MicroLibAPI.dto.users.UserPatchRequestDTO;
import Spring_Project.MicroLibAPI.dto.users.UserResponseDTO;
import Spring_Project.MicroLibAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@Controller
public class UserController {

    private UserService userService;
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("users/new")
    public String createUserForm() {
        return "users/createUserForm";
    }

    @PostMapping("users/new")
    public String register(UserCreateRequestDTO request) {
        Long user_id = userService.signUp(request);
        return "redirect:/users/" +  user_id;
    }

    @GetMapping("/users/{user_id}")
    public String userProfileForm(@PathVariable("user_id") Long user_id, Model model) {
        UserResponseDTO response = userService.findById(user_id);

        model.addAttribute("user", response);

        return "users/userProfileForm";
    }

    @PostMapping("/users/patch")
    public String patchUserInfo(UserPatchRequestDTO request) {
        userService.patchUser(request);

        return "redirect:/";
    }
}
