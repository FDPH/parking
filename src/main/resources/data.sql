INSERT INTO prices (price_per_hour, type)
VALUES (62.00, 'MOTORCYCLE');
INSERT INTO prices (price_per_hour, type)
VALUES (120.00, 'CAR');

INSERT INTO parkingslots (slot_number, type, update_at, is_available)
VALUES ('M1', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('M2', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('M3', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('M4', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('M5', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('M6', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('V1', 'CAR', CURRENT_TIMESTAMP, true),
       ('V2', 'CAR', CURRENT_TIMESTAMP, true),
       ('V3', 'CAR', CURRENT_TIMESTAMP, true),
       ('V4', 'CAR', CURRENT_TIMESTAMP, true),
       ('V5', 'CAR', CURRENT_TIMESTAMP, true);