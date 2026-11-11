package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class PersonProcessor {
    //findPeople(list, rule) returning a List<Person>
    //applyToMatching(list, rule, action) returning void


    public static List<Person> findPeople(List<Person>  people, PersonRule rule){
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (rule.matches(p)) {
                result.add(p);
            }
        }
        return result;
    }

    public static void applyToMatching(List<Person>  people, PersonRule rule,PersonAction action){
        List<Person> updated = new ArrayList<>();
        for (Person p : people) {
            if (rule.matches(p)) {
            action.run(p);
        }
        }
    }
}
