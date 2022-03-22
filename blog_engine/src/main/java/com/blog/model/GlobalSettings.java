package com.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "global_settings")
public class GlobalSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "code_id")
    private GlobalSettings code;
    private String name;
    private Boolean value;

    public GlobalSettings getCode() {
        return code;
    }
}
