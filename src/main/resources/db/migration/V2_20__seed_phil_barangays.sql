-- Version 2.20
-- Seed tbl_phil_city_municipalities table

-- Insert Entries
INSERT INTO tbl_phil_barangays (id, mun_code, name)
SELECT UUID(), citymunCode, brgyDesc
FROM refbrgy;