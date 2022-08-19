package com.flexi.siesta.ordermanagement.exception;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;

@Log
@RestControllerAdvice
public class RestErrorHandler {

    private final ResourceLoader resourceLoader;
    private byte[] defaultImage;

    @Autowired
    public RestErrorHandler(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void initNotFoundImage() {
        Resource resource = resourceLoader.getResource("classpath:static/Image_Not_Found.jpg");
        try {
            defaultImage = resource.getInputStream().readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            defaultImage = new byte[0];
        }
    }

    @ExceptionHandler(ImageNotFoundException.class)
    public ResponseEntity<byte[]> handleImageNotFoundException() {
        // return ResponseEntity.badRequest().contentType(MediaType.IMAGE_JPEG).body(defaultImage);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.IMAGE_JPEG).body(defaultImage);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiError> handleImageNotFoundException(ProductNotFoundException exception) {
        ApiError.ApiErrorBuilder message = ApiError.builder().status(HttpStatus.NOT_FOUND).error(exception.getCause().getMessage()).message(exception.getMessage());
        if (Level.FINER.equals(log.getLevel())) {
            StringWriter stackTrace = new StringWriter();
            exception.printStackTrace(new PrintWriter(stackTrace));
            stackTrace.flush();
            message.trace(stackTrace.toString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).
                body(message.build());
    }

}
