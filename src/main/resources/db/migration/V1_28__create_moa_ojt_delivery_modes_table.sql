-- Version 28
-- Create tbl_moa_ojt_delivery_modes table

CREATE TABLE tbl_moa_ojt_delivery_modes (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    moa_id VARCHAR(36) NOT NULL REFERENCES moas(id),
    ojt_delivery_mode_id VARCHAR(36) NOT NULL REFERENCES ojt_delivery_modes(id),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);