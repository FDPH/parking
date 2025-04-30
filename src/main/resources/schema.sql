CREATE TABLE prices (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        price_per_hour DECIMAL(14,2) NOT NULL,
                        type VARCHAR(50) NOT NULL
);

CREATE TABLE parkingslots (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              slot_number VARCHAR(4) NOT NULL,
                              type VARCHAR(255) NOT NULL,
                              update_at TIMESTAMP NOT NULL,
                              is_available BOOLEAN NOT NULL
);