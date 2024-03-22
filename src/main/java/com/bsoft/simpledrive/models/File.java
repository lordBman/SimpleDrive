package com.bsoft.simpledrive.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "files")
public class File extends Content {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    @NotEmpty String path;
    @NotEmpty String name;
    
    boolean isPublic;
    private String contentFileType;
    @JsonIgnore private byte[] data;

    public File(){
        super(ContentType.file);
    }

    public File(String name, String path, String contentFileType, boolean isPublic, byte[] data){
        super(ContentType.file);
        this.name = name;
        this.path = path;
        this.isPublic = isPublic;
        this.contentFileType = contentFileType;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getContentFileType() {
        return contentFileType;
    }

    public void setContentFileType(String contentType) {
        this.contentFileType = contentFileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
