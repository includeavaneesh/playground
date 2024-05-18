\c todo;

CREATE TABLE IF NOT EXISTS todo(
    uid int NOT NULL,
    task text NOT NULL,
    iscompleted boolean NOT NULL,
    assignedto VARCHAR(255) NOT NULL,
    PRIMARY KEY(uid)
);