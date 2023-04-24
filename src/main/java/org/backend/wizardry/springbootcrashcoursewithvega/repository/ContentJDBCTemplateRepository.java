package org.backend.wizardry.springbootcrashcoursewithvega.repository;

import org.backend.wizardry.springbootcrashcoursewithvega.exceptions.ContentNotFoundException;
import org.backend.wizardry.springbootcrashcoursewithvega.model.Content;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContentJDBCTemplateRepository {
    private final JdbcTemplate jdbcTemplate;

    public ContentJDBCTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Content> getAllContent() {
        String listQuery = "SELECT id, title, description, status, content_type, date_created, date_updated, url  " +
                "FROM Content";
        List<Content> query = jdbcTemplate.query(listQuery, (rs, rowNum) -> new Content(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("status"),
                rs.getString("content_type"),
                rs.getString("date_created"),
                rs.getString("date_updated"),
                rs.getString("url")));
        return query;
    }

    public Content getSingleContent(Integer contentId) throws ContentNotFoundException {
        boolean b = doesObjectExist(contentId);
        if(!b){
            throw new ContentNotFoundException("the requested content does not exist");
        }

        String getSingleContentQuery = "SELECT id, title, description, status, content_type, date_created, date_updated, url  FROM Content WHERE id=?";
        Content content = jdbcTemplate.queryForObject(getSingleContentQuery, new Object[]{contentId}, new ContentRowMapper());
        return content;
    }

    public int deleteContent(int id) throws ContentNotFoundException {
        boolean b = doesObjectExist(id);
        if(!b){
            throw new ContentNotFoundException("content to be deleted does not exist");
        }
        String deleteQuery = "DELETE FROM Content WHERE id=?";
        return jdbcTemplate.update(deleteQuery, id);
    }

    public int addContent(Content content) throws DuplicateKeyException {
        String addContentQuery = "INSERT INTO Content (title, description, status, content_type, date_created, date_updated, url) VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(addContentQuery, content.getTitle(),
                content.getDescription(), content.getStatus(), content.getContentType(), content.getDateCreated(), null, null);

    }
    public int updateContent(Content content, Integer id) throws ContentNotFoundException {
        boolean b = doesObjectExist(id);
        if(!b){
            throw new ContentNotFoundException("the object to be updated does not exist");
        }
        String addContentQuery = "UPDATE Content SET title=?, description=?, status=?, content_type=?, date_created=?, date_updated=?, url=? WHERE id=?";
        return jdbcTemplate.update(addContentQuery, content.getTitle(),
                content.getDescription(), content.getStatus(), content.getContentType(), content.getDateCreated(), null, null, id);
    }
    private boolean doesObjectExist(Integer stringToCheck) {
        String sql = "SELECT count(*) FROM Content WHERE id = ?";

        int count = jdbcTemplate.queryForObject(sql, new Object[] {stringToCheck}, Integer.class);
        if(count>0){
            return true;
        }else
            return false;
    }
}
