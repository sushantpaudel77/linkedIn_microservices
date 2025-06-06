package com.linkedin_microservices.posts.service.events;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCreatedEvent {
    Long creatorId;
    String content;
    Long postId;
}
