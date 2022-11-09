package be.fromont.spring.cookbook.application.controller;

import be.fromont.spring.cookbook.application.dto.FileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public interface FileGeneratorController {

    @GetMapping("random-file")
    ResponseEntity<FileDTO> getRandomFile();

    @PostMapping("upload-file")
    ResponseEntity<FileDTO> uploadFile(@RequestBody FileDTO file);

    @DeleteMapping("remove-file")
    ResponseEntity<FileDTO> removeFile(@RequestBody String fileId);

}
