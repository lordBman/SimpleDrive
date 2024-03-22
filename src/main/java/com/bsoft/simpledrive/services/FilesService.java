package com.bsoft.simpledrive.services;

import com.bsoft.simpledrive.models.File;
import com.bsoft.simpledrive.repository.FilesRepository;

public class FilesService {
    private final FilesRepository filesRepository;

    public FilesService(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    public Iterable<File> get() {
        return filesRepository.findAll();
    }

    public File get(Integer id) {
        return this.filesRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        filesRepository.deleteById(id);
    }

    public File save(String path, String fileName, String contentType, boolean isPublic, byte[] data) {
        File file = new File();
        file.setContentFileType(contentType);
        file.setName(fileName);
        file.setData(data);
        file.setPublic(isPublic);
        file.setPath(path);
        filesRepository.save(file);
        return file;
    }
}
