-- Version 35
-- Create tbl_requirements table

CREATE TABLE tbl_requirements (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    course_id VARCHAR(36) NOT NULL REFERENCES tbl_courses(id),
    is_visible BOOLEAN NOT NULL,
    title VARCHAR(255) NOT NULL,
    instructions TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
