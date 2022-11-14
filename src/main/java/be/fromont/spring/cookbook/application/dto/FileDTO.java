package be.fromont.spring.cookbook.application.dto;

import be.fromont.spring.cookbook.application.enums.FileType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Data
public class FileDTO {

    @NotNull(message = "ID must be provided")
    private Long id;

    @NotBlank(message = "Filename must be provided")
    private String filename;

    @NotNull(message = "Extension must be provided")
    private FileType extension;

    @NotBlank(message = "Content must be provided")
    private String content;

    private ZonedDateTime creationDate;

}
