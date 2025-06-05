package com.linkedin_microservices.posts_service.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostCreatedEvent {
    Long createdId;
    String content;
    Long postId;
}
