\c todo;

CREATE TABLE IF NOT EXISTS items(
    uid int NOT NULL,
    task VARCHAR(255) NOT NULL,
    PRIMARY KEY(uid)
);