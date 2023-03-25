package org.example.service;


import org.example.entity.ComplainEntity;
import org.example.entity.EmployerEntity;
import org.example.entity.GuestEntity;
import org.example.entity.RoomEntity;
import org.example.enums.ComplainStatus;
import org.example.repository.ComplainRepository;
import org.example.repository.EmployerRepository;
import org.example.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainService {
    @Autowired
    private ComplainRepository complainRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private GuestRepository guestRepository;

    public void addcomplain(Integer guestId, Integer employerId, String status, String reason) {
        ComplainEntity complain = new ComplainEntity();
        GuestEntity guest = guestRepository.getGuestById(guestId);
        if (guest == null){
            System.out.println("Guest nor found :)");
            return;
        }
        complain.setGuest(guest);
        EmployerEntity employer = employerRepository.getEmployerById(employerId);
        if (employer == null){
            System.out.println("Employer not found :)");
            return;
        }
        complain.setComplainStatus(ComplainStatus.valueOf(status));
        complain.setComplainText(reason);
        complainRepository.save(complain);
    }

    public void getComplainsList() {
        complainRepository.complainsList();
    }

    public void changeStatus(Integer id,String status) {
        ComplainEntity complain = complainRepository.getComplainById(id);
        if (complain == null){
            System.out.println("Complain not Found :)");
            return;
        }
        complainRepository.changeStatus(id,status);
    }
}
