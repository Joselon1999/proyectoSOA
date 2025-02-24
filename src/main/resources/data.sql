INSERT INTO ROL (name)
VALUES
    ('ADMIN'),
    ('HELPER');

INSERT INTO USERS (username, email, password, enabled)
VALUES
    ('u19300224@utp.edu.pe', 'u19300224@utp.edu.pe', '$2a$12$cvT5dLzgwyPRUKywdYCtXeg2J7SNSyJGAsrhDJjJnuQNiZz.K/fxu', true),
    ('U22232669@utp.edu.pe', 'U22232669@utp.edu.pe', '$2a$12$cvT5dLzgwyPRUKywdYCtXeg2J7SNSyJGAsrhDJjJnuQNiZz.K/fxu', true),
    ('U19303946@utp.edu.pe', 'U19303946@utp.edu.pe', '$2a$12$cvT5dLzgwyPRUKywdYCtXeg2J7SNSyJGAsrhDJjJnuQNiZz.K/fxu', true),
    ('U17300750@utp.edu.pe', 'U17300750@utp.edu.pe', '$2a$12$cvT5dLzgwyPRUKywdYCtXeg2J7SNSyJGAsrhDJjJnuQNiZz.K/fxu', true),
    ('helper1@mail.com', 'helper1@mail.com', '$2a$12$cvT5dLzgwyPRUKywdYCtXeg2J7SNSyJGAsrhDJjJnuQNiZz.K/fxu', true);

INSERT INTO USER_ROLES (id_usuario, id_rol)
VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 2),
    (3, 1),
    (3, 2),
    (4, 1),
    (4, 2),
    (5, 1),
    (5, 2);

INSERT INTO categoria (nom_categoria, estado)
VALUES
    ('Calzado', 1),
    ('Accesorios', 1);

INSERT INTO subcategoria (nom_categoria,CATEGORIA_ID, estado)
VALUES
    ('Botines',1,1),
    ('Balerinas',1,1),
    ('Botas y botines',1,1),
    ('Mocasinens',1,1),
    ('Pantuflas',1,1),
    ('Sandalias',1,1),
    ('Tacos',1,1),
    ('Zapatos',1,1),
    ('Zapatos de vestir',1,1),
    ('Zapatillas',1,1);

INSERT INTO tipoproducto (nom_categoria, estado)
VALUES
    ('Mujer',1),
    ('Niño',1),
    ('Niña',1),
    ('Escolar',1);


INSERT INTO PRODUCTO(cantidad,desc_producto,estado_producto,
fecha_ingreso,usuario_id_usuario,categoria_id,subcategoria_id)
VALUES
(10,'Zapato Mocasín Negro 1CZL002','true','2025-01-01',1,1,4),
(9,'Zapato De Vestir Wisky 1VGW012','true','2025-01-01',1,1,9),
(11,'Zapato De Vestir Dark Brown 1VGW012','true','2025-01-01',1,1,9),
(5,'Zapatilla Urbana Tan 1UDX002','true','2025-01-01',1,1,10);



INSERT INTO sedes (nombre, direccion)
VALUES
    ('Calimod Store - Mall Aventura Santa Anita','Mall Aventura Santa Anita'),
    ('Calimod - Plaza San Miguel','Plaza San Miguel'),
    ('Calimod - Av. Brasil','Av. Brasil 730'),
    ('Calimod Arequipa','Arequipa');

INSERT INTO despacho (estado, uuid, sedes_id_sedes)
VALUES
    (true,'7546bc3b-6b19-4884-b436-f60f42a9b8bb',1),
    (true,'517e02bb-3bf1-40ca-b9cc-a4e68bd0defd',1),
    (true,'6cf4db0d-ff27-4998-9353-754a8906470a',1),
    (true,'001d27fc-0fc7-44b2-8267-5836997e9a14',1);

INSERT INTO productocantidad (cantidad, uuid, producto_id_producto)
VALUES
    (1,'7546bc3b-6b19-4884-b436-f60f42a9b8bb',1),
    (2,'517e02bb-3bf1-40ca-b9cc-a4e68bd0defd',2),
    (3,'6cf4db0d-ff27-4998-9353-754a8906470a',3),
    (4,'001d27fc-0fc7-44b2-8267-5836997e9a14',4);


INSERT INTO transportista (disponible, nombre)
VALUES
    (true,'Jose Jose'),
    (true,'Luis Miguel'),
    (true,'Julio Cesar'),
    (true,'Mario Brasil');
