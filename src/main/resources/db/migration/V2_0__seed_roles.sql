-- Version 2.0
-- Seed tbl_roles table

-- Insert Entries
INSERT INTO tbl_roles (id, name)
VALUES
    (UUID(), 'admin'),
    (UUID(), 'wica'),
    (UUID(), 'student');
