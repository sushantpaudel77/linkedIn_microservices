package com.linkedin_microservices.connection_service.service;

import com.linkedin_microservices.connection_service.entity.Person;
import com.linkedin_microservices.connection_service.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConnectionsServiceImpl implements ConnectionsService{

    private final PersonRepository personRepository;

    @Transactional
    @Override
    public List<Person> getFirstDegreeConnections(Long userId) {
        log.info("Getting fist degree connections for user with ID: {}", + userId);
        return personRepository.getFirstDegreeConnections(userId);
    }
}
