package org.example.service;

import org.example.container.ComponentContainer;
import org.example.controller.EmployerController;
import org.example.entity.EmployerEntity;
import org.example.enums.Employer_Type;
import org.example.enums.Status;
import org.example.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private EmployerController employerController;

    public void login(String phone) {
        EmployerEntity employer = employerRepository.getEmployerByPhone(phone);
        if (employer == null) {
            System.out.println("Phone incorrect");
            return;
        }
        if (!employer.getStatus().equals(Status.ACTIVE)) {
            System.out.println("You not allowed.MF");
            return;
        }
        ComponentContainer.currentEmployer = employer;
        if (employer.getEmployerType().equals(Employer_Type.ADMIN)) {
            employerController.manu();
        }

    }
    public void complain(String phone) {
        EmployerEntity employer = employerRepository.getEmployerByPhone(phone);
        if (employer == null) {
            System.out.println("Phone incorrect");
            return;
        }
        if (!employer.getStatus().equals(Status.ACTIVE)) {
            System.out.println("You not allowed.MF");
            return;
        }
        ComponentContainer.currentEmployer = employer;
        if (employer.getEmployerType().equals(Employer_Type.ADMIN)) {
            employerController.manu();
        }

    }

}