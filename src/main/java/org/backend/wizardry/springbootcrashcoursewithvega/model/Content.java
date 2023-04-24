package org.backend.wizardry.springbootcrashcoursewithvega.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.jdbc.core.RowCallbackHandler;

public class Content {
    @Positive(message = "content id must be positive")
    private Integer id;
    @NotBlank(message = "content title cannot be blank")
    private String title;
    @NotBlank(message = "content description cannot be blank")
    private String description;
    @NotBlank(message = "status cannot be blank")
    private String status;
    @NotBlank(message = "content type cannot be blank")
    private String contentType;
    @FutureOrPresent(message = "date created must be the present")
    private String dateCreated;
    private String dataUpdated;
    @NotBlank(message = "url cannot be blank")
    private String url;

    public Content(Integer id, String title, String description, String status, String contentType, String dateCreated, String dataUpdated, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.contentType = contentType;
        this.dateCreated = dateCreated;
        this.dataUpdated = dataUpdated;
        this.url = url;
    }

    public Content() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDataUpdated() {
        return dataUpdated;
    }

    public void setDataUpdated(String dataUpdated) {
        this.dataUpdated = dataUpdated;
    }
}
