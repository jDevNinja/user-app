CREATE TABLE users
(
    id       INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name     varchar,
    lastName varchar,
    age      int
);

CREATE TABLE orders
(
    id          INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    description varchar,
    status      varchar
);
