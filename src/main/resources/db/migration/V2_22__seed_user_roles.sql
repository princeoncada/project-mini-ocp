-- Version 2.22
-- Seed tbl_user_roles table

-- Retrieve dummy user id
SET @USER_ID = (SELECT id FROM tbl_users WHERE first_name = 'Dummy');
SET @ROLE_ID = (SELECT id FROM tbl_roles WHERE `name` = 'wica');

-- Insert Entry
INSERT INTO tbl_user_roles (id, user_id, role_id)
VALUES (UUID(), @USER_ID, @ROLE_ID);