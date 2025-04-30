INSERT INTO prices (price_per_hour, type)
VALUES (62.00, 'MOTORCYCLE');
INSERT INTO prices (price_per_hour, type)
VALUES (120.00, 'LIGHT_VEHICLE');

INSERT INTO parkingslots (slot_number, type, update_at, is_available)
VALUES ('M1', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('M2', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('M3', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('M4', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('M5', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('M6', 'MOTORCYCLE', CURRENT_TIMESTAMP, true),
       ('V1', 'LIGHT_VEHICLE', CURRENT_TIMESTAMP, true),
       ('V2', 'LIGHT_VEHICLE', CURRENT_TIMESTAMP, true),
       ('V3', 'LIGHT_VEHICLE', CURRENT_TIMESTAMP, true),
       ('V4', 'LIGHT_VEHICLE', CURRENT_TIMESTAMP, true),
       ('V5', 'LIGHT_VEHICLE', CURRENT_TIMESTAMP, true);