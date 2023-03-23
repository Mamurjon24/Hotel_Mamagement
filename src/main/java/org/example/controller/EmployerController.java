package org.example.controller;

import org.example.service.*;
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
    @Autowired
    private ExtraAmenitiesServive extraAmenitiesServive;
    @Autowired
    private EmployerTypeService employerTypeService;
    @Autowired
    private EmployerWorkTableService employerWorkTableService;
    @Autowired
    private GuestPasswordService guestPasswordService;
    @Autowired
    private GuestService guestService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private OutComeService outComeService;
    @Autowired
    private  CleaningRoomService cleaningRoomService;
    @Autowired
    private ComplainService complainService;
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
            10.-> Employer Work Table                                                   
            """;

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
                case 10 -> {
                    employerWorkTable();
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
        roomService.addRoom(number, floor, typeofRoom, price, area);
    }

    private void roomList() {
        roomService.roomList();
    }

    private void deleteRoom() {
        System.out.print("Enter Id Room");
        Integer roomId = intScanner.nextInt();
        roomService.changeStatus(roomId);
    }

    private void updateRoom() {
        System.out.print("Enter Id Room : ");
        Integer roomId = intScanner.nextInt();
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
        roomService.updateRoom(roomId, number, floor, typeofRoom, price, area);

    }

    private void findRoom() {
        System.out.print("Enter Id of Room");
        Integer roomId = intScanner.nextInt();
        roomService.findRoom(roomId);

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
                    listConvenient();
                }
                case 3 -> {
                    deleteConvenient();
                }
            }
        }
    }

    private void addconvenient() {
        System.out.println("Enter Name Convenient");
        String convenientName = strScanner.nextLine();
        extraAmenitiesServive.addconvenient(convenientName);
    }

    private void listConvenient() {
        extraAmenitiesServive.convenientList();
    }

    private void deleteConvenient() {
        System.out.print("Enter ID Convenient : ");
        Integer convenientId = intScanner.nextInt();
        extraAmenitiesServive.deleteConvenient(convenientId);
    }

    String employerTypeManu = """
            0. -> Exit
            1. -> Add Employer Type
            2. -> List
            3. -> Delete Employer Type
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
                    deleteEmployerType();
                }
            }
        }
    }

    private void addEmployerType() {
        System.out.println("Enter New EmployerType ");
        String newEmployerType = strScanner.nextLine();
        employerTypeService.addNewEmployerType(newEmployerType);
    }

    private void employerTypeList() {
        employerTypeService.employerTypeList();
    }

    private void deleteEmployerType() {
        System.out.print("Enter ID Employer Type : ");
        Integer employerTypeId = intScanner.nextInt();
        employerTypeService.deleteEmployerType(employerTypeId);
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
        System.out.println("Enter Birth Date of Employer yyyy-MM-dd");
        String bithDate = strScanner.nextLine();
        System.out.print("Enter Name of Employer : ");
        String name = strScanner.nextLine();
        System.out.print("Enter Surname of Employer : ");
        String surName = strScanner.nextLine();
        System.out.print("Enter Phone of Employer : ");
        String phone = strScanner.nextLine();
        employerTypeService.employerTypeList();
        System.out.print("Enter Employer Type Id : ");
        Integer employerTypeId = intScanner.nextInt();
        employerWorkTableService.workTableList();
        System.out.print("Enter Employer Smena Id : ");
        Integer employerWorkTableId = intScanner.nextInt();
        employerService.addEmployer(bithDate, name, phone, surName, employerTypeId, employerWorkTableId);
    }

    private void employerList() {
        employerService.getEmployerList();
    }

    private void deleteEmployer() {
        System.out.print("Enter Employer Id : ");
        Integer employerId = intScanner.nextInt();
        employerService.changeStatus(employerId);
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
            }
        }
    }

    private void addGuest() {
        System.out.print("Enter Name of Guest : ");
        String name = strScanner.nextLine();
        System.out.print("Enter Surname of Guest : ");
        String surName = strScanner.nextLine();
        System.out.print("Enter Phone of Guest : ");
        String phone = strScanner.nextLine();
        System.out.print("Enter passwordNum of Guest : ");
        String passwordNum = strScanner.nextLine();
        System.out.println("Enter Given Date of Guest Password yyyy-MM-dd");
        String givenDate = strScanner.nextLine();
        System.out.println("Enter Expired Date of Guest Password yyyy-MM-dd");
        String expiredDate = strScanner.nextLine();
        System.out.print("Enter Given Address of Guest Password : ");
        String givenAddress = strScanner.nextLine();
        guestPasswordService.addGuestPassword(passwordNum, givenDate, givenAddress, expiredDate);
        guestService.addGuest(passwordNum, name, surName, phone);
    }

    private void guestList() {
        guestService.getguestList();
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
        System.out.print("Enter Guest Id : ");
        Integer guestId = intScanner.nextInt();
        System.out.print("Enter Room Id : ");
        Integer roomId = intScanner.nextInt();
        System.out.println("Enter Booking Date yyyy-MM-dd");
        String beginDate = strScanner.nextLine();
        System.out.print("Enter Booking Day : ");
        Integer howLong = intScanner.nextInt();
        System.out.print("Enter Prise : ");
        Double prise = intScanner.nextDouble();
        bookingService.addBooking(guestId, roomId, beginDate, howLong, prise);
    }

    private void bookingList() {
        bookingService.getGuestList();
    }

    private void listByRoom() {

    }

    private void listByGuest() {

    }

    String outComeManu = """
            0. -> Exit
            1. -> Add OutCome
            2. -> List
                         """;

    private void outCome() {
        while (true) {
            System.out.println(employerManu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addOutCome();
                }
                case 2 -> {
                    outComeList();
                }
            }
        }
    }

    private void addOutCome() {
        System.out.print("Enter Out Come : ");
        String outCome = strScanner.nextLine();
        System.out.print("Enter Out Come Amount :");
        Double amount = intScanner.nextDouble();
        System.out.println("Enter Out Come Pay Date yyyy-MM-dd");
        String payDay = strScanner.nextLine();
        outComeService.addOutCome(outCome,amount,payDay);
    }

    private void outComeList() {
        outComeService.getOutComeList();
    }


    String cleaningRoomManu = """
            0. -> Exit
            1. -> Add Cleaning Room
            2. -> List
            3. -> Delete Cleaning Room
            """;

    private void cleaningRoom() {
        while (true) {
            System.out.println(employerManu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addCleaningRoom();
                }
                case 2 -> {
                    cleaningRoomList();
                }
                case 3 -> {
                    deleteCleaningRoom();
                }
            }
        }
    }

    private void addCleaningRoom() {
        System.out.print("Enter Room Id : ");
        Integer roomId = intScanner.nextInt();
        System.out.print("Enter Out Employer Id :");
        Integer employerId = intScanner.nextInt();
        System.out.println("Enter Cleaning Time yyyy-MM-dd: ");
        String time = strScanner.nextLine();
        cleaningRoomService.addCleaning(roomId,employerId,time);
    }

    private void cleaningRoomList() {
        cleaningRoomService.getCleanedRoomList();
    }

    private void deleteCleaningRoom() {
        System.out.print("Enter Id : ");
        Integer cleaningRoomId = intScanner.nextInt();
        cleaningRoomService.deleteCleaningRoom(cleaningRoomId);
    }

    String complainsManu = """
            0. -> Exit
            1. -> Add Complains
            2. -> List
            3. -> Delete Complains
            """;

    private void complains() {
        while (true) {
            System.out.println(employerManu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addComplains();
                }
                case 2 -> {
                    complainsRoomList();
                }
                case 3 -> {
                    deleteComplains();
                }
            }
        }
    }

    private void addComplains() {

    }

    private void complainsRoomList() {

    }

    private void deleteComplains() {

    }

    String employerWorkTableManu = """
            0. -> Exit
            1. -> Add Employer Work Table
            2. -> List
            3. -> Employer Work Table
            """;

    private void employerWorkTable() {
        while (true) {
            System.out.println(employerWorkTableManu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addEmployerWorkTable();
                }
                case 2 -> {
                    employerWorkTableList();
                }
                case 3 -> {
                    deleteEmployerWorkTable();
                }
            }
        }
    }

    private void addEmployerWorkTable() {
        System.out.print("Enter Work Hours : ");
        String workHours = strScanner.nextLine();
        System.out.print("Enter Work Status : ");
        String workStatus = strScanner.nextLine();
        employerWorkTableService.addWorkTable(workHours, workStatus);
    }

    private void employerWorkTableList() {
        employerWorkTableService.workTableList();
    }

    private void deleteEmployerWorkTable() {
        System.out.print("Enter ID Employer Work Table Id : ");
        Integer employerWorkTable = intScanner.nextInt();
        employerWorkTableService.deleteEmployerWorkTable(employerWorkTable);
    }


}

