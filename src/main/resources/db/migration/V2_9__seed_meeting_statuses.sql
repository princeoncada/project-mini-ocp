-- Version 2.9
-- Seed tbl_meeting_statuses table

-- Insert Entries
INSERT INTO tbl_meeting_statuses (id, name) VALUES
(UUID(), 'Cancelled'),
(UUID(), 'Pending for Approval'),
(UUID(), 'Pending'),
(UUID(), 'Finished'),
(UUID(), 'N/A');
