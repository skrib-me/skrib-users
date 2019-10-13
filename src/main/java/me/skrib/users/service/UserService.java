package me.skrib.users.service;

import me.skrib.users.model.User;
import me.skrib.users.model.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Save user.
     *
     * @param user
     * @return new user
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Get user.
     *
     * @param idUser
     * @return new user
     */
    public User getUser(Long idUser) {
        return userRepository.findOneById(idUser);
    }

}
