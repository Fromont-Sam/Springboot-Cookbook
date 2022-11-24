package be.fromont.spring.cookbook.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class ErrorMessage {

    private ZonedDateTime timestamp;
    private Integer status;
    private String error;
    private String path;
    private List<String> reasons;

}
