package org.example.service;

import org.example.entity.EmployerTypeEntity;
import org.example.entity.EmployerWorkTableEntity;
import org.example.repository.EmployerTypeRepository;
import org.example.repository.EmployerWorkTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerWorkTableService {
    @Autowired
    private EmployerWorkTableRepository employerWorkTableRepository;

    public void addWorkTable(String workHours, String workStatus) {
        EmployerWorkTableEntity employerWorkTableEntity = new EmployerWorkTableEntity();
        employerWorkTableEntity.setInHours(workHours);
        employerWorkTableEntity.setNameWorkTable(workStatus);
        employerWorkTableRepository.save(employerWorkTableEntity);
    }

    public void workTableList() {
        List<EmployerWorkTableEntity> employerWorkTableEntities = employerWorkTableRepository.employerTableList();
        if (employerWorkTableEntities == null) {
            System.out.println("EmployerType is not found :)");
            return;
        }
        employerWorkTableEntities.forEach(System.out::println);
    }

    public void deleteEmployerWorkTable(Integer employerWorkTable) {
        EmployerWorkTableEntity employerWorkTableEntity = employerWorkTableRepository.getById(employerWorkTable);
        if (employerWorkTableEntity == null) {
            System.out.println("EmployerType_id is not Found :)");
            return;
        }
        employerWorkTableRepository.deleteEmployerWorkTable(employerWorkTable);
    }
}
