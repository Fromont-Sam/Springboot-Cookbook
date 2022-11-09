package be.fromont.spring.cookbook.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FileType {

    PDF(".pdf"),
    TXT(".txt"),
    JSON(".json");

    private String value;


}
