package com.bsoft.simpledrive.controllers;

import com.bsoft.simpledrive.models.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.bsoft.simpledrive.services.FilesService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class FilesController {
    private final FilesService filesService;

    FilesController(@Autowired FilesService filesService){
        this.filesService = filesService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {
        File file = filesService.get(id);
        if (file == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = file.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(file.getContentFileType()));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(file.getName())
                .build();
        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public File create(@RequestParam("path") String path, @RequestParam("isPublic") boolean isPublic, @RequestPart("data") MultipartFile file) throws IOException {
        // Now you have access to 'folder' and 'isPublic' parameters
        return filesService.save(path, file.getOriginalFilename(), file.getContentType(), isPublic, file.getBytes());
    }
}
