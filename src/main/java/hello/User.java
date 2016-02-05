package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;

    protected User() {}

    public User(String firstName, String lastName) {
        this.name = firstName;
        this.name = lastName;
    }

    public String getName(){
    	return name;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s']",
                id, name);
    }

}

  