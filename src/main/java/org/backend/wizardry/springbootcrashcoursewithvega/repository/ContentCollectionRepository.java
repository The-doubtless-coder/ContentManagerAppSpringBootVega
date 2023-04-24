package org.backend.wizardry.springbootcrashcoursewithvega.repository;

import jakarta.annotation.PostConstruct;
import org.backend.wizardry.springbootcrashcoursewithvega.exceptions.ContentNotFoundException;
import org.backend.wizardry.springbootcrashcoursewithvega.model.Content;
import org.backend.wizardry.springbootcrashcoursewithvega.model.Status;
import org.backend.wizardry.springbootcrashcoursewithvega.model.Type;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("cont_collection_bean")
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public Content getSingleContent(Integer id) throws ContentNotFoundException {
        Optional<Content> first = getContentList().stream().
                filter(content -> content.getId()
                        .equals(id)).findFirst();
       if(first.isEmpty()){
           throw new ContentNotFoundException("Content with id::"+id+" not found");
       }
        return first.get();
    }

    public String addContent(Content content) {
        try {
            contentList.add(content);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "success";
    }

    public String updateContent(Content content, Integer id) throws ContentNotFoundException {
        try {
            contentList.set(contentList.indexOf(getSingleContent(id)), content);
        } catch (Exception e) {
            if(e instanceof ContentNotFoundException){
                throw new ContentNotFoundException("content with id::"+id+" not found");
            }

        }
        return "success";
    }


    public boolean deleteContent(Integer id) throws ContentNotFoundException {
        Content singleContent = null;
        try {
            singleContent = getSingleContent(id);
        } catch (ContentNotFoundException e) {
            throw new ContentNotFoundException("content with id::"+id+" " +
                    "could not be deleted since it's not availaable");
        }
        boolean remove = contentList.remove(singleContent);
        return remove;
    }
    @PostConstruct
    public void init() {
        Content content = new Content(1,
                "Movie", "About movies from the 90s",
                Status.IDEA.toString(), Type.VIDEO.toString(), LocalDateTime.now().toString(), LocalDateTime.now().toString(), null);
        Content content1 = new Content(2,
                "minutes", "About minutes of the conference",
                Status.IDEA.toString(), Type.CONFERENCE.toString(), LocalDateTime.now().toString(), LocalDateTime.now().toString(), null);
        Content content2 = new Content(3,
                "about games in kenya", "About kenyan games",
                Status.IDEA.toString(), Type.ARTICLE.toString(), LocalDateTime.now().toString(), LocalDateTime.now().toString(), null);

        contentList.add(content);
        contentList.add(content1);
        contentList.add(content2);
    }
}
