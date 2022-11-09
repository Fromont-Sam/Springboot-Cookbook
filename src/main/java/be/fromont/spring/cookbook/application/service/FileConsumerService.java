package be.fromont.spring.cookbook.application.service;

import be.fromont.spring.cookbook.application.dto.FileDTO;
import org.springframework.jms.annotation.JmsListener;

public interface FileConsumerService {

    @JmsListener(destination = "${jms.topic}")
    FileDTO consumer(String messageBody, String applicationName);

}
