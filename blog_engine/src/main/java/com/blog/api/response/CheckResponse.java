package com.blog.api.response;

import com.blog.model.Users;
import com.fasterxml.jackson.annotation.JsonInclude;

public class CheckResponse {

    private Boolean result;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Users users;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users user) {
        this.users = user;
    }
}