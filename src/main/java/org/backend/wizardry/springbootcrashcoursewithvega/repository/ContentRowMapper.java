package org.backend.wizardry.springbootcrashcoursewithvega.repository;

import org.backend.wizardry.springbootcrashcoursewithvega.model.Content;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentRowMapper implements RowMapper<Content> {
    @Override
    public Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        Content content = new Content();
        content.setId(rs.getInt("id"));
        content.setTitle(rs.getString("title"));
        content.setDescription(rs.getString("description"));
        content.setStatus(rs.getString("status"));
        content.setContentType(rs.getString("content_type"));
        content.setDateCreated(rs.getTimestamp("date_created"));
        content.setDataUpdated(rs.getTimestamp("date_updated"));
        content.setUrl(rs.getString("url"));

        return content;
    }
}
