package be.fromont.spring.cookbook.application.controller;

import be.fromont.spring.cookbook.application.dto.FileDTO;
import be.fromont.spring.cookbook.application.service.FileGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
public class FileGeneratorController {

    @Autowired
    private FileGeneratorService fileGeneratorService;

    @GetMapping("/random-file")
    public ResponseEntity<FileDTO> getRandomFile() {
        return new ResponseEntity<>(fileGeneratorService.generateRandomFile(), HttpStatus.OK);
    }

    @PostMapping("/upload-file")
    public ResponseEntity<FileDTO> uploadFile(@Valid @RequestBody FileDTO file) {
        return new ResponseEntity<>(fileGeneratorService.uploadFile(file), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove-file")
    public ResponseEntity<FileDTO> removeFile(@RequestBody String fileId) {
        return new ResponseEntity<>(fileGeneratorService.removeFile(fileId), HttpStatus.ACCEPTED);
    }
}
