-- Version 43
-- Create tbl_moa_position_programs table

CREATE TABLE tbl_moa_position_programs (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    program_id VARCHAR(36) NOT NULL REFERENCES tbl_programs(id),
    moa_position_id VARCHAR(36) NOT NULL REFERENCES tbl_moa_positions(id),
    students_accommodated INTEGER,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE (program_id, moa_position_id)
);
