-- Version 3.1
-- Create tbl_refresh_tokens

CREATE TABLE tbl_refresh_tokens (
       id VARCHAR(36) NOT NULL PRIMARY KEY,
       user_id VARCHAR(36) NOT NULL REFERENCES tbl_users(id),
       refresh_token TEXT NOT NULL,
       expiration_date DATETIME NOT NULL,
       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);