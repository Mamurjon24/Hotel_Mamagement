package org.example.controller;

import org.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AuthController {
    @Autowired
    private AuthService authService;
    Scanner strScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println(mainMenu);
            switch (intScanner.nextInt()) {
                case 0:
                    return;
                case 1:
                    login();
                    break;
                case 2:
                    complain();
                    break;
                default:
                    System.out.println("Mazgi nima bu");
            }
        }
    }

    String mainMenu = """
            ------>  Main  <----------       
                   0. -> Exit
                   1. -> Log In               
                   2. -> Complain - (Arznomalar)               
                   """;

    public void login() {
        System.out.print("Enter phone:");
        String phone = strScanner.nextLine();
        authService.login(phone);
    }
    public void complain() {
        System.out.print("Enter phone:");
        String phone = strScanner.nextLine();
        authService.complain(phone);
    }
}
