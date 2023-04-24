package org.backend.wizardry.springbootcrashcoursewithvega.controller;

import jakarta.validation.Valid;
import org.backend.wizardry.springbootcrashcoursewithvega.configs.SampleConfigProperties;
import org.backend.wizardry.springbootcrashcoursewithvega.exceptions.ContentNotFoundException;
import org.backend.wizardry.springbootcrashcoursewithvega.model.Content;
import org.backend.wizardry.springbootcrashcoursewithvega.repository.ContentCollectionRepository;
import org.backend.wizardry.springbootcrashcoursewithvega.repository.ContentJDBCTemplateRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.cont")
public class ContentController {
    private final ContentCollectionRepository repository;
    private final ContentJDBCTemplateRepository jdbcTemplateRepository;
    private final SampleConfigProperties properties;

    public ContentController(ContentCollectionRepository repository, ContentJDBCTemplateRepository jdbcTemplateRepository, SampleConfigProperties properties) {
        this.repository = repository;
        this.jdbcTemplateRepository = jdbcTemplateRepository;
        this.properties = properties;
    }

    @RequestMapping(value = "/props", method = RequestMethod.GET)
    public SampleConfigProperties properties() {
        return properties;
    }

    @RequestMapping(value = "/allContent", method = RequestMethod.GET)
    public List<Content> getAllContent() {
        return jdbcTemplateRepository.getAllContent();
    }

    @RequestMapping(value = "/content/{id}", method = RequestMethod.GET)
    public Content getContentById(@PathVariable("id") Integer id) throws ContentNotFoundException {
        return jdbcTemplateRepository.getSingleContent(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createContent(@Valid @RequestBody Content content) throws DuplicateKeyException {
        int b = jdbcTemplateRepository.addContent(content);
        if (b > 0) {
            return "content created!";
        } else
            return "content creation failed";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String updateContent(@RequestBody Content content, @PathVariable("id") Integer id) throws ContentNotFoundException {
        int i = jdbcTemplateRepository.updateContent(content, id);
        if (i > 0) {
            return "content updated!";
        } else
            return "updating content failed";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteContent(@PathVariable("id") Integer id) throws ContentNotFoundException {
        int i = jdbcTemplateRepository.deleteContent(id);
        if (i > 0) {
            return "content deleted!";
        } else
            return "deleting content failed";
    }
}
