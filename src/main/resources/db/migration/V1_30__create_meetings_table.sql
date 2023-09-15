-- Version 30
-- Create tbl_meetings table

CREATE TABLE tbl_meetings (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    company_branch_id VARCHAR(36) NOT NULL REFERENCES tbl_company_branches(id),
    title VARCHAR(255),
    meeting_type_id VARCHAR(36) NOT NULL REFERENCES tbl_meeting_types(id),
    start DATE,
    end DATE,
    description TEXT,
    minutes TEXT,
    prepared_by VARCHAR(36) REFERENCES tbl_users(id),
    approved_by VARCHAR(36) REFERENCES tbl_users(id),
    meeting_status_id VARCHAR(36) NOT NULL REFERENCES tbl_meeting_statuses(id),
    meeting_link TEXT,
    recording_link TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);