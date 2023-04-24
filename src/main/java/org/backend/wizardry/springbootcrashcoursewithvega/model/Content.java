package org.backend.wizardry.springbootcrashcoursewithvega.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.Timestamp;

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
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp dateCreated;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp dataUpdated;
    @NotBlank(message = "url cannot be blank")
    private String url;

    public Content(Integer id, String title, String description, String status, String contentType, Timestamp dateCreated, Timestamp dataUpdated, String url) {
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

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDataUpdated() {
        return dataUpdated;
    }

    public void setDataUpdated(Timestamp dataUpdated) {
        this.dataUpdated = dataUpdated;
    }
}
