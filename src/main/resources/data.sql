INSERT INTO account (owner_name, type, balance) VALUES ('Sai', 'SAVINGS', 1000.00);
INSERT INTO account (owner_name, type, balance) VALUES ('Test User', 'CHECKING', 500.00);
INSERT INTO account (owner_name, type, balance) VALUES ('Alice Johnson', 'SAVINGS', 3500.00);
INSERT INTO account (owner_name, type, balance) VALUES ('Bob Smith', 'CHECKING', 1200.50);
INSERT INTO account (owner_name, type, balance) VALUES ('Carlos Rivera', 'SAVINGS', 780.00);
INSERT INTO account (owner_name, type, balance) VALUES ('Diana Patel', 'CHECKING', 9100.75);
INSERT INTO account (owner_name, type, balance) VALUES ('Ethan Wong', 'SAVINGS', 250.00);
INSERT INTO account (owner_name, type, balance) VALUES ('Fatima Khan', 'CHECKING', 4300.00);
INSERT INTO account (owner_name, type, balance) VALUES ('George Miller', 'SAVINGS', 670.90);
INSERT INTO account (owner_name, type, balance) VALUES ('Hannah Lee', 'CHECKING', 15400.00);
INSERT INTO account (owner_name, type, balance) VALUES ('Ivan Petrov', 'SAVINGS', 999.99);
INSERT INTO account (owner_name, type, balance) VALUES ('Julia Brown', 'CHECKING', 50.00);





-- Transactions (TRANSFERS)
INSERT INTO transaction (amount, created_at, from_account_id, to_account_id, type)
VALUES (150.00, CURRENT_TIMESTAMP, 1, 2, 'TRANSFER');

INSERT INTO transaction (amount, created_at, from_account_id, to_account_id, type)
VALUES (75.50, CURRENT_TIMESTAMP, 3, 4, 'TRANSFER');

INSERT INTO transaction (amount, created_at, from_account_id, to_account_id, type)
VALUES (20.00, CURRENT_TIMESTAMP, 2, 1, 'TRANSFER');

INSERT INTO transaction (amount, created_at, from_account_id, to_account_id, type)
VALUES (500.00, CURRENT_TIMESTAMP, 4, 5, 'TRANSFER');

INSERT INTO transaction (amount, created_at, from_account_id, to_account_id, type)
VALUES (60.00, CURRENT_TIMESTAMP, 6, 3, 'TRANSFER');

