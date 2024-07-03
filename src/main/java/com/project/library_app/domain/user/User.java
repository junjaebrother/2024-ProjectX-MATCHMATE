package com.project.library_app.domain.user;

import com.project.library_app.domain.notification.Notification;
import com.project.library_app.domain.profile.Profile;
import com.project.library_app.dto.request.NotificationRequestMatchmate;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20)
    private String username;
    private String phone_number;
    private String email;

    @OneToOne
    private Profile profile;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();

    public User() {}

    public User(String username, String phone_number, String email) {
        this.username = username;
        this.phone_number = phone_number;
        this.email = email;
    }

    public void saveNotification(NotificationRequestMatchmate request){
        this.notifications.add(new Notification(request.getType(), request.getMessage(),
                request.getSender(), this));
    }
}
