package imnider.learning.springboot.error.services;

import java.util.List;

import imnider.learning.springboot.error.models.domain.User;

public interface IUserService {

    List<User> getAll();
    User getById(Long id);

}
