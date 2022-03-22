package com.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_comments")
public class PostComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Posts postId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users userId;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime time;

    @Column(nullable = false)
    private String text;
}
