CREATE TABLE IF NOT EXISTS Content(
    id INTEGER AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL unique,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255) unique ,
    primary key(id)
);

INSERT INTO Content (title, description, status, content_type,
                     date_created) VALUES ('THE UNRELENTING',
                                                              'the story is about a cat that never gave up the chase'
                                                              , 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP())