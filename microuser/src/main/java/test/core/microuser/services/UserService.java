package test.core.microuser.services;

import org.springframework.stereotype.Service;
import test.core.microuser.domain.User;

import java.util.List;


public interface UserService {
    public List<User> getUsers();
    public User getUser(Long id);
    public User saveUser(User user);
    public User updateUser(User user);
    public void deleteUser(Long id);
}
