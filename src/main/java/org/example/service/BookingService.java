package org.example.service;

import org.example.entity.BookingEntity;
import org.example.entity.GuestEntity;
import org.example.entity.RoomEntity;
import org.example.repository.BookingRepository;
import org.example.repository.GuestRepository;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private GuestRepository guestRepository;

    public void addBooking(Integer guestId, Integer roomId, String beginDate, Integer howLong, Double prise) {
       BookingEntity booking = new BookingEntity();
        RoomEntity room = roomRepository.getRoomById(roomId);
        if (room == null){
            System.out.println("Room is not Found :)");
            return;
        }
        booking.setRoom(room);
        GuestEntity guest = guestRepository.getGuestById(guestId);
        if (guest == null){
            System.out.println("Guest is not Found :)");
            return;
        }
        booking.setGuest(guest);
        booking.setStartFromDay(LocalDate.parse(beginDate));
        LocalDate today = LocalDate.parse(beginDate);
        LocalDate endDate = today.plusDays(howLong);
        booking.setFinishDay(endDate);
        booking.setAmount(prise);
        bookingRepository.save(booking);
    }

    public void getGuestList() {
        bookingRepository.guestList();
    }

    public void getBookingListByRoomId(Integer roomId) {
        bookingRepository.getBookingListByRoomId(roomId);
    }

    public void getBookingListByGuestId(Integer guestId) {
        bookingRepository.getBookingListByGuestId(guestId);
    }
}
