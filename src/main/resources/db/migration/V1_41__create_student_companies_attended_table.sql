-- Version 41
-- Create tbl_student_companies_attended table

CREATE TABLE tbl_student_companies_attended (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    student_course_id VARCHAR(36) NOT NULL REFERENCES tbl_student_courses(id),
    moa_id VARCHAR(36) NOT NULL REFERENCES tbl_moas(id),
    designation VARCHAR(255) NOT NULL,
    hours INT NOT NULL DEFAULT 0,
    date_start DATE NOT NULL,
    date_end DATE,
    finished_at DATE,
    cancelled_at DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
