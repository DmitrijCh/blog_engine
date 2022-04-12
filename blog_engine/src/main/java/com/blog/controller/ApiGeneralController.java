package com.blog.controller;

import com.blog.api.request.CalendarRequest;
import com.blog.api.request.TagRequest;
import com.blog.api.response.CalendarResponse;
import com.blog.api.response.InitResponse;
import com.blog.api.response.TagResponse;
import com.blog.api.response.SettingsResponse;
import com.blog.service.CalendarService;
import com.blog.service.SettingsService;
import com.blog.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    private final InitResponse initResponse;
    private final SettingsService settingsService;
    private final TagService tagService;
    private final CalendarService calendarService;

    public ApiGeneralController(InitResponse initResponse, SettingsService settingsService, TagService tagService, CalendarService calendarService) {
        this.initResponse = initResponse;
        this.settingsService = settingsService;
        this.tagService = tagService;
        this.calendarService = calendarService;
    }

    @GetMapping("/init")
    private InitResponse init() {
        return initResponse;
    }

    @GetMapping("/settings")
    public SettingsResponse settings() {
        return settingsService.getGlobalSettings();
    }

    @GetMapping("/tag")
    public ResponseEntity<TagResponse> tag(TagRequest request) {
        return ResponseEntity.ok(tagService.response(request));
    }

    @GetMapping("calendar")
    public ResponseEntity<CalendarResponse> calendar(CalendarRequest request) {
        return ResponseEntity.ok(calendarService.response(request));
    }
}
