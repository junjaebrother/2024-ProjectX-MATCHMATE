package com.project.library_app.domain.profile;

import com.project.library_app.domain.user.User;
import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @OneToOne
    private User user;
    // private location
    private String bio;

    public Profile() {}

    public Profile(User user, String bio) {
        this.user = user;
        this.bio = bio;
    }
}
