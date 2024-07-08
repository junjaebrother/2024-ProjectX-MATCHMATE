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
    private String name;
    private String phone_number;
    private String email;

    @OneToOne
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public Profile getProfile() {
        return profile;
    }

    public User() {}

    public User(String name, String phone_number, String email) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
    }

    public void saveNotification(NotificationRequestMatchmate request){
        this.notifications.add(new Notification(request.getType(), request.getMessage(),
                request.getSender(), this));
    }
}
