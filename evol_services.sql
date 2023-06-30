--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.24
-- Dumped by pg_dump version 9.6.24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clients (
    id integer NOT NULL,
    name character varying(200) NOT NULL,
    rut character varying(200) NOT NULL,
    business_name character varying(200) NOT NULL,
    start_date timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE public.clients OWNER TO postgres;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clients_id_seq OWNER TO postgres;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clients_id_seq OWNED BY public.clients.id;


--
-- Name: measurers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.measurers (
    id integer NOT NULL,
    physical_address character varying(200) NOT NULL,
    installation_number character varying(200) NOT NULL,
    evol_id character varying(200) NOT NULL
);


ALTER TABLE public.measurers OWNER TO postgres;

--
-- Name: measurers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.measurers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.measurers_id_seq OWNER TO postgres;

--
-- Name: measurers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.measurers_id_seq OWNED BY public.measurers.id;


--
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clients ALTER COLUMN id SET DEFAULT nextval('public.clients_id_seq'::regclass);


--
-- Name: measurers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.measurers ALTER COLUMN id SET DEFAULT nextval('public.measurers_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clients (id, name, rut, business_name, start_date) FROM stdin;
9	try2	17	hellohere	2023-06-28 20:00:00
10	try3	17	hellohere	2023-06-28 20:00:00
11	try3	17	hellohere	2023-06-28 20:00:00
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clients_id_seq', 11, true);


--
-- Data for Name: measurers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.measurers (id, physical_address, installation_number, evol_id) FROM stdin;
1	here2	here1	345
3	Hello2	here3	124
\.


--
-- Name: measurers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.measurers_id_seq', 3, true);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: measurers measurers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.measurers
    ADD CONSTRAINT measurers_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

