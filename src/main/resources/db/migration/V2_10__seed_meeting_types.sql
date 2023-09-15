-- Version 2.10
-- Seed tbl_meeting_types table

-- Insert Entries
INSERT INTO tbl_meeting_types (id, name, meeting_mode) VALUES
(UUID(), 'Touchpoint Meeting (TPM)', 'Face to Face'),
(UUID(), 'Touchpoint Meeting (TPM)', 'Virtual'),
(UUID(), 'Company Visit', 'Face to Face'),
(UUID(), 'Company Health and Safety Monitoring', 'Face to Face'),
(UUID(), 'Meeting (consultations, discussions, etc.)', 'Virtual'),
(UUID(), 'Meeting (consultations, discussions, etc.)', 'Face to Face');
