package me.skrib.users.service;

import io.damru.security.web.oauth2.okta.OktaHelper;
import io.damru.security.web.oauth2.okta.OktaUserClaims;
import me.skrib.users.model.User;
import me.skrib.users.model.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long idUser) {
        return userRepository.findOneById(idUser);
    }

    public User getUser(String username) {
        return userRepository.findOneByUsername(username);
    }

    public User getUserByOktaId(String oktaId) {
        return userRepository.findOneByOktaId(oktaId);
    }

    public User me() {
        OktaUserClaims claims = OktaHelper.getUserClaims();
        return userRepository.findOneByOktaId(claims.getUid());
    }

}
