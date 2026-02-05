CREATE TABLE animals (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100),
                         age INT,
                         species VARCHAR(100),
                         animal_type VARCHAR(100)
);

CREATE TABLE zookeepers (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100),
                            age INT,
                            gender VARCHAR(50)
);