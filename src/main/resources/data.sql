INSERT INTO ROL (name)
VALUES
    ('ADMIN'),
    ('HELPER');

INSERT INTO USERS (username, email, password, enabled)
VALUES
    ('u19300224@utp.edu.pe', 'u19300224@utp.edu.pe', '$2a$12$cvT5dLzgwyPRUKywdYCtXeg2J7SNSyJGAsrhDJjJnuQNiZz.K/fxu', true),
    ('U22232669@utp.edu.pe', 'U22232669@utp.edu.pe', '$2a$12$cvT5dLzgwyPRUKywdYCtXeg2J7SNSyJGAsrhDJjJnuQNiZz.K/fxu', true),
    ('U19303946@utp.edu.pe', 'U19303946@utp.edu.pe', '$2a$12$cvT5dLzgwyPRUKywdYCtXeg2J7SNSyJGAsrhDJjJnuQNiZz.K/fxu', true),
    ('helper1@mail.com', 'helper1@mail.com', '$2a$12$cvT5dLzgwyPRUKywdYCtXeg2J7SNSyJGAsrhDJjJnuQNiZz.K/fxu', true);

INSERT INTO USER_ROLES (id_usuario, id_rol)
VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 2),
    (4, 1),
    (4, 2),
    (3, 1),
    (3, 2);

INSERT INTO categoria (nom_categoria, estado)
VALUES
    ('Frutas y Verduras', 1),
    ('Carnes y Pescados', 1),
    ('Lácteos y Huevos', 1),
    ('Panadería y Repostería', 1),
    ('Abarrotes', 1),
    ('Bebidas', 1);


INSERT INTO PRODUCTO(CANTIDAD,DESC_PRODUCTO,ESTADO_PRODUCTO,
FECHA_INGRESO,USUARIO_ID_USUARIO,CATEGORIA_ID)
VALUES
(100,'Z','true','2024-11-01',1,2),
(90,'Bolsa de Arroz de 1kg','true','2024-11-01',1,5),
(110,'Lata de durazno','true','2024-11-01',1,1),
(50,'Bolsa de lentejas de 1kg','true','2024-11-01',1,5);

INSERT INTO HISTORICO_ALIMENTARIA (CANTIDAD,FECHA_USO,PRODUCTO_ID_PRODUCTO)
VALUES
(100,'2024-12-01',1),
(90,'2024-12-01',2),
(110,'2024-12-01',3),
(50,'2024-12-01',4);
