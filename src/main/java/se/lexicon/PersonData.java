package se.lexicon;

import java.util.List;

public class PersonData {
   public static final List<Person> PEOPLE = List.of(
            new Person("Amina", 22, "Stockholm", true),
            new Person("Erik", 17, "Uppsala", true),
            new Person("Noah", 34, "Stockholm", false),
            new Person("Sara", 29, "Gothenburg", true),
            new Person("Lina", 41, "Malmö", false),
            new Person("Omar", 19, "Stockholm", true)
    );
}
