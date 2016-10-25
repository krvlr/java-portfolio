CREATE DATABASE cars_users
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE TABLE public.users
(
    id_user bigserial NOT NULL,
    first_name text NOT NULL,
    last_name text NOT NULL,
    date_of_birth date NOT NULL,
    city text NOT NULL,
    login text NOT NULL,
    password text NOT NULL,
    token text,
    PRIMARY KEY (id_user)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;
ALTER TABLE public.users
    OWNER to postgres;

CREATE TABLE public.cars
(
    id_car bigserial NOT NULL,
    brand text NOT NULL,
    model text NOT NULL,
    mileage integer NOT NULL,
    colour text NOT NULL,
    PRIMARY KEY (id_car)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;
ALTER TABLE public.cars
    OWNER to postgres;

CREATE TABLE cars_users (
	id_car bigint references cars(id_car) NOT NULL,
	id_user bigint references users(id_user) NOT NULL);