package org.example.service;

import org.example.entity.GuestPasswordEntity;
import org.example.repository.GuestPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GuestPasswordService {
    @Autowired
    private GuestPasswordRepository guestPasswordRepository;

    public void addGuestPassword(String passwordNum, String givenDate, String givenAddress, String expiredDate) {
        GuestPasswordEntity guestPassword = new GuestPasswordEntity();
        guestPassword.setSerialNumber(passwordNum);
        guestPassword.setGivenDate(LocalDate.parse(givenDate));
        guestPassword.setExpiredFrom(LocalDate.parse(expiredDate));
        guestPassword.setGivenAddress(givenAddress);
        guestPasswordRepository.save(guestPassword);

    }
}
