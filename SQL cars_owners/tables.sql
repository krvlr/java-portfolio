CREATE DATABASE cars;

CREATE TABLE public.owners
(
    id_owner bigserial,
    first_name text NOT NULL,
    last_name text NOT NULL,
    date_of_birth date NOT NULL,
    city text NOT NULL,
    PRIMARY KEY (id_owner)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;
ALTER TABLE public.owners
    OWNER to postgres;

CREATE TABLE public.cars
(
    id_car bigserial,
    mileage integer NOT NULL,
    colour text,
    PRIMARY KEY (id_car)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;
ALTER TABLE public.cars
    OWNER to postgres;

    
CREATE TABLE cars_owners (
	id_car bigint references cars(id_car) NOT NULL,
	id_owner bigint references owners(id_owner) NOT NULL);