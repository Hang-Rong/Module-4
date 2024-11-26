package example.validateform.service.impl;

import example.validateform.model.User;
import example.validateform.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        System.out.println("User saved: " + user);
    }
}

