CREATE TABLE refueling (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    bike_id UUID NOT NULL REFERENCES bike(id) ON DELETE CASCADE,
    date DATE NOT NULL,
    odometer_reading INT,
    fuel_amount DECIMAL(10, 2),
    total_cost DECIMAL(10, 2),
    last_refueling_missed BOOLEAN NOT NULL DEFAULT FALSE,
    notes VARCHAR(1000)
);