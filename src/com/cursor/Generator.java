package com.cursor;

import java.util.Random;
import java.util.UUID;

public class Generator {

    private Generator() {
    }

    public static Car generateCar() {
        return new Car(getId(), getBrand(), getYear(), getMileage(), getPrice());
    }

    private static UUID getId() {
        return UUID.randomUUID();
    }

    private static Brand getBrand() {
        int pick = new Random().nextInt(Brand.values().length);
        return Brand.values()[pick];
    }

    private static int getYear() {
        return new Random().nextInt(2020 - 1970) + 1970;
    }

    private static int getMileage() {
        return new Random().nextInt(60_000);
    }

    private static int getPrice() {
        return new Random().nextInt(100_000 - 1_000) + 1_000;
    }
}
