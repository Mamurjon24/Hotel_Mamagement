package org.example.controller;

import org.example.repository.RoomRepository;
import org.example.service.EmployerService;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class EmployerController {
    Scanner intScanner = new Scanner(System.in);
    Scanner strScanner = new Scanner(System.in);
    @Autowired
    private EmployerService employerService;
    @Autowired
    private RoomService roomService;

    public void manu() {
        while (true) {
            System.out.println(mainMenu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    room();
                }
                case 2 -> {
                    convenient();
                }
                case 3 -> {
                    employerType();
                }
                case 4 -> {
                    employer();
                }
                case 5 -> {
                    guest();
                }
                case 6 -> {
                    booking();
                }
                case 7 -> {
                    outCome();
                }
                case 8 -> {
                    cleaningRoom();
                }
                case 9 -> {
                    complains();
                }
            }
        }
    }

    String roomManu = """
            0. -> Exit
            1. -> Add Room
            2. -> List
            3. -> Delete Room
            4. -> Update Room
            5. -> Find Room
            6. -> Room convenient
            """;

    private void room() {
        while (true) {
            System.out.println(roomManu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addroom();
                }
                case 2 -> {
                    roomList();
                }
                case 3 -> {
                    deleteRoom();
                }
                case 4 -> {
                    updateRoom();
                }
                case 5 -> {
                    findRoom();
                }
                case 6 -> {
                    convenientRoom();
                }
            }
        }
    }

    private void addroom() {
        System.out.print("Enter Number of Room : ");
        Integer number = intScanner.nextInt();
        System.out.print("Enter Folder of Room : ");
        Integer floor = intScanner.nextInt();
        System.out.println("ORDENARY_ROOM, LUXURY_ROOM, DOUBLE_ROOM, FAMILY_ROOM, PRESIDENTIAL_ROOM");
        System.out.print("Choose Type of Room : ");
        String typeofRoom = strScanner.nextLine();
        System.out.print("Enter Price of Room : ");
        Double price = intScanner.nextDouble();
        System.out.print("Enter Area of Room : ");
        Float area = intScanner.nextFloat();
        roomService.addRoom(number,floor,typeofRoom,price,area);
    }

    private void roomList() {
       roomService.roomList();
    }

    private void deleteRoom() {
        System.out.println("Enter Id Room");
        Integer roomId = intScanner.nextInt();
        roomService.changeStatus(roomId);
    }

    private void updateRoom() {

    }

    private void findRoom() {

    }

    private void convenientRoom() {

    }

    String convenientManu = """
            0. -> Exit
            1. -> Add Convenient
            2. -> List
            3. -> Delete Convenient
            """;

    private void convenient() {
        while (true) {
            System.out.println(convenientManu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addconvenient();
                }
                case 2 -> {
                    listConvenientt();
                }
                case 3 -> {
                    deleteconvenient();
                }
            }
        }
    }

    private void addconvenient() {

    }

    private void listConvenientt() {

    }

    private void deleteconvenient() {

    }

    String employerTypeManu = """
            0. -> Exit
            1. -> Add Emploter Type
            2. -> List
            3. -> Delete Emploter Type
            """;

    private void employerType() {
        while (true) {
            System.out.println(employerTypeManu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addEmployerType();
                }
                case 2 -> {
                    employerTypeList();
                }
                case 3 -> {
                    deletEmployerType();
                }
            }
        }
    }

    private void deletEmployerType() {

    }

    private void employerTypeList() {

    }

    private void addEmployerType() {

    }

    String employerManu = """
            0. -> Exit
            1. -> Add Emploter
            2. -> List
            3. -> Delete Emploter
            """;

    private void employer() {
        while (true) {
            System.out.println(employerManu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addEmployer();
                }
                case 2 -> {
                    employerList();
                }
                case 3 -> {
                    deleteEmployer();
                }
            }
        }
    }

    private void addEmployer() {

    }

    private void employerList() {

    }

    private void deleteEmployer() {

    }


    String guestManu = """
            0. -> Exit
            1. -> Add Guest
            2. -> List            
            """;

    private void guest() {
        while (true) {
            System.out.println(guestManu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addGuest();
                }
                case 2 -> {
                    guestList();
                }
                case 3 -> {
                    deleteGuest();
                }
            }
        }
    }

    private void addGuest() {

    }

    private void guestList() {

    }

    private void deleteGuest() {

    }

    String bookingManu = """
            0. -> Exit
            1. -> Make Booking
            2. -> List
            3. -> List By Room
            4. -> List By Guest
            """;
    private void booking() {
        while (true) {
            System.out.println(bookingManu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    makeBooking();
                }
                case 2 -> {
                    bookingList();
                }
                case 3 -> {
                    listByRoom();
                }
                case 4 -> {
                    listByGuest();
                }
            }
        }
    }
    private void makeBooking() {

    }

    private void bookingList() {

    }

    private void listByRoom() {

    }

    private void listByGuest() {

    }
    String mainMenu = """
            0. -> Exit
            1. -> Room
            2. -> Convenient (qulayliklar)               
            3. -> Employee Type               
            4. -> Employee              
            5. -> Guest               
            6. -> Booking                                                    
            7. -> OutCome                                                    
            8. -> Cleaning Room                                                    
            9. -> Complains                                                    
            """;
    private void outCome() {

    }

    private void cleaningRoom() {

    }

    private void complains() {

    }

}

