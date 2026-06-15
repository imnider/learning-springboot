package imnider.learning.springboot.error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import imnider.learning.springboot.error.models.domain.User;
import tools.jackson.databind.ObjectMapper;

@Service
public class UserService implements IUserService {

    private List<User> users;

    public UserService(){
        ClassPathResource resource = new ClassPathResource("data/users.json");
        loadProducts(resource);
    }

    private void loadProducts(ClassPathResource resource){
        try {
            ObjectMapper mapper = new ObjectMapper();
            users = List.of(mapper.readValue(resource.getInputStream(), User[].class));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
