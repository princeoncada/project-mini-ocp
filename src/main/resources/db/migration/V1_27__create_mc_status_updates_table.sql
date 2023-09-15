CREATE TABLE tbl_mc_status_updates
(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    mc_status_id VARCHAR(36) NOT NULL,
    moa_id VARCHAR(36) NOT NULL,
    notes TEXT,
    mc_approved_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (mc_status_id) REFERENCES tbl_mc_statuses(id),
    FOREIGN KEY (moa_id) REFERENCES tbl_moas(id)
);