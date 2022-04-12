package com.blog.api.response;

import com.blog.api.response.type.UserAuth;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class CheckResponse {
    private boolean result;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserAuth user;

    public CheckResponse(boolean result) {
        this.result = result;
        this.user = user;
    }
}