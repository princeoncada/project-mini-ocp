-- Version 2.19
-- Seed tbl_phil_city_municipalities table

-- Insert Entries
INSERT INTO tbl_phil_city_municipalities (id, mun_code, prov_code, name)
SELECT UUID(), citymunCode, provCode, citymunDesc
FROM refcitymun;
