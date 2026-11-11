package se.lexicon;
@FunctionalInterface
public interface PersonRule {

    boolean matches(Person person);

    // combine two rules with AND
    default PersonRule and(PersonRule other) {
        return p -> this.matches(p) && other.matches(p);
    }

    // combine two rules with or
    default PersonRule or(PersonRule other) {
        return p -> this.matches(p) || other.matches(p);
    }
    //negate the rule
    default PersonRule negate(){
        return p-> !this.matches(p);
    }
}
