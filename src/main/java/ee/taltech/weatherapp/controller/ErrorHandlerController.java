package ee.taltech.weatherapp.controller;

import ee.taltech.weatherapp.model.responses.ApiResponse;
import ee.taltech.weatherapp.model.responses.ApiResponseFailure;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {
    protected ApiResponse getFailureRes(String msg) {
        ApiResponse response = new ApiResponse();
        ApiResponseFailure failure = new ApiResponseFailure();

        failure.setError(msg);
        response.setSuccess(false);
        response.setData(failure);

        return response;
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                getFailureRes("Whoops, something went wrong"),
                new HttpHeaders(),
                HttpStatus.I_AM_A_TEAPOT
        );
    }

    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (status == HttpStatus.NOT_FOUND) {
            return new ResponseEntity<Object>(
                    getFailureRes("Not found"),
                    new HttpHeaders(),
                    HttpStatus.NOT_FOUND
            );
        }

        return handleAll(ex, request);
    }
}

