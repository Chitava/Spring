CREATE TABLE IF NOT EXISTS notes
(
    id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY,
    annotation VARCHAR (200),
    status VARCHAR (22),
    time DATETIME
);
