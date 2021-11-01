
create table invoice_type (
    id character varying(36) NOT NULL,
    created timestamp without time zone,
    created_by character varying(255),
    last_updated_by character varying(255),
    status_record character varying(255) NOT NULL,
    updated timestamp without time zone,
    code character varying(100) NOT NULL,
    name character varying(100) NOT NULL
);

ALTER TABLE ONLY invoice_type
    ADD CONSTRAINT invoice_type_pkey PRIMARY KEY (id);

create table invoice (
    id character varying(36) NOT NULL,
    created timestamp without time zone,
    created_by character varying(255),
    last_updated_by character varying(255),
    status_record character varying(255) NOT NULL,
    updated timestamp without time zone,
    amount numeric(19,2) NOT NULL,
    description character varying(255) NOT NULL,
    due_date date NOT NULL,
    invoicen_number character varying(100) NOT NULL,
    paid boolean NOT NULL,
    id_invoice_type character varying(255) NOT NULL,
    CONSTRAINT invoice_amount_check CHECK ((amount >= (0)::numeric))
);

ALTER TABLE ONLY invoice
    ADD CONSTRAINT invoice_pkey PRIMARY KEY (id);
ALTER TABLE ONLY invoice
    ADD CONSTRAINT invoice_unique_number UNIQUE (invoicen_number);
ALTER TABLE ONLY invoice
    ADD CONSTRAINT fkco4sbxv9cj2oevm6cdpq76ffb FOREIGN KEY (id_invoice_type) REFERENCES invoice_type(id);

create table payment_provider (
    id character varying(36) NOT NULL,
    name character varying(100) NOT NULL,
    code character varying(100) NOT NULL,
    created timestamp without time zone,
    created_by character varying(255),
    last_updated_by character varying(255),
    status_record character varying(255) NOT NULL,
    updated timestamp without time zone,
    logo character varying(255)
);

ALTER TABLE ONLY payment_provider
    ADD CONSTRAINT payment_provider_pkey PRIMARY KEY (id);
ALTER TABLE ONLY payment_provider
    ADD CONSTRAINT payment_provider_unique_code UNIQUE (code);

create table invoice_type_provider (
    id_invoice_type character varying(36) NOT NULL,
    id_payment_provider character varying(36) NOT NULL
);

ALTER TABLE ONLY invoice_type_provider
    ADD CONSTRAINT invoice_type_provider_pkey PRIMARY KEY (id_invoice_type, id_payment_provider);
ALTER TABLE ONLY invoice_type_provider
    ADD CONSTRAINT fk_invoice_type_provider_type FOREIGN KEY (id_invoice_type) REFERENCES invoice_type(id);
ALTER TABLE ONLY invoice_type_provider
    ADD CONSTRAINT fk_invoice_type_provider_provider FOREIGN KEY (id_payment_provider) REFERENCES payment_provider(id);

create table virtual_account (
     id character varying(36) NOT NULL,
    created timestamp without time zone,
    created_by character varying(255),
    last_updated_by character varying(255),
    status_record character varying(255) NOT NULL,
    updated timestamp without time zone,
    account_number character varying(255) NOT NULL,
    company_id character varying(255) NOT NULL,
    virtual_account_type character varying(255) NOT NULL,
    id_invoice character varying(255) NOT NULL,
    id_payment_provider character varying(255) NOT NULL
);

ALTER TABLE ONLY virtual_account
    ADD CONSTRAINT virtual_account_pkey PRIMARY KEY (id);
ALTER TABLE ONLY virtual_account
    ADD CONSTRAINT fkbbdwdxpgdisiikyyhf2xteblc FOREIGN KEY (id_invoice) REFERENCES invoice(id);



create table payment (
    id character varying(36) NOT NULL,
    created timestamp without time zone,
    created_by character varying(255),
    last_updated_by character varying(255),
    status_record character varying(255) NOT NULL,
    updated timestamp without time zone,
    amount numeric(19,2) NOT NULL,
    provider_reference character varying(255) NOT NULL,
    transaction_time timestamp without time zone NOT NULL,
    id_virtual_account character varying(255) NOT NULL,
    CONSTRAINT payment_amount_check CHECK ((amount >= (1)::numeric))
);

ALTER TABLE ONLY payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (id);
ALTER TABLE ONLY payment
    ADD CONSTRAINT fkptriq88d7e8io9mhri8p10cq0 FOREIGN KEY (id_virtual_account) REFERENCES virtual_account(id);

