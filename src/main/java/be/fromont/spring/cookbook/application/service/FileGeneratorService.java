package be.fromont.spring.cookbook.application.service;

import be.fromont.spring.cookbook.application.dto.FileDTO;

public interface FileGeneratorService {

    FileDTO generateRandomFile();

    FileDTO uploadFile(FileDTO file);

    FileDTO removeFile(String fileId);

}
