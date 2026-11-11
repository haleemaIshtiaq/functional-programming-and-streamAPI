package se.lexicon;
@FunctionalInterface
public interface PersonRule {

    boolean matches(Person person);
}
