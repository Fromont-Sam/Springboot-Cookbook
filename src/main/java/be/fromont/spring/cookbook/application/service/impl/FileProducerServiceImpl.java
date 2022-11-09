package be.fromont.spring.cookbook.application.service.impl;

import be.fromont.spring.cookbook.application.dto.FileDTO;
import be.fromont.spring.cookbook.application.service.FileProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
public class FileProducerServiceImpl implements FileProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void produce(FileDTO fileDTO) {
        jmsTemplate.convertAndSend(fileDTO, properties -> {
            properties.setStringProperty("ApplicationName", "FILE_GENERATOR");
            return properties;
        });
    }
}
