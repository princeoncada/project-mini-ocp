-- Version 29
-- Create tbl_moa_positions table

CREATE TABLE tbl_moa_positions (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    moa_id VARCHAR(36) NOT NULL REFERENCES tbl_moas(id),
    academic_year_id VARCHAR(36) REFERENCES tbl_academic_years(id),
    name VARCHAR(255) NOT NULL,
    requirements TEXT,
    students_accommodated INT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
