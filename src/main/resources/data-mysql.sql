--insert into `user` (username, password, activated, email) values ('admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', true, 'admin@ejemplo.com');


--insert into `user` (username, password, activated, email) values ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', true, 'user@ejemplo.com');

--insert into authority (authority_name) values ('ROLE_USER');
--insert into authority (authority_name) values ('ROLE_ADMIN');

--insert into user_authority (user_id, authority_name) values (5, 'ROLE_USER');
--insert into user_authority (user_id, authority_name) values (5, 'ROLE_ADMIN');
--insert into user_authority (user_id, authority_name) values (6, 'ROLE_USER');

--insert into `tipocambio` (id, monedaorigen, monedadestino, cambio) values (1, 'PE', 'US', 0.271);
--insert into `tipocambio` (id, monedaorigen, monedadestino, cambio) values (2, 'US', 'PE', 3.69);

--insert into menu(id, nombre, url, hijo) values(1, 'inicio', '/', 0);
--insert into menu(id, nombre, url, hijo) values(2, 'usuarios', '/usuarios', 1);
--insert into menu(id, nombre, url, hijo) values(3, 'tarjeta', '/tarjeta', 1);

--insert into tarjetacredito(id, titular, numerotarjeta, fecha_expiracion, cvv) values(1, 'Pedro Gonzales', '1234567812345678', '02/26', '337');
--insert into tarjetacredito(id, titular, numerotarjeta, fecha_expiracion, cvv) values(2, 'Maria Marcano', '9234567812345678', '02/28', '338');
--insert into tarjetacredito(id, titular, numerotarjeta, fecha_expiracion, cvv) values(3, 'Talia Rodriguez', '8234567812345678', '02/26', '339');
