package org.example.service;


import org.example.repository.ComplainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplainService {
    @Autowired
    private ComplainRepository complainRepository;
}
