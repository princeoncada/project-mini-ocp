CREATE TABLE tbl_moas
(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    branch_id VARCHAR(36) NOT NULL,
    title VARCHAR(255),
    start_date DATE,
    expiry_date DATE,
    description TEXT,
    vpaa_submission DATE,
    is_active BOOL DEFAULT FALSE,
    is_hiring BOOL NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (branch_id) REFERENCES tbl_company_branches(id)
);