-- Version 2.3
-- Seed tbl_programs table

-- Retrieve department ids
SET @CCIS_ID = (SELECT id FROM tbl_departments WHERE abbr = 'CCIS');
SET @CAS_ID = (SELECT id FROM tbl_departments WHERE abbr = 'CAS');
SET @CEA_ID = (SELECT id FROM tbl_departments WHERE abbr = 'CEA');
SET @ATYCB_ID = (SELECT id FROM tbl_departments WHERE abbr = 'ATYCB');
SET @SHS_ID = (SELECT id FROM tbl_departments WHERE abbr = 'SHS');

-- Insert Entries
INSERT INTO tbl_programs (id, department_id, name, abbr) VALUES
-- CCIS
(UUID(), @CCIS_ID, 'Bachelor of Science in Computer Science', 'CS'),
(UUID(), @CCIS_ID, 'Bachelor of Science in Entertainment and Multimedia Computing', 'EMC'),
(UUID(), @CCIS_ID, 'Bachelor of Science in Information Systems', 'IS'),

-- CAS
(UUID(), @CAS_ID, 'Bachelor of Arts in Communication', 'COMM'),
(UUID(), @CAS_ID, 'Bachelor of Multimedia Arts', 'MMA'),
(UUID(), @CAS_ID, 'Bachelor of Science in Biology', 'BIO'),
(UUID(), @CAS_ID, 'Bachelor of Science in Psychology', 'PSYCH'),

-- CEA
(UUID(), @CEA_ID, 'Bachelor of Science in Architecture', 'AR'),
(UUID(), @CEA_ID, 'Bachelor of Science in Chemical Engineering', 'CHE'),
(UUID(), @CEA_ID, 'Bachelor of Science in Civil Engineering', 'CE'),
(UUID(), @CEA_ID, 'Bachelor of Science in Computer Engineering', 'CPE'),
(UUID(), @CEA_ID, 'Bachelor of Science in Electrical Engineering', 'EE'),
(UUID(), @CEA_ID, 'Bachelor of Science in Electronics Engineering', 'ECE'),
(UUID(), @CEA_ID, 'Bachelor of Science in Industrial Engineering', 'IE'),
(UUID(), @CEA_ID, 'Bachelor of Science in Mechanical Engineering', 'ME'),

-- ATYCB
(UUID(), @ATYCB_ID, 'Bachelor of Science in Accountancy', 'ACT'),
(UUID(), @ATYCB_ID, 'Bachelor of Science in Entrepreneurship', 'ENT'),
(UUID(), @ATYCB_ID, 'Bachelor of Science in Management Accounting', 'MA'),
(UUID(), @ATYCB_ID, 'Bachelor of Science in Tourism Management', 'TM'),

-- SHS
(UUID(), @SHS_ID, 'Science, Technology, Engineering and Mathematics', 'STEM'),
(UUID(), @SHS_ID, 'Accountancy, Business and Management', 'ABM'),
(UUID(), @SHS_ID, 'Humanities and Social Sciences', 'HUMSS'),
(UUID(), @SHS_ID, 'Arts and Design Track', 'AD'),
(UUID(), @SHS_ID, 'Technical-Vocational and Livelihood Track - Programming', 'ICT-PRG'),
(UUID(), @SHS_ID, 'Technical-Vocational and Livelihood Track - Animation', 'ICT-ANI');
