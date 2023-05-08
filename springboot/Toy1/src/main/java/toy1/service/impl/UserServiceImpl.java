package toy1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toy1.domain.User;
import toy1.exception.EmailAlreadyExistsException;
import toy1.exception.InvalidLoginException;
import toy1.exception.UserNotFoundException;
import toy1.persistence.UserRepository;
import toy1.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User registerUser(User user) throws EmailAlreadyExistsException {
        if (isEmailAlreadyExists(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email is already exists.");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
	    if (!userRepository.existsById(user.getId())) {
	    	throw new UserNotFoundException(user.getId());
	    }
	    return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) throws UserNotFoundException {
	    if (!userRepository.existsById(user.getId())) {
	    	throw new UserNotFoundException(user.getId());
	    }
	    userRepository.delete(user);
    }

    @Override
    public User login(String email, String password) throws InvalidLoginException {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new InvalidLoginException();
        }
        return user;
    }

    @Override
    public boolean isEmailAlreadyExists(String email) {
        return userRepository.existsByEmail(email);
    }
}