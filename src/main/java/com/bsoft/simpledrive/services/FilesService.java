package com.bsoft.simpledrive.services;

public class FilesService {
    String name = "Nobel.dat";
    String path = "home/documents";
    
    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.path).append("/").append(this.name).toString();
    }
}
