package org.example.service;

import org.example.entity.CleaningRoomEntity;
import org.example.entity.EmployerEntity;
import org.example.entity.EmployerTypeEntity;
import org.example.entity.RoomEntity;
import org.example.enums.Status;
import org.example.repository.CleaningRoomRepository;
import org.example.repository.EmployerRepository;
import org.example.repository.RoomRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CleaningRoomService {
    @Autowired
    private CleaningRoomRepository cleaningRoomRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private EmployerRepository employerRepository;


    public void addCleaning(Integer roomId, Integer employerId, String time) {
        CleaningRoomEntity cleaningRoom = new CleaningRoomEntity();
        RoomEntity room = roomRepository.getRoomById(roomId);
        if (room == null){
            System.out.println("Room is not found");
            return;
        }
        cleaningRoom.setRoom(room);
        EmployerEntity employer = employerRepository.getEmployerById(employerId);
        if (employer == null){
            System.out.println("Employer is not found");
            return;
        }
        cleaningRoom.setEmployer(employer);
        cleaningRoom.setCleanTime(LocalDate.parse(time));
        cleaningRoomRepository.save(cleaningRoom);

    }

    public void getCleanedRoomList() {
        List<CleaningRoomEntity> cleaningRoomList = cleaningRoomRepository.getCleanedRoomList();
        if (cleaningRoomList == null){
            System.out.println("Not Active Room");
            return;
        }
        cleaningRoomList.forEach(System.out::println);
    }

    public void deleteCleaningRoom(Integer cleaningRoomId) {
        CleaningRoomEntity cleaningRoom = cleaningRoomRepository.getById(cleaningRoomId);
        if (cleaningRoom == null){
            System.out.println("EmployerType_id is not Found :)");
            return;
        }
        cleaningRoomRepository.deleteCleaningRoom(cleaningRoomId);
    }
}
