package be.fromont.spring.cookbook.application.service.impl;

import be.fromont.spring.cookbook.application.config.JmsConfiguration;
import be.fromont.spring.cookbook.application.dto.FileDTO;
import be.fromont.spring.cookbook.application.service.FileConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;

@Slf4j
public class FileConsumerServiceImpl implements FileConsumerService {

    @Autowired
    private JmsConfiguration jmsConfiguration;

    @Override
    public FileDTO consumer(String messageContent, @Header("ApplicationName") String applicationName) {
        return null;
    }

}
