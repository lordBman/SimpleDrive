package com.bsoft.simpledrive.models;

import jakarta.validation.constraints.NotNull;

public abstract class Content {
    public static enum ContentType{ file, folder }

    @NotNull
    ContentType contentType;

    protected Content(ContentType contentType){
        this.contentType = contentType;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }
}
