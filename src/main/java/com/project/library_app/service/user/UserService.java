package com.project.library_app.service.user;


import com.project.library_app.domain.profile.Profile;
import com.project.library_app.domain.profile.ProfileRepository;
import com.project.library_app.domain.user.User;
import com.project.library_app.domain.user.UserRepository;
import com.project.library_app.dto.request.NotificationRequestMatchmate;
import com.project.library_app.dto.request.ProfileRequestRegister;
import com.project.library_app.dto.request.UserRequestRegister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UserService(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional // 유저 등록
    public void registerUser(UserRequestRegister request){
        User user = userRepository.save(new User(request.getUserName(),
                request.getPhone_number(), request.getEmail()));
    }

    @Transactional // 프로필 등록
    public void registerProfile(ProfileRequestRegister request){
        User user = userRepository.findByName(request.getName());
        profileRepository.save(new Profile(user, request.getBio()));
    }

    @Transactional
    public void requestMatchmate(NotificationRequestMatchmate request){
        User user = userRepository.findByName(request.getSender());
        user.saveNotification(request);
    }
}
