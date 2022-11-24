package be.fromont.spring.cookbook.application.exception;

import be.fromont.spring.cookbook.application.enums.FileType;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> reasons = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
        return buildErrorMessage(HttpStatus.BAD_REQUEST, request, reasons);
    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidFormatException(InvalidFormatException ex, WebRequest request) {
        List<String> reasons = new ArrayList<>();
        StringBuilder sb = new StringBuilder("Field '");
        sb.append(ex.getPath().get(0).getFieldName());
        if (FileType.class.equals(ex.getTargetType()))
            sb.append("' : Value of type 'Enum' is mandatory: accepted values [TXT, PDF, JSON]");
        if (Date.class.equals(ex.getTargetType()))
            sb.append("' : Value of type `Date` wrong format: expected format 'yyyy-MM-dd'T'HH:mm:ss.SSSXXX'");
        if (Long.class.equals(ex.getTargetType()))
            sb.append("' : Value of type `Long` wrong format detected");
        reasons.add(sb.toString());
        return buildErrorMessage(HttpStatus.BAD_REQUEST, request, reasons);
    }

    @ExceptionHandler(value = {JsonMappingException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleJsonMappingException(JsonMappingException ex, WebRequest request) {
        List<String> reasons = new ArrayList<>();
        StringBuilder sb = new StringBuilder("Field '");
        sb.append(ex.getPath().get(0).getFieldName());
        sb.append("' : ");
        sb.append(ex.getOriginalMessage());
        reasons.add(sb.toString());
        return buildErrorMessage(HttpStatus.BAD_REQUEST, request, reasons);
    }

    @ExceptionHandler(value = {JacksonException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleJsonParseException(JacksonException ex, WebRequest request) {
        List<String> reasons = new ArrayList<>();
        reasons.add(ex.getOriginalMessage());
        return buildErrorMessage(HttpStatus.BAD_REQUEST, request, reasons);
    }

    private ErrorMessage buildErrorMessage(HttpStatus httpStatus, WebRequest request, List<String> reasons) {
        ZonedDateTime timestamp = ZonedDateTime.now();
        Integer status = httpStatus.value();
        String error = httpStatus.getReasonPhrase();
        String path = ((ServletWebRequest) request).getRequest().getServletPath();
        return new ErrorMessage(timestamp, status, error, path, reasons);
    }

}
