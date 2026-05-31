package Spring_Project.MicroLibAPI.controller;

import Spring_Project.MicroLibAPI.dto.users.UserCreateRequestDTO;
import Spring_Project.MicroLibAPI.dto.users.UserPatchRequestDTO;
import Spring_Project.MicroLibAPI.dto.users.UserResponseDTO;
import Spring_Project.MicroLibAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users/new")
    public ResponseEntity<Long> register(@RequestBody UserCreateRequestDTO request) {
        Long user_id = userService.signUp(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(user_id);
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<UserResponseDTO> userProfileForm(@PathVariable("user_id") Long user_id) {
        UserResponseDTO response = userService.findById(user_id);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/users/{user_id}")
    public ResponseEntity<UserResponseDTO> patchUserInfo(@PathVariable Long user_id, @RequestBody UserPatchRequestDTO request) {
        UserResponseDTO response = userService.patchUser(user_id, request);

        return ResponseEntity.ok(response);
    }
}
