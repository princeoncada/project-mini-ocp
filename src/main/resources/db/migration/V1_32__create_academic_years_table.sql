-- Version 32
-- Create tbl_academic_years table

CREATE TABLE tbl_academic_years (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    year_from INT NOT NULL,
    year_to INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
