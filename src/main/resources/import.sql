SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE flowers;
TRUNCATE TABLE rooms;
SET REFERENTIAL_INTEGRITY TRUE;

INSERT INTO rooms (id, name) VALUES (1, 'Гостиная');
INSERT INTO rooms (id, name) VALUES (2, 'Спальня');
INSERT INTO rooms (id, name) VALUES (3, 'Балкон');

INSERT INTO flowers (id, name, description, watering_interval_days, room_id, last_watering_date) VALUES (1, 'Фикус', 'Крупный куст', 7, 1, '2026-06-01');
INSERT INTO flowers (id, name, description, watering_interval_days, room_id, last_watering_date) VALUES (2, 'Монстера', 'Листья-сердца', 10, 1, '2026-06-01'); 
INSERT INTO flowers (id, name, description, watering_interval_days, room_id, last_watering_date) VALUES (3, 'Драцена', 'Дерево удачи', 14, 1, '2026-06-15');
INSERT INTO flowers (id, name, description, watering_interval_days, room_id, last_watering_date) VALUES (4, 'Сансевиерия', 'Тещин язык', 21, 2, '2026-06-01');
INSERT INTO flowers (id, name, description, watering_interval_days, room_id, last_watering_date) VALUES (5, 'Спатифиллум', 'Женское счастье', 5, 2, '2026-06-17');
INSERT INTO flowers (id, name, description, watering_interval_days, room_id, last_watering_date) VALUES (6, 'Хлорофитум', 'Паучий цветок', 7, 2, '2026-06-05');
INSERT INTO flowers (id, name, description, watering_interval_days, room_id, last_watering_date) VALUES (7, 'Замиокулькас', 'Долларовое дерево', 30, 2, '2026-06-10');
INSERT INTO flowers (id, name, description, watering_interval_days, room_id, last_watering_date) VALUES (8, 'Герань', 'Цветущая', 7, 3, '2026-06-01');
INSERT INTO flowers (id, name, description, watering_interval_days, room_id, last_watering_date) VALUES (9, 'Петуния', 'Яркие цветы', 3, 3, '2026-06-17');
INSERT INTO flowers (id, name, description, watering_interval_days, room_id, last_watering_date) VALUES (10, 'Кактус', 'Колючий', 60, 3, '2026-06-01');
