package com.example.monakom_cloud.java_advance_topic.java8.functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Lesson1 {


    public void test() {
        List<Car> cars = Arrays.asList(
                new Car(1000, "BMW"),
                new Car(1000, "Audi")
                );

        printDynamic(cars, car -> System.out.println(car.price));
        printDynamic(cars, car -> {
            if (Objects.equals(car.brand, "BMW")){
                System.out.println(car.brand +" "+ car.price);
            }
        });


        printMe(cars, car -> System.out.println(car.price));
        printMe(cars, car -> {
            if (Objects.equals(car.brand, "BMW")){
                System.out.println(car.brand +" "+ car.price);
            }
        });
    }

    public static void printDynamic(List<Car> cars, CarPrinter carPrinter){
        for (Car c : cars){
            carPrinter.printer(c);
        }
    }


    public static <T> void printMe(List<T> data, Consumer<T> consumer) {

        for (T t: data) {
            consumer.accept(t);
        }
    }



    public class Car {
        public int price;
        public String brand;

        public Car(int price, String brand){
            this.brand = brand;
            this.price = price;
        }
    }

    interface CarPrinter {
        void printer(Car car);
    }
}
