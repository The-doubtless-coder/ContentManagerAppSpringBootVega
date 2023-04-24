CREATE TABLE IF NOT EXISTS Content(
    id SERIAL,
    title VARCHAR(150) NOT NULL unique,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255) unique,
    primary key(id)
);

INSERT INTO content (title, description, status, content_type, date_created) VALUES ('THE UNRELENTING',
                                                              'the story is about a cat that never gave up the chase'
                                                              , 'IDEA', 'ARTICLE', LOCALTIMESTAMP(0));
INSERT INTO content (title, description, status, content_type, date_created) VALUES ('CHAMPS',
                                                                                     'the story is about a cat that never gave up the chase'
                                                                                        , 'IDEA', 'ARTICLE', LOCALTIMESTAMP(0));
INSERT INTO content (title, description, status, content_type, date_created) VALUES ('VICTORS',
                                                                                     'the story is about a cat that never gave up the chase'
                                                                                        , 'IDEA', 'ARTICLE', LOCALTIMESTAMP(0));
INSERT INTO content (title, description, status, content_type, date_created) VALUES ('BATTLE',
                                                                                     'the story is about a cat that never gave up the chase'
                                                                                        , 'IDEA', 'ARTICLE', LOCALTIMESTAMP(0));
INSERT INTO content (title, description, status, content_type, date_created) VALUES ('DIE HARD',
                                                                                     'the story is about a cat that never gave up the chase'
                                                                                        , 'IDEA', 'ARTICLE', LOCALTIMESTAMP(0));
INSERT INTO content (title, description, status, content_type, date_created) VALUES ('HARD KNOCKS',
                                                                                     'the story is about a cat that never gave up the chase'
                                                                                        , 'IDEA', 'ARTICLE', LOCALTIMESTAMP(0));
INSERT INTO content (title, description, status, content_type, date_created) VALUES ('SHARPENING',
                                                                                     'the story is about a cat that never gave up the chase'
                                                                                        , 'IDEA', 'ARTICLE', LOCALTIMESTAMP(0));
INSERT INTO content (title, description, status, content_type, date_created) VALUES ('AXE',
                                                                                     'the story is about a cat that never gave up the chase'
                                                                                        , 'IDEA', 'ARTICLE', LOCALTIMESTAMP(0));
INSERT INTO content (title, description, status, content_type, date_created) VALUES ('CUT DEEP',
                                                                                     'the story is about a cat that never gave up the chase'
                                                                                        , 'IDEA', 'ARTICLE', LOCALTIMESTAMP(0));


