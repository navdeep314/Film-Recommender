package reference;

import reference.domain.*;
import reference.comparator.*;

import java.util.*;

/**
 * Created by Navdeep on 6/19/2017.
 */
public class Reference {

    private RatingRegister reg;

    public Reference(RatingRegister reg){
        this.reg = reg;
    }
    public Film recommendFilm(Person person){
        if(!this.reg.reviewers().contains(person)){
            return this.recommendToNewPerson(person);
        }else{
            return this.recommendBasedOnInterest(person);
        }
    }
    public Film recommendToNewPerson(Person person){
        Map<Film, List<Rating>> filmRatings = this.reg.filmRatings();
        List<Film> films = this.reg.getFilms();
        FilmComparator filmComparator = new FilmComparator(filmRatings);

        Collections.sort(films, filmComparator);

        return films.get(0);
    }
    public Film recommendBasedOnInterest(Person person){
        List<Person> reviewers = this.reg.reviewers();
        Map<Film, Rating> personRatings = this.reg.getPersonalRatings(person);
        Map<Person, Integer> similarityScores = new HashMap<Person, Integer>();

        for(Person reviewer: reviewers){
            if(person.equals(reviewer)){
                continue;
            }
            int similarityScore = 0;

            for(Film film: personRatings.keySet()){
                int personRating = this.reg.getRating(person, film).getRating();
                int reviewerRating = this.reg.getRating(reviewer, film).getRating();
                similarityScore += personRating * reviewerRating;
            }
            similarityScores.put(reviewer, similarityScore);
        }
        similarityScores.put(person, 0);

        Collections.sort(reviewers, new PersonComparator(similarityScores));

        for(Person reviewer: reviewers){
            if(similarityScores.get(reviewer) <= 0){
                break;
            }
            Map<Film, Rating> reviewerRatings = this.reg.getPersonalRatings(reviewer);
            List<Film> filmsViewerWatched = this.reg.getFilms(reviewer);

            Collections.sort(filmsViewerWatched, new PersonFilmComparator(reviewerRatings));

            for(Film film: filmsViewerWatched){
                if(reviewerRatings.get(film).getRating() <=0){
                    break;
                }
                if(!this.reg.getFilms(person).contains(film)){
                    return film;
                }
            }
        }
        return null;
    }
}
