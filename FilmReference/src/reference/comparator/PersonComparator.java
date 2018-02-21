package reference.comparator;

import reference.domain.*;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by Navdeep on 6/19/2017.
 */
public class PersonComparator implements Comparator<Person> {

    private Map<Person, Integer> identities;

    public PersonComparator(Map<Person, Integer> identities){
        this.identities = identities;
    }
    @Override
    public int compare(Person person1, Person person2){
        return this.identities.get(person2) - this.identities.get(person1);
    }
}
