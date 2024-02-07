--insert into "user" (username, password, nickname, activated, email) values ('admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 1, 'admin@ejemplo.com');
--insert into "user" (username, password, nickname, activated, email) values ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 1, 'user@ejemplo.com');

--insert into authority (authority_name) values ('ROLE_USER');
--insert into authority (authority_name) values ('ROLE_ADMIN');

--insert into user_authority (user_id, authority_name) values (1, 'ROLE_USER');
--insert into user_authority (user_id, authority_name) values (1, 'ROLE_ADMIN');
--insert into user_authority (user_id, authority_name) values (2, 'ROLE_USER');

--insert into "tipocambio" (id, monedaorigen, monedadestino, cambio) values (1, 'PE', 'US', 0.271);
--insert into "tipocambio" (id, monedaorigen, monedadestino, cambio) values (2, 'US', 'PE', 3.69);