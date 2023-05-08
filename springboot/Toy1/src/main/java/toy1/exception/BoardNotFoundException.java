package toy1.exception;

public class BoardNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public BoardNotFoundException(Long id) {
        super(String.format("Board with id '%d' not found", id));
    }
}