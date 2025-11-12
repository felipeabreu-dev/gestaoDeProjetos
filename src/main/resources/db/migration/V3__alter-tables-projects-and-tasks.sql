DROP TABLE tasks;
DROP TABLE projects;

CREATE TABLE projects(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    start_date DATE,
    end_date DATE
);

CREATE TABLE tasks(
    id SERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description VARCHAR(255),
    status VARCHAR(20) NOT NULL,
    priority VARCHAR(20) NOT NULL,
    due_date DATE NOT NULL,
    CONSTRAINT chk_status CHECK (status IN ('TODO', 'DOING', 'DONE')),
    CONSTRAINT chk_priority CHECK (priority IN ('LOW', 'MEDIUM', 'HIGH'))
);