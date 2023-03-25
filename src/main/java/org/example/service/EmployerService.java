package org.example.service;

import org.example.entity.EmployerEntity;
import org.example.entity.EmployerTypeEntity;
import org.example.entity.EmployerWorkTableEntity;
import org.example.entity.RoomEntity;
import org.example.enums.Status;
import org.example.repository.EmployerRepository;
import org.example.repository.EmployerTypeRepository;
import org.example.repository.EmployerWorkTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployerService {
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private EmployerTypeRepository employerTypeRepository;
    @Autowired
    private EmployerWorkTableRepository employerWorkTableRepository;

    public void addEmployer(String bithDate, String name, String phone, String surName, Integer employerTypeId, Integer employerWorkTableId) {
        EmployerEntity employer = new EmployerEntity();
        employer.setBithDate(LocalDate.parse(bithDate));
        employer.setName(name);
        employer.setSurName(surName);
        employer.setStatus(Status.ACTIVE);
        Object employer1 = employerRepository.getEmployerByPhone(phone);
        if (employer1 != null) {
            System.err.println("Wrong phone");
            return;
        }
        employer.setPhone(phone);
        EmployerTypeEntity employerType = employerTypeRepository.getById(employerTypeId);
        if (employerType == null) {
            System.err.println("Employer Type not found :)");
            return;
        }
        employer.setEmployerType(employerType);
        EmployerWorkTableEntity employerWorkTableEntity = employerWorkTableRepository.getById(employerWorkTableId);
        if (employerWorkTableEntity == null) {
            System.err.println("Employer Work Table not found :)");
            return;
        }
        employer.setEmployerWorkTableEntity(employerWorkTableEntity);
        employerRepository.save(employer);
    }

    public void getEmployerList() {
        employerRepository.employerList();
    }

    public void changeStatus(Integer employerId) {
        EmployerEntity employer = employerRepository.getEmployerById(employerId);
        if (employer == null) {
            System.out.println("Room is not Found");
        }
        employerRepository.changeStatus(employer.getId());
    }
}
