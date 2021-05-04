-- CREATE TABLE users (
--   id SERIAL,
--   name VARCHAR(255) NOT NULL,
--   PRIMARY KEY (id)
-- );
CREATE TABLE public.inquiry (
  id serial NOT NULL,
  "name" varchar(64) NOT NULL,
  email varchar(128) NOT NULL,
  contents text NOT NULL,
  created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT inquiry_pkey PRIMARY KEY (id)
);