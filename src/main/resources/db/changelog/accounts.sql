-- changeset account:1
CREATE TABLE accounts
(
    id           BIGSERIAL,
    is_return    BOOLEAN,
    borrow_price DOUBLE PRECISION,
    borrow_date  TIMESTAMP,
    return_date  TIMESTAMP,
    student_id   INTEGER,
    book_id      INTEGER,
    PRIMARY KEY (id)
);
-- rollback drop table accounts