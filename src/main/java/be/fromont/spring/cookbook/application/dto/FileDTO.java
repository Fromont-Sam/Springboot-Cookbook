package be.fromont.spring.cookbook.application.dto;

import be.fromont.spring.cookbook.application.enums.FileType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FileDTO {

    private Long id;
    private String filename;
    private FileType extension;
    private String content;

}
