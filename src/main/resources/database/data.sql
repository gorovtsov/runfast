INSERT INTO users(id, login, password, name, surname) VALUES (1, 'victor' , 'victorPass', 'Victor', 'Grebenschikov');
INSERT INTO users(id, login, password, name, surname) VALUES (2, 'gena' , 'genaPass', 'Gennady', 'Volosov');
INSERT INTO users(id, login, password, name, surname) VALUES (3, 'petr' , 'petrPass', 'Pyotr', 'Krasnov');

INSERT INTO running_sessions(id, distance, start_time, finish_time, user_id)
VALUES (1, 5234, {ts '2019-02-10 13:47:52.69'}, {ts '2019-02-10 14:47:52.69'}, 1);
INSERT INTO running_sessions(id, distance, start_time, finish_time, user_id)
VALUES (2, 5100, {ts '2019-02-08 13:47:52.69'}, {ts '2019-02-08 14:42:52.69'}, 1);
INSERT INTO running_sessions(id, distance, start_time, finish_time, user_id)
VALUES (3, 10230, {ts '2019-01-10 12:20:52.69'}, {ts '2019-02-08 13:20:52.69'}, 2);
INSERT INTO running_sessions(id, distance, start_time, finish_time, user_id)
VALUES (4, 9800, {ts '2019-01-19 11:30:52.69'}, {ts '2019-02-08 12:20:52.69'}, 3);
INSERT INTO running_sessions(id, distance, start_time, finish_time, user_id)
VALUES (5, 7500, {ts '2019-01-22 12:30:52.69'}, {ts '2019-02-08 13:10:52.69'}, 3);
INSERT INTO running_sessions(id, distance, start_time, finish_time, user_id)
VALUES (6, 8300, {ts '2019-01-25 10:10:52.69'}, {ts '2019-02-08 11:00:52.69'}, 3);


