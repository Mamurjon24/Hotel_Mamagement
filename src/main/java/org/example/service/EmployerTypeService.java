package org.example.service;

import org.example.entity.EmployerTypeEntity;
import org.example.entity.ExtraAmenitiesEntity;
import org.example.repository.EmployerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerTypeService {
    @Autowired
    private EmployerTypeRepository employerTypeRepository;

    public void addNewEmployerType(String newEmployerType) {
        EmployerTypeEntity employerType = new EmployerTypeEntity();
        employerType.setType(newEmployerType);
        employerTypeRepository.save(employerType);
    }

    public void employerTypeList() {
        List<EmployerTypeEntity> employerTypeEntities = employerTypeRepository.employerTypeList();
        if (employerTypeEntities == null) {
            System.out.println("EmployerType is not found :)");
            return;
        }
        employerTypeEntities.forEach(System.out::println);
    }

    public void deleteEmployerType(Integer employerTypeId) {
        EmployerTypeEntity employerType = employerTypeRepository.getById(employerTypeId);
        if (employerType == null){
            System.out.println("EmployerType_id is not Found :)");
            return;
        }
        employerTypeRepository.deleteEmployerType(employerTypeId);
    }

}
