package org.example;

import org.example.config.Config;
import org.example.controller.AuthController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //https://github.com/Mamurjon24/Hotel_Mamagement.git
        //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
        //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

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        AuthController authController = (AuthController) applicationContext.getBean("authController");
        authController.start();

    }
}