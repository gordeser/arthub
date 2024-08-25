package org.gordeser.arthub.Controller;

import lombok.RequiredArgsConstructor;
import org.gordeser.arthub.Entity.UserEntity;
import org.gordeser.arthub.Service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin("")
public class UserController {

    private final UserService userService;

    @GetMapping("{user_id}")
    public UserEntity getUserById(@PathVariable("user_id") Long userId) throws Exception {
        return userService.getUserById(userId);
    }

    @PostMapping
    public UserEntity createUser(@Validated(UserEntity.class) @RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @PutMapping("{user_id}")
    public UserEntity updateUser(
            @PathVariable("user_id") Long userId,
            @Validated(UserEntity.class) @RequestBody UserEntity user
    ) throws Exception {
        return userService.updateUserById(userId, user);
    }

    @DeleteMapping("{user_id}")
    public void deleteUserById(@PathVariable("user_id") Long userId) throws Exception {
        userService.deleteUserById(userId);
    }
}

