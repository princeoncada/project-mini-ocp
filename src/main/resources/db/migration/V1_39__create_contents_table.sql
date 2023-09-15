-- Version 39
-- Create tbl_contents table

CREATE TABLE tbl_contents (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    content_type_id VARCHAR(36) NOT NULL REFERENCES tbl_content_types(id),
    author_id VARCHAR(36) NOT NULL REFERENCES tbl_users(id),
    title VARCHAR(255),
    content TEXT,
    is_active BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
