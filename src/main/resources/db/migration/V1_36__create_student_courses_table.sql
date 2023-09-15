-- Version 36
-- Create tbl_student_courses table

CREATE TABLE tbl_student_courses (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    course_id VARCHAR(36) NOT NULL REFERENCES tbl_courses(id),
    user_id VARCHAR(36) REFERENCES tbl_users(id),
    adviser_id VARCHAR(36) REFERENCES tbl_users(id),
    program_id VARCHAR(36) NOT NULL REFERENCES tbl_programs(id),
    email VARCHAR(255) NOT NULL,
    student_id VARCHAR(255) NOT NULL,
    is_finished BOOLEAN,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE (course_id, email, student_id)
);
