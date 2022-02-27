package com.population;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 9953; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long count = persons.stream()
                .filter(w -> w.getAge() < 18)
                .count();
        System.out.println(count);
        List<String> famil = persons.stream()
                .filter(w -> w.getAge() >= 18 && w.getAge() <= 27)
                .filter(w -> w.getSex() == Sex.MAN)
                .map(w -> w.getFamily())
                .collect(Collectors.toList());
        System.out.println(famil);
        List<Person> readyForWork = persons.stream()
                .filter(w -> (w.getAge() >= 18 && w.getAge() <= 60 && w.getSex() == Sex.WOMAN) ||
                        (w.getAge() >= 18 && w.getAge() <= 65 && w.getSex() == Sex.MAN))
                .filter(w -> w.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(readyForWork);


    }
}
