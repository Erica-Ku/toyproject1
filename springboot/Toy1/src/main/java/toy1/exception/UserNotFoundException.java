package toy1.exception;

public class UserNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long id) {
        super(String.format("User with id '%d' not found", id));
    }
}