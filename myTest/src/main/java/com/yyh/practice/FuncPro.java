package com.yyh.practice;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FuncPro {
    public static void main(String[] args) {
        //printAndSort();

        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }

    private static void printSorted(List<PersonObj> persons, Comparator comparator){
        //Stream.of(persons).sorted(comparator).forEach(System.out::println);
        persons.stream().sorted(comparator).forEach(System.out::println);
    }

    private static void printAndSort() {
        //Stream.iterate(1, e -> 1 + e).filter().map().limit()
        List<PersonObj> persons = Arrays.asList(
                new PersonObj("jim", 65),
                new PersonObj("nomad", 23),
                new PersonObj("ben", 23),
                new PersonObj("abe", 34)
        );
        printSorted(persons, comparingInt(PersonObj::getAge).thenComparing(PersonObj::getName));
        //streamAndJoin();
    }

    private static void streamAndJoin() {
        File dir = new File("C:\\Users\\yhyeoh\\Documents\\Books");
        File[] listFiles = dir.listFiles();

        String fileNames = Stream.of(listFiles).map(File::getName).map(String::toUpperCase).collect(Collectors.joining(", "));

        System.out.println(fileNames);
        String filesClt = Arrays.stream(listFiles).map(f -> f.getName().toUpperCase()).collect(Collectors.joining("; "));
        System.out.println(filesClt);
        //String[] lst = dir.list();
        //Arrays.stream(lst)
    }
}
