-- Version 2.1
-- Seed tbl_permissions table

-- Insert Entries
INSERT INTO tbl_permissions (id, name) VALUES

-- Roles
(UUID(), 'role-get'),
(UUID(), 'role-give'),
(UUID(), 'user-role-remove'),

-- Meeting Status
(UUID(), 'meeting_status_create'),
(UUID(), 'meeting_status_update'),
(UUID(), 'meeting_status_remove'),

-- Meeting Types
(UUID(), 'meeting_type_create'),
(UUID(), 'meeting_type_update'),
(UUID(), 'meeting_type_remove'),

-- Links
(UUID(), 'link_create'),
(UUID(), 'link_update'),
(UUID(), 'link_remove'),

-- Link Types
(UUID(), 'link_type_create'),
(UUID(), 'link_type_update'),
(UUID(), 'link_type_remove'),

-- Academic Years
(UUID(), 'academic_year_create'),
(UUID(), 'academic_year_update'),
(UUID(), 'academic_year_remove'),

-- Terms
(UUID(), 'term_create'),
(UUID(), 'term_update'),
(UUID(), 'term_remove'),

-- Partnership Types
(UUID(), 'partnership_create'),
(UUID(), 'partnership_update'),
(UUID(), 'partnership_remove'),

-- Industry Types
(UUID(), 'industry_type_create'),
(UUID(), 'industry_type_update'),
(UUID(), 'industry_type_remove'),

-- Departments
(UUID(), 'department_create'),
(UUID(), 'department_update'),
(UUID(), 'department_remove'),

-- Programs
(UUID(), 'program_create'),
(UUID(), 'program_update'),
(UUID(), 'program_remove'),

-- MC Statuses
(UUID(), 'mc_status_create'),
(UUID(), 'mc_status_update'),
(UUID(), 'mc_status_remove'),

-- Company Categories
(UUID(), 'company_category_create'),
(UUID(), 'company_category_update'),
(UUID(), 'company_category_remove'),

-- OJT Delivery Modes
(UUID(), 'ojt_delivery_mode_create'),
(UUID(), 'ojt_delivery_mode_update'),
(UUID(), 'ojt_delivery_mode_remove'),

-- Countries
(UUID(), 'country_create'),
(UUID(), 'country_update'),
(UUID(), 'country_remove'),

-- Files
(UUID(), 'file_upload'),
(UUID(), 'file_update'),
(UUID(), 'file_remove'),

-- Philippine Regions
(UUID(), 'regions_create'),
(UUID(), 'regions_update'),
(UUID(), 'regions_remove'),

-- Philippine Provinces
(UUID(), 'provinces_create'),
(UUID(), 'provinces_update'),
(UUID(), 'provinces_remove'),

-- Philippine City/Municipalities
(UUID(), 'city_municipalities_create'),
(UUID(), 'city_municipalities_update'),
(UUID(), 'city_municipalities_remove'),

-- Philippine Barangays
(UUID(), 'barangays_create'),
(UUID(), 'barangays_update'),
(UUID(), 'barangays_remove'),

-- Companies
(UUID(), 'companies_create'),
(UUID(), 'companies_update'),
(UUID(), 'companies_remove'),

-- Company Branches
(UUID(), 'company_branch_create'),
(UUID(), 'company_branch_update'),
(UUID(), 'company_branch_remove'),

-- Meetings
(UUID(), 'meeting_create'),
(UUID(), 'meeting_update'),
(UUID(), 'meeting_remove'),

-- MOA
(UUID(), 'moa_create'),
(UUID(), 'moa_update'),
(UUID(), 'moa_remove'),

-- MOA Program
(UUID(), 'moa_position_create'),
(UUID(), 'moa_position_update'),
(UUID(), 'moa_position_remove'),

-- MOA OJT Delivery Mode
(UUID(), 'moa_ojt_delivery_mode_create'),
(UUID(), 'moa_ojt_delivery_mode_remove'),

-- MOA Partnership Type
(UUID(), 'moa_partnership_type_create'),
(UUID(), 'moa_partnership_type_remove'),

-- MOA Program Position
(UUID(), 'moa_position_program_create'),
(UUID(), 'moa_position_program_remove'),

-- MC Status Updates
(UUID(), 'mc_status_updates_create'),
(UUID(), 'mc_status_updates_update'),
(UUID(), 'mc_status_updates_remove'),

-- Content
(UUID(), 'content_create'),
(UUID(), 'content_update'),
(UUID(), 'content_remove'),

-- Permission
(UUID(), 'permission_give'),
(UUID(), 'permission_remove');
