package be.fromont.spring.cookbook.application.service;

import be.fromont.spring.cookbook.application.dto.FileDTO;
import org.springframework.stereotype.Service;

@Service
public interface FileGeneratorService {

    FileDTO generateRandomFile();

    FileDTO uploadFile(FileDTO file);

    FileDTO removeFile(String fileId);

}
