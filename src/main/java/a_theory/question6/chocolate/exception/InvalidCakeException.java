package a_theory.question6.chocolate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCakeException extends RuntimeException {

    public InvalidCakeException() {
    }

    public InvalidCakeException(String message) {
        super(message);
    }

}
