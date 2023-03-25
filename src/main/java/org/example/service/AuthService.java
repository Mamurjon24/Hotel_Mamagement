package org.example.service;

import org.example.container.ComponentContainer;
import org.example.controller.EmployerController;
import org.example.entity.ComplainEntity;
import org.example.entity.EmployerEntity;
import org.example.enums.Status;
import org.example.repository.ComplainRepository;
import org.example.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private EmployerController employerController;
    @Autowired
    private ComplainRepository complainRepository;

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
//        String employerRole = employerRepository.getEmployerRole();
//       if (!employerRole.equals("ADMIN")) {
//           System.out.println("You Are Not Admine :)");
//           return;
//       }
        employerController.manu();
    }

    public void complain(Integer id) {
       complainRepository.getComplainById(id);
    }

}
