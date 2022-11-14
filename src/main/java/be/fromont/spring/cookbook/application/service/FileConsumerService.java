package be.fromont.spring.cookbook.application.service;

import be.fromont.spring.cookbook.application.dto.FileDTO;
import org.springframework.messaging.handler.annotation.Header;

public interface FileConsumerService {

    FileDTO consumer(String messageContent, @Header("ApplicationName") String applicationName);

}
