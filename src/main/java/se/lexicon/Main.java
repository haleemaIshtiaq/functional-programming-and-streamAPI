package se.lexicon;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static PersonRule  activePeople = p-> p.isActive();
    static PersonRule  adultPeople = p-> p.getAge()>=18;
    static PersonRule  livesInStockholm = p-> p.getCity().equalsIgnoreCase("Stockholm");
    static PersonAction  names = p-> IO.println(p.getName());
    static PersonAction  sendEmail = p-> IO.println("Sent email to " +p.getName());


    static void main() {
        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );

        // Task 3: Filtered results
        IO.println("\n--- Filter results (no changes) ---");
        IO.println("Active people: " + filterPeople(people, activePeople));
        IO.println("Adult people(age 18 or above): " + filterPeople(people, adultPeople));
        IO.println("People living in Stockholm: " + filterPeople(people, livesInStockholm));


        // Tgask 4: Applying actions
        IO.println("\n--- Applying actions ---");
        IO.println("Print names:");
        applyPersonAction(people, names);

        IO.println("Send emails:");
        applyPersonAction(people, sendEmail);




    }

       //filter people method
        public static List<Person> filterPeople(List<Person> people, PersonRule rule) {
            List<Person> result = new ArrayList<>();
            for (Person p : people) {
                if (rule.matches(p)) {
                    result.add(p);
                }
            }
            return result;
        }


        //Apply Action method
    public static void applyPersonAction(List<Person> people,  PersonAction action) {
        //List<Person> updated = new ArrayList<>();
        for (Person p : people) {
            //if (action.matches(p)) {
                action.run(p);
            }
       // }
       // return updated;
    }
}
