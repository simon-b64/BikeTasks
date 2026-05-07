CREATE TABLE bike (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,

    brand VARCHAR(255),
    model VARCHAR(255),
    year INT,
    fuel_type VARCHAR(255),

    vin VARCHAR(255),
    license_plate VARCHAR(255),
    initial_registration_date DATE
);