CREATE TABLE tbl_phil_provinces
(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    prov_code VARCHAR(255) NOT NULL,
    reg_code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);