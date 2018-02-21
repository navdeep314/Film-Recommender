package reference.domain;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navdeep on 6/18/2017.
 */
public class Person {

    private String name;

    public Person(String name){
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
        Person param = (Person)object;

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
