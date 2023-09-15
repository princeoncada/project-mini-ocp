-- Version 37
-- Create tbl_req_submissions table

CREATE TABLE tbl_req_submissions (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    user_id VARCHAR(36) NOT NULL REFERENCES tbl_users(id),
    student_course_id VARCHAR(36) NOT NULL REFERENCES tbl_student_courses(id),
    requirement_id VARCHAR(36) NOT NULL REFERENCES tbl_requirements(id),
    status INT NOT NULL,
    message TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
