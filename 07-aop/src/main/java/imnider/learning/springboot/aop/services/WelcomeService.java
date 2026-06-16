package imnider.learning.springboot.aop.services;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService implements IWelcomeService {

    @Override
    public String sayHello(String person, String phrase) {
        String welcomeMessage = phrase.concat(" ").concat(person);
        System.out.println(welcomeMessage);
        return welcomeMessage;
    }
    
}
