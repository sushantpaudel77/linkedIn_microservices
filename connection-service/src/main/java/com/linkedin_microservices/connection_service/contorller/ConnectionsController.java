package com.linkedin_microservices.connection_service.contorller;

import com.linkedin_microservices.connection_service.entity.Person;
import com.linkedin_microservices.connection_service.service.ConnectionsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class ConnectionsController {

    private final ConnectionsService connectionsService;

    @GetMapping("/first-degree")
    public ResponseEntity<List<Person>> getFirstConnections(HttpServletRequest httpServletRequest) {
        String userId = httpServletRequest.getHeader("X-User-Id");
        List<Person> firstDegreeConnections = connectionsService.getFirstDegreeConnections(Long.valueOf(userId));
        return ResponseEntity.ok(firstDegreeConnections);
    }
}
