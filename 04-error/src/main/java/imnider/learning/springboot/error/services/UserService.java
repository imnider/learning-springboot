package imnider.learning.springboot.error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import imnider.learning.springboot.error.models.domain.User;

@Service
public class UserService implements IUserService {

    private List<User> users;

    public UserService(){
        users = List.of(
            new User(1L, "Neider", "Vélez"),
            new User(2L, "Juliet", "Morales"),
            new User(3L, "Nano", "Morán")
        );
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public Optional<User> getById(Long id) {
        User user = null;
        for(User u : users){
            if(u.getId().equals(id)){
                user = u;
                break;
            }
        }
        return Optional.ofNullable(user);
    }

    
}
