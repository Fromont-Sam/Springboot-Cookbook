package be.fromont.spring.cookbook.application.dto;

import be.fromont.spring.cookbook.application.enums.FileType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class FileDTO {

    @NotNull(message = "Field 'id' : Value of type 'Long' is mandatory")
    private Long id;

    @NotNull(message = "Field 'filename' : Value of type 'String' is mandatory")
    private String filename;

    @NotNull(message = "Field 'extension' : Value of type 'Enum' is mandatory: accepted values [TXT, PDF, JSON]")
    private FileType extension;

    @NotBlank(message = "Field 'content' : Value of type 'String' is mandatory: expected Base64 format")
    @Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$", message = "Field 'content' : Value of type 'String' expected Base64 format")
    private String content;

    @Past(message = "Field 'creationDate' : Value of type `Date` must be in the past: expected format \"yyyy-MM-dd'T'HH:mm:ss.SSSXXX\"")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date creationDate;

}
