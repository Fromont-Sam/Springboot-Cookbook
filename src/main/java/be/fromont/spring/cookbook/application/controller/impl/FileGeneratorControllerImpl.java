package be.fromont.spring.cookbook.application.controller.impl;

import be.fromont.spring.cookbook.application.controller.FileGeneratorController;
import be.fromont.spring.cookbook.application.dto.FileDTO;
import be.fromont.spring.cookbook.application.service.FileGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FileGeneratorControllerImpl implements FileGeneratorController {

    @Autowired
    private FileGeneratorService fileGeneratorService;

    @Override
    public ResponseEntity<FileDTO> getRandomFile() {
        return new ResponseEntity<>(fileGeneratorService.generateRandomFile(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FileDTO> uploadFile(FileDTO file) {
        return new ResponseEntity<>(fileGeneratorService.uploadFile(file), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FileDTO> removeFile(String fileId) {
        return new ResponseEntity<>(fileGeneratorService.removeFile(fileId), HttpStatus.ACCEPTED);
    }
}
