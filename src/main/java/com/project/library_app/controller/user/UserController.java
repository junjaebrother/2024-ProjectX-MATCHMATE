package com.project.library_app.controller.user;

import com.project.library_app.domain.profile.Profile;
import com.project.library_app.dto.request.NotificationRequestMatchmate;
import com.project.library_app.dto.request.ProfileRequestRegister;
import com.project.library_app.dto.request.UserRequestRegister;
import com.project.library_app.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 등룩
    @PostMapping("/user")
    public void registerUser(@RequestBody UserRequestRegister userRequestRegister){
        userService.registerUser(userRequestRegister);
    }

    // 프로필 등록
    @PostMapping("/user/profile")
    public void registerProfile(@RequestBody ProfileRequestRegister profileRequestRegister){
        userService.registerProfile(profileRequestRegister);
    }

    // 알림 생성
    @PostMapping("/matchmate")
    public void requestMatchmate(@RequestBody NotificationRequestMatchmate notificationRequestMatchmate){
        userService.requestMatchmate(notificationRequestMatchmate);
    }
}
