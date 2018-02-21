package reference.domain;

/**
 * Created by Navdeep on 6/19/2017.
 */
public enum Rating {

    BAD(-5),
    MEDIOCRE(-3),
    NOTWATCHED(0),
    NEUTRAL(1),
    FINE(3),
    GOOD(5);

    private int rating;

    private Rating(int rating){
        this.rating = rating;
    }
    public int getRating(){
        return this.rating;
    }
}
