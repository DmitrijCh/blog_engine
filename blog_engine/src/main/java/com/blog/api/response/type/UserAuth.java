package com.blog.api.response.type;

import com.blog.model.Users;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserAuth {
    private int id;
    private String name;
    private String photo;
    private String email;
    @JsonProperty("moderation")
    private boolean hasModeration;
    private long moderationCount;
    @JsonProperty("settings")
    private boolean hasSettings;

    public UserAuth(Users users, long moderationCount) {
        id = users.getId();
        name = users.getName();
        photo = users.getPhoto();
        email = users.getEmail();
        hasModeration = users.isModerator();
        hasSettings = users.isModerator();
        this.moderationCount = moderationCount;
    }
}
