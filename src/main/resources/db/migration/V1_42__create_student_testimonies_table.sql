-- Version 42
-- Create tbl_student_testimonies table

CREATE TABLE tbl_student_testimonies (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    student_companies_attended_id VARCHAR(36) NOT NULL UNIQUE,
    review TEXT,
    rating INT NOT NULL,
    date_approved DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
