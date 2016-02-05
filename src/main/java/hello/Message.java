package hello;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String message;
	@ManyToOne(cascade=CascadeType.ALL)
	private User user;
	
	protected Message() {}
	
	public Message(User user, String message){
		this.user = user;
		this.message = message ;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getUserName(){
		return user.getName();
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}
	

}