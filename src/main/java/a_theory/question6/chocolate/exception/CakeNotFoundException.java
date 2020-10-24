package a_theory.question6.chocolate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CakeNotFoundException extends RuntimeException {
}
