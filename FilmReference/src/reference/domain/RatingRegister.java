package reference.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Navdeep on 6/19/2017.
 */
public class RatingRegister {

    private Map<Film, List<Rating>> ratings;
    private Map<Person, Map<Film, Rating>> personRatings;

    public RatingRegister(){
        this.ratings = new HashMap<Film, List<Rating>>();
        this.personRatings = new HashMap<Person, Map<Film, Rating>>();
    }
    public void addRating(Film film, Rating rating){

        if(this.ratings.containsKey(film)){
            this.ratings.get(film).add(rating);
        }else{
            ArrayList<Rating> newRating = new ArrayList<Rating>();
            newRating.add(rating);
            this.ratings.put(film, newRating);
        }
    }
    public void addRating(Person person, Film film, Rating rating){
        this.addRating(film, rating);

        if(this.personRatings.containsKey(person)){
            this.personRatings.get(person).put(film, rating);
        }else{
            Map ratings = new HashMap<Film, Rating>();
            ratings.put(film, rating);
            this.personRatings.put(person, ratings);
        }
    }
    public Rating getRating(Person person, Film film){
        if(this.personRatings.containsKey(person)){
            if(this.personRatings.get(person).containsKey(film)){
                return this.personRatings.get(person).get(film);
            }else{
                return Rating.NOTWATCHED;
            }
        }else{
            return null;
        }
    }
    public List<Rating> getRatings(Film film){
        if(this.ratings.containsKey(film)){
            return this.ratings.get(film);
        }
        return null;
    }
    public Map<Film, List<Rating>> filmRatings(){
        return this.ratings;
    }
    public Map<Film, Rating> getPersonalRatings(Person person){
        if(this.personRatings.containsKey(person)){
            return this.personRatings.get(person);
        }
        return null;
    }
    public List<Person> reviewers(){
        List<Person> reviewers = new ArrayList<Person>();

        for(Person person: this.personRatings.keySet()){
            reviewers.add(person);
        }
        return reviewers;
    }
    public List<Film> getFilms(){

        List<Film> films = new ArrayList<Film>();

        for(Film film: this.ratings.keySet()){
            films.add(film);
        }
        return films;
    }
    public List<Film> getFilms(Person person){
        List<Film> films = new ArrayList<Film>();

        for(Film film: this.getPersonalRatings(person).keySet()){
            films.add(film);
        }
        return films;
    }

}
