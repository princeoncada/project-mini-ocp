-- Version 2.23
-- Seed tbl_courses table

-- Retrieve dummy user id
SET @USER_ID = (SELECT id FROM tbl_users WHERE first_name = 'Dummy');
SET @ACADEMIC_YEAR_ID = (SELECT id FROM tbl_academic_years WHERE year_from = 2020);
SET @TERM_ID = (SELECT id FROM tbl_terms WHERE code = '1T');

INSERT INTO tbl_courses (id, academic_year_id, term_id, name, code, instructor_id, is_active)
VALUES (UUID(), @ACADEMIC_YEAR_ID, @TERM_ID, 'Some Course', 'SC', @USER_ID, TRUE);