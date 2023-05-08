package toy1.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException(String email) {
        super(String.format("Email '%s' already exists", email));
    }
}