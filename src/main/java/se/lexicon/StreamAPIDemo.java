package se.lexicon;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamAPIDemo {
    void main() {
        List<Person> people = PersonData.PEOPLE;


        // Task 1: Filter all active people
        List<Person> activePeople = people.stream()
                .filter(p -> p.isActive())
                .toList();

        IO.println("Active people:");
        activePeople.forEach(p -> IO.println(p.getName()));



        // Task 2: Map all names
        List<String> names = people.stream()
                .map(p -> p.getName())
                .toList();

        IO.println("All names:");
        IO.println(names);


        // Task 3: Count adults
        long adultCount = people.stream()
                .filter(p -> p.getAge() >= 18)
                .count();

        IO.println("Number of adults: " + adultCount);



        // Task 4: Sort by age
        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparingInt(p -> p.getAge()))
                .toList();

        IO.println("Sorted by age:");
        sortedPeople.forEach(p ->
                IO.println(p.getName() + " - " + p.getAge()));




        // Task 5: Find first active person in Stockholm
        Optional<Person> firstPerson = people.stream()
                .filter(p -> p.isActive())
                .filter(p -> p.getCity().equalsIgnoreCase("Stockholm"))
                .findFirst();

        IO.println("First active person in Stockholm:");
        firstPerson.ifPresent(p -> IO.println(p.getName()));
    }
}
