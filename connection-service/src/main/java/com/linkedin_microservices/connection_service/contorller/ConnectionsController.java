package com.linkedin_microservices.connection_service.contorller;

import com.linkedin_microservices.connection_service.entity.Person;
import com.linkedin_microservices.connection_service.repository.PersonRepository;
import com.linkedin_microservices.connection_service.service.ConnectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class ConnectionsController {

    private final ConnectionsService connectionsService;

    @GetMapping("/{userId}/first-degree")
    public ResponseEntity<List<Person>> getFirstDegreeConnections(@PathVariable Long userId) {
        List<Person> firstDegreeConnections = connectionsService.getFirstDegreeConnections(userId);
        return ResponseEntity.ok(firstDegreeConnections);
    }
}
