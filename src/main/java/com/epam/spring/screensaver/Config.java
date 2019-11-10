package com.epam.spring.screensaver;

import org.springframework.context.annotation.*;

import javax.swing.colorchooser.ColorChooserComponentFactory;
import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com.epam.spring.screensaver")
public class Config {
    @Bean
    @Scope("prototype")
    public Color color() {
        Random random = new Random();
        return new Color(
                random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255)
        );
    }

    @Bean
    public ColorFrame colorFrame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        while(true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(100);
        }
    }
}
