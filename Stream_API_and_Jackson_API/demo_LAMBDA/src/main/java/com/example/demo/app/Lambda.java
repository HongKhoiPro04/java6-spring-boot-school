package com.example.demo.app;

import com.example.demo.bean.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {

    static List<Student> list = Arrays.asList(
            new Student("Nguyen Van Teo", true, 7.5),
            new Student("tran thi thu huong", false, 5.5),
            new Student("Npham duc cuong", true, 9.5),
            new Student("le thi my hong", false, 6.5),
            new Student("doan thi kim ty", true, 7.5)
    );

    public static void main(String[] args) {
        demo5();
    }

    private static void demo5() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        double a = list.stream()
                .filter(i -> i%2==0)
                .peek(System.out::println)
                .map(n ->  Math.sqrt(n))
                .mapToDouble(d -> d)
                .average().getAsDouble();
        System.out.println(a);
    }

    private static void demo4() {
        Demo4Inter o =  x -> System.out.println(x);
        o.m1(2023);

    }

    private static void demo3() {
        Collections.sort(list, (sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));
        list.forEach(sv -> {
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println();
        });
    }

    private static void demo2() {
        List<Student> list = Arrays.asList(
                new Student("Nguyen Van Teo", true, 7.5),
                new Student("tran thi thu huong", false, 5.5),
                new Student("Npham duc cuong", true, 9.5),
                new Student("le thi my hong", false, 6.5),
                new Student("doan thi kim ty", true, 7.5)
        );
        list.forEach(sv -> {
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println();
        });
    }

    private static void demo1() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        list.forEach(n -> System.out.println(n));
    }

}

@FunctionalInterface
interface Demo4Inter {
    void m1(int x);

    default void m2() {
    }

    public static void m3() {
    }
}