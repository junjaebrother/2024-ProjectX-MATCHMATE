package com.project.library_app.domain.notification;

import com.project.library_app.domain.user.User;
import jakarta.persistence.*;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private Integer type;
    private String message;
    private String sender;

    @ManyToOne
    private User user;

    public Notification() {}

    public Notification(Integer type, String message, String sender, User user) {
        this.type = type;
        this.message = message;
        this.sender = sender;
        this.user = user;
    }
}
