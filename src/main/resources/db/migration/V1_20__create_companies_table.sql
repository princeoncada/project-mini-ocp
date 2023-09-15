CREATE TABLE tbl_companies
(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    company_category_id VARCHAR(36) NOT NULL,
    industry_type_id VARCHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (company_category_id) REFERENCES tbl_company_categories(id),
    FOREIGN KEY (industry_type_id) REFERENCES tbl_industry_types(id)
);