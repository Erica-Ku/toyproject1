package toy1.exception;

public class InvalidLoginException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public InvalidLoginException() {
        super("Invalid email or password");
    }
}