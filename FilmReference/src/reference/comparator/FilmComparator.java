package reference.comparator;

import reference.domain.*;
import reference.*;

import java.util.*;

/**
 * Created by Navdeep on 6/19/2017.
 */
public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> filmRatings;

    public FilmComparator(Map<Film, List<Rating>> ratings){
        this.filmRatings = ratings;
    }
    public int getFilmAverage(Film film){
        int average = 0;
        int counter = 0;

        for(Rating rating: this.filmRatings.get(film)){
            average += rating.getRating();
            counter++;
        }
        return average / counter;
    }
    @Override
    public int compare(Film film1, Film film2){
        return getFilmAverage(film2) - getFilmAverage(film1);
    }
}
