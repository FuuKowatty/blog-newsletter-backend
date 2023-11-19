package pl.bartoszmech.emailsender.exception;


public class InvalidEmail extends RuntimeException {
    String message;
    public InvalidEmail(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
