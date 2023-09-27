-- Version 2.22
-- Seed tbl_user_roles table

-- Retrieve dummy user id
SET @USER_ID = (SELECT id FROM tbl_users WHERE first_name = 'Dummy');
SET @ROLE_ID = (SELECT id FROM tbl_roles WHERE `name` = 'wica');

SET @PRINCE_USER_ID = (SELECT id FROM tbl_users WHERE first_name = 'Prince');
SET @ADMIN_ROLE_ID = (SELECT id FROM tbl_roles WHERE `name` = 'admin');

-- Insert Entry
INSERT INTO tbl_user_roles (id, user_id, role_id)
VALUES (UUID(), @USER_ID, @ROLE_ID);

INSERT INTO tbl_user_roles (id, user_id, role_id)
VALUES (UUID(), @PRINCE_USER_ID, @ADMIN_ROLE_ID);
