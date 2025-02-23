package com.forum.Api.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.forum.Api.entities.enums.Role;
import com.forum.Api.entities.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "role")
    private Role role;

    @Column(name = "status")
    private UserStatus status;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "banned", nullable = false)
    private boolean banned;

    @OneToMany(mappedBy = "author")
    @JsonBackReference
    private List<Post> posts;

    @OneToMany(mappedBy = "author")
    @JsonBackReference
    private List<Comment> comments;

    @PrePersist
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    public void onUpdate() {
        LocalDateTime now = LocalDateTime.now();
        updatedAt = now;
        lastLogin = now;
    }

}
