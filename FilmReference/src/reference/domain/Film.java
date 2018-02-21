package reference.domain;

/**
 * Created by Navdeep on 6/19/2017.
 */
public class Film {

    private String name;

    public Film(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.getName();
    }
    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(object.getClass() != this.getClass()){
            return false;
        }
        Film param = (Film)object;

        if(!this.getName().equals(param.getName())){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        if(this.getName() == null){
            return -1;
        }
        return this.getName().hashCode();
    }
}
