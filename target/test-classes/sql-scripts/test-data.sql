CREATE TABLE IF NOT EXISTS movies(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    name_director VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL
);

INSERT INTO movies (name, name_director,minutes, genre) VALUES
    ('Dark Knight', 'Christopher Nolan', 152, 'ACTION'),
    ('Memento','Christopher Nolan', 113, 'THRILLER'),
    ('Matrix', 'Wachowski', 136, 'ACTION');