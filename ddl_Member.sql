CREATE TABLE members
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    name           VARCHAR(10)           NOT NULL,
    gender         SMALLINT              NOT NULL,
    birth          date                  NOT NULL,
    address        VARCHAR(20)           NOT NULL,
    email          VARCHAR(30)           NOT NULL,
    point          INT                   NULL,
    detail_address VARCHAR(30)           NOT NULL,
    phone_number   VARCHAR(13)           NULL,
    member_status  SMALLINT              NOT NULL,
    socail_type    SMALLINT              NOT NULL,
    created_at     datetime              NOT NULL,
    updated_at     datetime              NOT NULL,
    deleted_at     datetime              NULL,
    CONSTRAINT pk_members PRIMARY KEY (id)
);