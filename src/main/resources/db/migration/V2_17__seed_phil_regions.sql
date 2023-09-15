-- Version 2.17
-- Seed tbl_phil_regions table

-- Insert Entries
INSERT INTO tbl_phil_regions (id, reg_code, name)
SELECT UUID(), regCode, regDesc
FROM refregion;