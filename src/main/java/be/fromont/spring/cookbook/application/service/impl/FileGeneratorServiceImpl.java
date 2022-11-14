package be.fromont.spring.cookbook.application.service.impl;

import be.fromont.spring.cookbook.application.dto.FileDTO;
import be.fromont.spring.cookbook.application.service.FileGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FileGeneratorServiceImpl implements FileGeneratorService {

    @Override
    public FileDTO generateRandomFile() {
        log.info("Generate random file started");
        return null;
    }

    @Override
    public FileDTO uploadFile(FileDTO file) {
        log.info("Upload file started : {}", file);
        return null;
    }

    @Override
    public FileDTO removeFile(String fileId) {
        log.info("Remove file started : {}", fileId);
        return null;
    }
}
