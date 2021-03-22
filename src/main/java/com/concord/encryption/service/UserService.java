package com.concord.encryption.service;

import com.concord.encryption.entity.User;
import com.concord.encryption.exception.NotFoundException;
import com.concord.encryption.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserFioById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("User with id = %d not found", id)));
    }

    public String encryptUserFio(String fio) {
        return Crypto.encryptString(fio);
    }

    public String decryptUserFio(String fioEncr) {
        return Crypto.decryptString(fioEncr);
    }

}
