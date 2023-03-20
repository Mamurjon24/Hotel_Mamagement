package org.example.service;

import org.example.entity.RoomEntity;
import org.example.enums.RoomType;
import org.example.enums.Status;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public void addRoom(Integer number, Integer floor, String typeofRoom, Double price, Float area) {
        String upTypeRoom = typeofRoom.toUpperCase();
        if (upTypeRoom.equals(RoomType.DOUBLE_ROOM) || upTypeRoom.equals(RoomType.FAMILY_ROOM) || upTypeRoom.equals(RoomType.LUXURY_ROOM)
                || upTypeRoom.equals(RoomType.ORDENARY_ROOM) || upTypeRoom.equals(RoomType.PRESIDENTIAL_ROOM) ){
            System.out.println("Type Is not tog'ri");
            return;
        }
        RoomEntity room = new RoomEntity();
        room.setNumber(number);
        room.setFloorNumber(floor);
        room.setRoomType(RoomType.valueOf(upTypeRoom));
        room.setPrice(price);
        room.setArea(area);
        room.setStatus(Status.valueOf(String.valueOf(Status.ACTIVE)));
        roomRepository.save(room);
        System.out.println("Room Added");
    }

    public void roomList() {
        List<RoomEntity> roomEntityList = roomRepository.roomList();
        if (roomEntityList == null){
            System.out.println("Not Active Room");
            return;
        }
        roomEntityList.forEach(System.out::println);
    }

    public void changeStatus(Integer id) {
        RoomEntity room = roomRepository.getById(id);
        if (room == null){
            System.out.println("Room is not Found");
        }
      roomRepository.changeStatus(room.getId());
    }
}
