package org.example;

import org.example.config.BeanConfig;
import org.example.util.MainMenu;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
        MainMenu mainMenu = ctx.getBean(MainMenu.class);
        mainMenu.menuUtama();

    }
}