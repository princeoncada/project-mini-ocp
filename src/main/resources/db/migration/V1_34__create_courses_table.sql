-- Version 34
-- Create tbl_courses table

CREATE TABLE tbl_courses (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    academic_year_id VARCHAR(36) NOT NULL REFERENCES tbl_academic_years(id),
    term_id VARCHAR(36) NOT NULL REFERENCES tbl_terms(id),
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    instructor_id VARCHAR(36) REFERENCES tbl_users(id),
    is_active BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
