INSERT INTO movie (id, name, language, genre) VALUES
                                                  (1, 'Avengers', 'English', 'Action'),
                                                  (2, 'KGF', 'Kannada', 'Action');

INSERT INTO theatre (id, name, city) VALUES
                                         (1, 'PVR Whitefield', 'Bangalore'),
                                         (2, 'INOX Forum Mall', 'Bangalore'),
                                         (3, 'Cinepolis BTM', 'Bangalore');

INSERT INTO show (id, movie_id, theatre_id, start_time, price) VALUES
                                                                    (1, 1, 1, '2026-04-20T10:00:00', 250),
                                                                    (2, 1, 1, '2026-04-20T14:00:00', 300),
                                                                    (3, 1, 2, '2026-04-20T18:00:00', 280),
                                                                    (4, 2, 3, '2026-04-20T16:00:00', 200);

INSERT INTO show_seat (id, show_id, seat_number, status) VALUES
                                                             (1, 1, 'A1', 'AVAILABLE'),
                                                             (2, 1, 'A2', 'AVAILABLE'),
                                                             (3, 1, 'A3', 'AVAILABLE'),
                                                             (4, 2, 'B1', 'AVAILABLE'),
                                                             (5, 2, 'B2', 'AVAILABLE'),
                                                             (6, 3, 'C1', 'AVAILABLE');

