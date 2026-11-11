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


        // Task 6: Multiple filters

        //Active adults
        List<Person> activeAdults = people.stream()
                .filter(p -> p.isActive())
                .filter(p-> p.getAge()>=18)
                .toList();

        IO.println("Active Adults: ");
        activeAdults.forEach(p -> IO.println(p.getName()));
        activeAdults.forEach(p -> IO.println( p.toString()));

        //Active people in Stockholm
        List<Person> activeAndStockholm = people.stream()
                .filter(p -> p.isActive())
                .filter(p-> p.getCity().equalsIgnoreCase("Stockholm"))
                .toList();

        IO.println("Active people in Stockholm: ");
        activeAndStockholm.forEach(p -> IO.println(p.getName()));


        //Inactive people older than 30

        List<Person> inactiveOver30 = people.stream()
                .filter(p -> !p.isActive())
                .filter(p-> p.getAge()>30)
                .toList();

        IO.println("Inactive people older than 30 ");
        inactiveOver30.forEach(p -> IO.println(p.getName()));


    // Task 7: Distinct and Sorting

    //Get a sorted list of unique cities.
    List<String> cities = people.stream()
            .map(p -> p.getCity())
            .distinct()
            .sorted()
            .toList();

IO.println("Unique sorted cities: " + cities);
cities.forEach(s -> IO.println(s));



//Get a sorted list of unique first letters of names.
    List<String> firstLetters = people.stream()
                .map(p -> p.getName().substring(0, 1))
                .distinct()
                .sorted()
                .toList();

        IO.println("Unique first letters: " + firstLetters);

// Task 8 : Mapping and Formatting

//Create a list of strings like: Name (age) - city
        List<String> formattedPeople = people.stream()
                .map(p -> p.getName() + " (" + p.getAge() + ") - " + p.getCity())
                .toList();

        formattedPeople.forEach(s -> IO.println(s));


//Create a list of emails like: name.toLowerCase() + "@example.com"

        List<String> emails = people.stream()
                .map(p -> p.getName().toLowerCase() + "@example.com")
                .toList();

        emails.forEach(s -> IO.println(s));
}
}
