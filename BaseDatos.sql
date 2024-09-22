-- Database: banco_bdd

DROP DATABASE banco_bdd;

CREATE DATABASE banco_bdd
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Ecuador.1252'
    LC_CTYPE = 'Spanish_Ecuador.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
-- Table: public.persona

 DROP TABLE public.persona;

CREATE TABLE public.persona
(
    id integer NOT NULL DEFAULT nextval('"persona_tbl_idPersona_seq"'::regclass),
    nombre character varying COLLATE pg_catalog."default",
    genero character varying COLLATE pg_catalog."default",
    edad integer,
    identificacion character varying COLLATE pg_catalog."default",
    direccion character varying COLLATE pg_catalog."default",
    telefono character varying COLLATE pg_catalog."default",
    CONSTRAINT persona_tbl_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.persona
    OWNER to postgres;
COMMENT ON TABLE public.persona
    IS 'Tabla Personas';
	
	
-- Table: public.cliente

DROP TABLE public.cliente;

CREATE TABLE public.cliente
(
    id integer NOT NULL DEFAULT nextval('"cliente_tbl_idCliente_seq"'::regclass),
    contrasenia character varying COLLATE pg_catalog."default",
    estado boolean,
    id_persona bigint,
    CONSTRAINT cliente_tbl_pkey PRIMARY KEY (id),
    CONSTRAINT fk_persona_cliente FOREIGN KEY (id_persona)
        REFERENCES public.cliente (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cliente
    OWNER to postgres;
COMMENT ON TABLE public.cliente
    IS 'Tabla para Clientes';
	
-- Table: public.cuenta

DROP TABLE public.cuenta;

CREATE TABLE public.cuenta
(
    id integer NOT NULL DEFAULT nextval('"cuenta_tbl_idCuenta_seq"'::regclass),
    estado boolean,
    id_cliente bigint,
    numero_cuenta character varying(255) COLLATE pg_catalog."default",
    saldo_inicial double precision,
    tipo_cuenta character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT cuenta_tbl_pkey PRIMARY KEY (id),
    CONSTRAINT fk_cuenta_cliente FOREIGN KEY (id_cliente)
        REFERENCES public.cliente (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cuenta
    OWNER to postgres;
COMMENT ON TABLE public.cuenta
    IS 'Tabla para Cuentas bancarias';
	
-- Table: public.movimientos

DROP TABLE public.movimientos;

CREATE TABLE public.movimientos
(
    id integer NOT NULL DEFAULT nextval('"movimientos_tbl_idMovimiento_seq"'::regclass),
    fecha date,
    valor numeric(38,2),
    saldo numeric(38,2),
    id_cuenta bigint,
    tipo_movimiento character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT movimientos_tbl_pkey PRIMARY KEY (id),
    CONSTRAINT fk_movimiento_cuenta FOREIGN KEY (id_cuenta)
        REFERENCES public.cuenta (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.movimientos
    OWNER to postgres;
COMMENT ON TABLE public.movimientos
    IS 'Tabla Movimientos bancarios';
	
-- Table: public.movimientosh

DROP TABLE public.movimientosh;

CREATE TABLE public.movimientosh
(
    id integer NOT NULL DEFAULT nextval('"movimientosh_tbl_idHMovimiento_seq"'::regclass),
    id_movimiento bigint,
    saldo_actual double precision,
    valor_transaccion double precision,
    CONSTRAINT movimientosh_tbl_pkey PRIMARY KEY (id),
    CONSTRAINT fk_movimiento_hist FOREIGN KEY (id_movimiento)
        REFERENCES public.movimientos (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.movimientosh
    OWNER to postgres;
COMMENT ON TABLE public.movimientosh
    IS 'Tabla Histórico de movimientos';