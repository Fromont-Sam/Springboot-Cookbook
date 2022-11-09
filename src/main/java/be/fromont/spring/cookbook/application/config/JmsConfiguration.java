package be.fromont.spring.cookbook.application.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration("jms")
@Data
public class JmsConfiguration {

    private String host;
    private String producerName;
    private String topic;
    private String user;
    private String password;
    private String addresss;

}
