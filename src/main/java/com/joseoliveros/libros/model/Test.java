package com.joseoliveros.libros.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Test {

    public static void main(String[] args) {

        LocalDate localDate1 = LocalDate.of(2017, Month.JANUARY, 20);
        LocalDate localDate2 = LocalDate.of(2017, 1, 20);
        LocalTime localTime = LocalTime.of(3, 6, 59, 50);
        LocalDateTime localDateTime = LocalDateTime.of(1,1,1,1,1,1);
        System.out.println(localDateTime);
    }
}
