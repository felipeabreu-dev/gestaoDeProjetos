CREATE TABLE tasks(
    id INTEGER PRIMARY KEY NOT NULL,
    title VARCHAR(150) NOT NULL,
    description VARCHAR(255),
    status VARCHAR(20) NOT NULL,
    priority VARCHAR(20) NOT NULL,
    due_date DATE NOT NULL,
    CONSTRAINT chk_status CHECK (status IN ('TODO', 'DOING', 'DONE')),
    CONSTRAINT chk_priority CHECK (priority IN ('LOW', 'MEDIUM', 'HIGH'))
);