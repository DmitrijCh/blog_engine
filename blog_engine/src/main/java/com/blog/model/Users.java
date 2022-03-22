package com.blog.model;

import com.blog.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_moderator", nullable = false)
    private Byte isModerator;

    @Column(name = "reg_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime regTime;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String code;

    @Column(columnDefinition = "TEXT")
    private String photo;

    @ToString.Exclude
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Posts> postList;

    @ToString.Exclude
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostComments> postCommentList;

    public Role getRole() {
        return isModerator == 1 ? Role.MODERATOR : Role.USER;
    }
}