-- Version 31
-- Create tbl_files table

CREATE TABLE tbl_files (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    file_type_id VARCHAR(36) NOT NULL REFERENCES tbl_file_types(id),
    parent_id VARCHAR(36) NOT NULL,
    name TEXT NOT NULL,
    mimetype VARCHAR(255) NOT NULL,
    path TEXT NOT NULL,
    `key` TEXT NOT NULL,
    uploaded_by VARCHAR(36) NOT NULL REFERENCES tbl_users(id),
    `order` INT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
