package com.linkedin_microservices.connection_service.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcceptConnectionRequestEvent {
    private Long senderId;
    private Long receiverId;
}
