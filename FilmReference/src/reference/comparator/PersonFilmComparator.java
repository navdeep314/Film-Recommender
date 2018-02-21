package reference.comparator;

import reference.domain.*;


import java.util.*;

/**
 * Created by Navdeep on 6/20/2017.
 */
public class PersonFilmComparator implements Comparator<Film> {

    private Map<Film, Rating> personRatings;

    public PersonFilmComparator(Map<Film, Rating> ratings){
        this.personRatings = ratings;
    }
    @Override
    public int compare(Film film1, Film film2){
        return personRatings.get(film2).getRating() - personRatings.get(film1).getRating();
    }
}
