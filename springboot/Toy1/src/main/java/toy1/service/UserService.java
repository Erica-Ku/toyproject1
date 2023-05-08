package toy1.service;

import toy1.domain.User;
import toy1.exception.EmailAlreadyExistsException;
import toy1.exception.InvalidLoginException;
import toy1.exception.UserNotFoundException;

public interface UserService {
    User getUserById(Long id);
    User registerUser(User user) throws EmailAlreadyExistsException;
    User updateUser(User user) throws UserNotFoundException;
    void deleteUser(User user) throws UserNotFoundException;
    User login(String email, String password) throws InvalidLoginException;
    boolean isEmailAlreadyExists(String email);
}