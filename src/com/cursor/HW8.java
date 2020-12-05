package com.cursor;


import java.util.*;
import java.util.stream.Collectors;

public class HW8 {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            cars.add(Generator.generateCar());
        }

        List<Car> filterCars = cars.stream()
                .filter(car -> (car.getBrand().equals(Brand.TESLA)) || (car.getBrand().equals(Brand.AUDI)))
                .filter(car -> car.getYear() < 2018)
                .filter(car -> car.getMileage() < 40_000)
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());

        System.out.println("Cars, which brands are Tesla or Audi, year < 2018, mileage < 40 000, sorted by price in reverse order:");
        for (Car car : filterCars) {
            System.out.println(car);

        }

        int price = filterCars.get(filterCars.size() - 3).getPrice();
        Map<UUID, Car> cheaperCars = filterCars.stream()
                .filter(car -> car.getPrice() <= price)
                .collect(Collectors.toMap(Car::getId, car -> car));

        System.out.println("\nMap with three cheaper cars: ");
        cheaperCars.forEach((key, value) -> System.out.println(key + ", " + value));

    }
}
