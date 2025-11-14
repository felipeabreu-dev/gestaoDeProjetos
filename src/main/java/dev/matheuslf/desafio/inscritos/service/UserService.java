package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.exception.UserExistsException;
import dev.matheuslf.desafio.inscritos.model.User;
import dev.matheuslf.desafio.inscritos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(User user) {
        if (userRepository.existsByLogin(user.getUsername())) throw new UserExistsException("");
        userRepository.save(user);
    }

}
