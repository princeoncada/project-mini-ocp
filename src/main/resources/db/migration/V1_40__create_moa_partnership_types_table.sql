-- Version 40
-- Create tbl_moa_partnership_types table

CREATE TABLE tbl_moa_partnership_types (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    moa_id VARCHAR(36) NOT NULL REFERENCES tbl_moas(id),
    partnership_type_id VARCHAR(36) NOT NULL REFERENCES tbl_partnership_types(id),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);