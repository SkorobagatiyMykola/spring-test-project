package com.skorobagatiy.springtestproject.service;

import com.skorobagatiy.springtestproject.exception.NotFoundException;
import com.skorobagatiy.springtestproject.model.User;
import com.skorobagatiy.springtestproject.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;


@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        logger.debug("Get User with id {}", id);
        Assert.notNull(id, "User id must not be null");
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Unknown user %s", id)));
    }

    public User createUser(User user) {
        logger.debug("Create User");
        Assert.notNull(user, "User must not be null");
        user = userRepository.save(user);
        logger.info("User with id {} has been saved on checkout db", user.getId());

        return user;
    }

    public List<User> getUsers() {
        logger.debug("Get all Users ");
        return userRepository.findAll();
    }

//    public User updateUser(Long id, User userData) {
//        logger.debug("Update User");
//        Assert.notNull(userData, "User must not be null");
//        Assert.notNull(id, "User id must not be null");
//
//        User user = getUser(id);
//        modelMapper.map(userData, user);
//        user = userRepository.updateUser(id, userData.getUserName(), userData.getName(), userData.getPreferredAccountId());
//        logger.info("Updated user with id: {}", id);
//
//        return user;
//    }
}
