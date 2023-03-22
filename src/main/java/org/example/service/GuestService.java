package org.example.service;

import org.example.entity.GuestEntity;
import org.example.entity.GuestPasswordEntity;
import org.example.entity.RoomEntity;
import org.example.repository.GuestPasswordRepository;
import org.example.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private GuestPasswordRepository guestPasswordRepository;

    public void addGuest(String passwordSerial,String name, String surName, String phone) {
        GuestEntity guest = new GuestEntity();
        guest.setName(name);
        guest.setSurName(surName);
        guest.setPhone(phone);
        GuestPasswordEntity guestPassword = guestPasswordRepository.getGuestByPassword(passwordSerial);
        guest.setGusetPassword(guestPassword);
        guestRepository.save(guest);
    }

    public void getguestList() {
        List<GuestEntity> guestEntityList = guestRepository.guestList();
        if (guestEntityList == null){
            System.out.println("Not Active Room");
            return;
        }
        guestEntityList.forEach(System.out::println);
    }
}
