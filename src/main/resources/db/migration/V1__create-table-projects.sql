CREATE TABLE projects(
    id INTEGER PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    start_date DATE,
    end_date DATE
);