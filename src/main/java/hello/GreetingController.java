package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    
    public Greeting greeting(Message message) throws Exception {
    	System.out.println(message.getUser());
        return new Greeting( message.getUserName()+ " : " + message.getMessage());
    }

}