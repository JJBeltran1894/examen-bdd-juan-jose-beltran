-- PARTE 1

CREATE DATABASE examen_bdd;

-- 1.1 CREACION TABLA VUELOS

CREATE TABLE vuelos (
	id serial primary key,
	codigo varchar(10) not null unique,
	precio_boleto numeric(10,2) not null check (precio_boleto >= 0),
	asientos_disponibles int not null check (asientos_disponibles >=0)
);

-- 1.2 INSERCIONES

insert into vuelos (codigo, precio_boleto, asientos_disponibles) values
('LA-101', 250.50, 120),
('LA-102', 180.00, 4),
('AV-201', 320.75, 45),
('AV-202', 290.00, 0),
('CM-301', 450.20, 80),
('CM-302', 150.00, 15),
('IB-401', 850.00, 2),
('IB-402', 920.50, 200),
('AA-501', 310.00, 0),
('AA-502', 400.00, 3),
('DL-601', 275.25, 60),
('DL-602', 300.00, 10),
('UA-701', 500.00, 150),
('UA-702', 480.50, 4),
('AM-801', 210.00, 30),
('AM-802', 190.00, 0),
('KL-901', 1050.00, 25),
('KL-902', 1100.00, 1),
('AF-001', 980.00, 18),
('AF-002', 1200.00, 0);

-- 1.3  CONSULTAS SQL REQUERIDAS

-- Alerta de Vuelo Lleno

select * from vuelos where asientos_disponibles < 5;

-- Incremento de Tarifas
update vuelos set precio_boleto = precio_boleto*1.15
where id = 12;
-- Depuración de Rutas Canceladas
delete vuelos where asientos_disponibles = 0;
