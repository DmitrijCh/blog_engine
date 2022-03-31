package com.blog.service;

import com.blog.api.response.SettingsResponse;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {
    public SettingsResponse getGlobalSettings() {
        SettingsResponse response = new SettingsResponse();
        response.setMultiuserMode(false);
        response.setPostPremoderation(true);
        response.setStatisticsIsPublic(true);
        return response;
    }
}
