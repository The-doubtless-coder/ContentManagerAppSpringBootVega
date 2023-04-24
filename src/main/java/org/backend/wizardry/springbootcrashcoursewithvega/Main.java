package org.backend.wizardry.springbootcrashcoursewithvega;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Timestamp current = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(current);
        Timestamp timestamp = Timestamp.valueOf("2023-04-24 20:12:43.0216443");
        System.out.println(timestamp);
        Timestamp timestamp1 = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp1);
    }

}
