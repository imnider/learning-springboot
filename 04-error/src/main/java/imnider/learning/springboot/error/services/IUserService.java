package imnider.learning.springboot.error.services;

import java.util.List;
import java.util.Optional;

import imnider.learning.springboot.error.models.domain.User;

public interface IUserService {

    List<User> getAll();
    Optional<User> getById(Long id);

}
