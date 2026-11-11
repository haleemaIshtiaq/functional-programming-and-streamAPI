package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PrebuiltInterfacesDemo {
    void main (){
       /* List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );*/
        List<Person> people = PersonData.PEOPLE;

        //Predicate replaces person rule
        Predicate<Person> activePeople = p-> p.isActive();
        Predicate<Person>  adultPeople = p-> p.getAge()>=18;
        Predicate<Person>  livesInStockholm = p-> p.getCity().equalsIgnoreCase("Stockholm");


        //Consumer replaces person action
        Consumer<Person> names = p-> IO.println(p.getName());
        Consumer<Person> sendEmail = p-> IO.println("Sent email to " +p.getName());


        IO.println("Active people:");
        applyToMatching(people, activePeople, names);

        IO.println("Adult people:");
        applyToMatching(people, adultPeople, names);

        IO.println("Send email to active people:");
        applyToMatching(people, activePeople, sendEmail);

        IO.println("People living in Stockholm: " +findPeople(people,livesInStockholm));

    }


    // Method 1: Find matching people
    public static List<Person> findPeople(List<Person> people, Predicate<Person> rule) {

        List<Person> result = new ArrayList<>();

        for (Person p : people) {
            if (rule.test(p)) {
                result.add(p);
            }
        }

        return result;
    }

    // Method 2: Apply an action to matching people
    public static void applyToMatching(List<Person> people, Predicate<Person> rule, Consumer<Person> action) {

        for (Person p : people) {
            if (rule.test(p)) {
                action.accept(p);
            }
        }
    }
}

