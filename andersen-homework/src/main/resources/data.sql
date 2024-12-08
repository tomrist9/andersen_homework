create
database my_ticket_service_db;

CREATE TYPE ticket_type AS ENUM('DAY', 'WEEK', 'MONTH', 'YEAR');



CREATE table "User"
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE table "Ticket"
(
    id            SERIAL PRIMARY KEY,
    user_id       INT         NOT NULL,
    ticket_type   ticket_type NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);