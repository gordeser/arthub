package org.gordeser.arthub.Service;

import lombok.RequiredArgsConstructor;
import org.gordeser.arthub.Entity.UserEntity;
import org.gordeser.arthub.Repository.ImageRepository;
import org.gordeser.arthub.Repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserEntity getUserById(Long userId) throws Exception {
        return userRepository.findById(userId).orElseThrow(Exception::new);
    }

    public UserEntity getUserByUsername(String username) throws Exception {
        return userRepository.findByUsername(username).orElseThrow(Exception::new);
    }

    public UserEntity getUserByEmail(String userEmail) throws Exception {
        return userRepository.findByEmail(userEmail).orElseThrow(Exception::new);
    }

    public UserEntity createUser(UserEntity user) throws RuntimeException {
        userRepository.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new RuntimeException();
        });

        userRepository.findByUsername(user.getUsername()).ifPresent(u -> {
            throw new RuntimeException();
        });

        return userRepository.save(user);
    }

    public UserEntity updateUserById(Long userId, UserEntity user) throws Exception {
        UserEntity userToUpdate = userRepository.findById(userId).orElseThrow(Exception::new);

        // todo: make user updating

        return userToUpdate;
    }

    public void deleteUserById(Long userId) throws Exception {
        UserEntity userToDelete = userRepository.findById(userId).orElseThrow(Exception::new);
        userRepository.delete(userToDelete);
    }
}
