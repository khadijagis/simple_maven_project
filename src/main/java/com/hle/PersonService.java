package com.hle;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    public static List<Person> filtrerParAdresse(String address) {
        List<Person> mockPersonsDatabase = Arrays.asList(
                Person.builder().firstName("Alice").familyName("Doe").birthDate(LocalDate.of(1990, 5, 12))
                        .address("123 Rue A").build(),
                Person.builder().firstName("Bob").familyName("Smith").birthDate(LocalDate.of(2005, 10, 15))
                        .address("456 Rue B").build(),
                Person.builder().firstName("Charlie").familyName("Brown").birthDate(LocalDate.of(1985, 3, 9))
                        .address("123 Rue A").build()
                    );

        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);

        return mockPersonsDatabase.stream()
                .filter(hasAddress)
                .collect(Collectors.toList());
    }

    public static List<Person> filtrerAdultes() {
        List<Person> mockPersonsDatabase = Arrays.asList(
                Person.builder().firstName("Alice").familyName("Doe").birthDate(LocalDate.of(1990, 5, 12))
                        .address("123 Rue A").build(),
                Person.builder().firstName("Bob").familyName("Smith").birthDate(LocalDate.of(2005, 10, 15))
                        .address("456 Rue B").build(),
                Person.builder().firstName("Charlie").familyName("Brown").birthDate(LocalDate.of(1985, 3, 9))
                        .address("123 Rue A").build());

        Predicate<Person> isAdult = person -> person.calculerAge() >= 18;

        return mockPersonsDatabase.stream()
                .filter(isAdult)
                .collect(Collectors.toList());
    }



    
    public static Set<Person> removeBobWithoutIterator() {
        Set<Person> people = new HashSet<>();
        people.add(Person.builder().firstName("khadija").familyName("alica").build());
        people.add(Person.builder().firstName("fatima").familyName("Bob").build());
        people.add(Person.builder().firstName("zineb").familyName("Charlie").build());

        for (Person person : people) {
            if (person.getFamilyName().equals("Bob")) {
                people.remove(person); 
            }
        }
        return people;
    }

    public static Set<Person> removeBobUsingIterator() {
        Set<Person> people = new HashSet<>();
        people.add(Person.builder().firstName("Khadija").familyName("lkamel").build());
        people.add(Person.builder().firstName("fatima").familyName("Bob").build());
        people.add(Person.builder().firstName("zineb").familyName("lmouden").build());

        
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getFamilyName().equals("Bob")) {
                iterator.remove(); 
            }
        }
        return people;
    }

}
