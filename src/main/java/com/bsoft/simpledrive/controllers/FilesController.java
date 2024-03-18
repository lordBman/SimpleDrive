package com.bsoft.simpledrive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bsoft.simpledrive.services.FilesService;

@RestController
public class FilesController {
    private final FilesService filesService;

    FilesController(@Autowired FilesService filesService){
        this.filesService = filesService;
    }
}
