-- Version 2.18
-- Seed tbl_phil_provinces table

-- Insert Entries
INSERT INTO tbl_phil_provinces (id, prov_code, reg_code, name)
SELECT UUID(), provCode, regCode, provDesc
FROM refprovince;
