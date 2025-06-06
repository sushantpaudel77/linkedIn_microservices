package com.linkedin_microservices.posts.service.events;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostLikedEvent {
    Long postId;
    Long creatorId;
    Long likedByUserId;
}
