INSERT INTO
    users (lastname, firstname, username, email, okta_id, created_date)
VALUES
    ('rubio', 'damien', 'damru', 'rubio.damien@gmail.com', '00u12hrl1aLyNjjmW357', SELECT now());


INSERT INTO
    preferences (user_id, rayon)
VALUES
    (1, 1000);
