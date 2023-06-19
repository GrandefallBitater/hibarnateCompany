# hibarnateCompany
для запуска программы необходимо создать базу данных с нозванием Hibernate и создать 2 таблицы с помощью следующего кода

      CREATE TABLE IF NOT EXISTS public.company
      (
          name text COLLATE pg_catalog."default" NOT NULL,
          income integer NOT NULL,
          CONSTRAINT company_pkey PRIMARY KEY (name)
      )

    TABLESPACE pg_default;
    
    ALTER TABLE IF EXISTS public.company
    OWNER to postgres;

    CREATE TABLE IF NOT EXISTS public.employee

    (

    id integer NOT NULL DEFAULT nextval('employee_id_seq'::regclass),
    
    mounthsalary integer NOT NULL,
    
    personal_income integer,
    type integer NOT NULL,
    company_name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (id),
    CONSTRAINT "FK_name" FOREIGN KEY (company_name)
        REFERENCES public.company (name) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID 
    )

    TABLESPACE pg_default;
        
    ALTER TABLE IF EXISTS public.employee    
    OWNER to postgres;
