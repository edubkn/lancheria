package br.com.lancheria.service;

import br.com.lancheria.model.entity.User;
import br.com.lancheria.model.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByFacebookId(String facebookId) {
        return userRepository.findByFacebookId(facebookId);
    }
}
