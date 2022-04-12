package com.blog.api.response.type;

import com.blog.core.TextUtilities;
import com.blog.model.Posts;
import lombok.Data;

@Data
public class ListPost {
    private int id;
    private long timestamp;
    private String title;
    private String announce;
    private UserPost user;
    private int viewCount;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;

    public ListPost(Posts posts) {
        String textFiltered = TextUtilities.html2text(posts.getText());

        this.id = posts.getId();
        this.title = posts.getTitle();
        this.announce = textFiltered.substring(0, Math.min(255, textFiltered.length()));
        this.user = new UserPost(posts.getUserId().getId(), posts.getUserId().getName());
        this.viewCount = posts.getViewCount();
        this.timestamp = posts.getTime().getEpochSecond();
    }
}