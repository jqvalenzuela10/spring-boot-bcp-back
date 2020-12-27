/*create database BD_PRUEBABCP;*/

use BD_PRUEBABCP;

INSERT INTO tb_tipo_moneda (cod_tipo_moneda, nombre) VALUES ('1', 'Soles');
INSERT INTO tb_tipo_moneda (cod_tipo_moneda, nombre) VALUES ('2', 'Dolares');

insert into tb_tipo_transaccion values ( 1, "Transferencia");
insert into tb_tipo_transaccion values ( 2, "Pago de servicio");

insert into tb_tipo_notificaciones values ( 1, "Campaña");
insert into tb_tipo_notificaciones values ( 2, "Transaccion");

INSERT INTO tb_clientes values (1, 'Castillo', 'Roa', 'roasgo@hotmail.com', '74917841', 'Gonzalo', 'cibertec');
INSERT INTO tb_clientes values (2, 'Perez', 'Valenzuela', 'rosa10@hotmail.com', '10559134', 'Rosa', '1234');
INSERT INTO tb_clientes values (3, 'Luyo', 'Ayala', 'arturo3000@hotmail.com', '7412354', 'Arturo', 'usil');
INSERT INTO tb_clientes values (4, 'Navarrete', 'Dardanet', 'axel123@outlook.com', '85968448', 'Axel', 'universidad');

INSERT INTO TB_TIPO_CUENTA_BANCARIO (COD_TIPO_CUENTA_BANCARIO, DESCRIPCION) VALUES (NULL, 'CUENTA FREE');
INSERT INTO TB_TIPO_CUENTA_BANCARIO (COD_TIPO_CUENTA_BANCARIO, DESCRIPCION) VALUES (NULL, 'CUENTA SUPER CUENTA');
INSERT INTO TB_TIPO_CUENTA_BANCARIO (COD_TIPO_CUENTA_BANCARIO, DESCRIPCION) VALUES (NULL, 'CUENTA POWER');

INSERT INTO tb_cuentas_bancarias VALUES (1, '00110130020200365896', 5000, '4551708289685452', 1, 1, 1);
INSERT INTO tb_cuentas_bancarias VALUES (2, '00110130020200364785', 2000, '4551708289685452', 1, 1, 3);
INSERT INTO tb_cuentas_bancarias VALUES (3, '0054060020000154855', 5000	, '4551726514875212', 2, 1, 1);
INSERT INTO tb_cuentas_bancarias VALUES (4, '00062530020000154815', 5000, '4551708362514785', 3, 1, 1);
INSERT INTO tb_cuentas_bancarias VALUES (5, '00250430020000426558', 5000, '4551708598547521', 4, 1, 1);


INSERT INTO tb_usuarios VALUES (1, 'Polo', 'Ruiz', '72585966', 'polor@gmail.com');
INSERT INTO tb_usuarios VALUES (2, 'Paredes', 'Mena', '09069745', 'menap@gmail.com');

INSERT INTO tb_campanas (cod_camp, titulo, descripcion, fech_fin, fech_ini, fecha, hora, cod_usu) values (1, 'Cuenta Ganadora','Abre tu cuenta ganadora y participa por el carro del año','2000-07-07','2000-07-07','2000-07-07','7:00',1);

INSERT INTO CAMPANA_CLIENTE (COD_CAMP, COD_CLI, LEIDO) VALUES (1,1,FALSE);

INSERT INTO TB_ESTADO_TRANSACCION (COD_ESTADO_TRANSACCION, DESCRIPCION) VALUES (NULL, 'en proceso');
INSERT INTO TB_ESTADO_TRANSACCION (COD_ESTADO_TRANSACCION, DESCRIPCION) VALUES (NULL, 'finalizada con exito');
INSERT INTO TB_ESTADO_TRANSACCION (COD_ESTADO_TRANSACCION, DESCRIPCION) VALUES (NULL, 'finalizada con problemas');
INSERT INTO TB_ESTADO_TRANSACCION (COD_ESTADO_TRANSACCION, DESCRIPCION) VALUES (NULL, 'cancelada');


INSERT INTO TB_TIPO_ERROR_TRANSACCION (COD_TIPO_ERROR_TRANSACCION, DESCRIPCION) VALUES (NULL, 'ERROR EN LA CONEXION');
INSERT INTO TB_TIPO_ERROR_TRANSACCION (COD_TIPO_ERROR_TRANSACCION, DESCRIPCION) VALUES (NULL, 'ERROR DESCONOCIDO');
INSERT INTO TB_TIPO_ERROR_TRANSACCION (COD_TIPO_ERROR_TRANSACCION, DESCRIPCION) VALUES (NULL, 'ERROR INTERNO');
INSERT INTO TB_TIPO_ERROR_TRANSACCION (COD_TIPO_ERROR_TRANSACCION, DESCRIPCION) VALUES (NULL, 'ERROR SIN FONDOS');

INSERT INTO TB_TRANSACCIONES (COD_TRANSACCION, COD_DESTINO_CUENTA, DESCRIPCION, FECHA, HORA, LEIDO, SALARIO, COD_CUENTA, COD_ESTADO_TRANSACCION, COD_TIPO_TRANSACCION) VALUES ( 1, 3, 'Esta es una descripcion de prueba', '2020-12-02', '12:00',false, 500.00, 1, 2, 1);
INSERT INTO TB_TRANSACCIONES (COD_TRANSACCION, COD_DESTINO_CUENTA, DESCRIPCION, FECHA, HORA, LEIDO, SALARIO, COD_CUENTA, COD_ESTADO_TRANSACCION, COD_TIPO_TRANSACCION) VALUES ( 2, 1, 'Esta es una descripcion de prueba', '2020-12-02', '10:00',false, 450.00, 3, 2, 1);
INSERT INTO TB_TRANSACCIONES (COD_TRANSACCION, COD_DESTINO_CUENTA, DESCRIPCION, FECHA, HORA, LEIDO, SALARIO, COD_CUENTA, COD_ESTADO_TRANSACCION, COD_TIPO_TRANSACCION) VALUES ( 3, 4, 'Esta es una descripcion de prueba', '2020-12-02', '10:00',false, 50.00, 2, 2, 1);
INSERT INTO TB_TRANSACCIONES (COD_TRANSACCION, COD_DESTINO_CUENTA, DESCRIPCION, FECHA, HORA, LEIDO, SALARIO, COD_CUENTA, COD_ESTADO_TRANSACCION, COD_TIPO_TRANSACCION) VALUES ( 4, 3, 'Esta es una descripcion de prueba', '2020-12-02', '11:00',false, 620.00, 4, 2, 1);
INSERT INTO TB_TRANSACCIONES (COD_TRANSACCION, COD_DESTINO_CUENTA, DESCRIPCION, FECHA, HORA, LEIDO, SALARIO, COD_CUENTA, COD_ESTADO_TRANSACCION, COD_TIPO_TRANSACCION) VALUES ( 5, 2, 'Esta es una descripcion de prueba', '2020-12-02', '13:00',false, 70.00, 3, 2, 1);
INSERT INTO TB_TRANSACCIONES (COD_TRANSACCION, COD_DESTINO_CUENTA, DESCRIPCION, FECHA, HORA, LEIDO, SALARIO, COD_CUENTA, COD_ESTADO_TRANSACCION, COD_TIPO_TRANSACCION) VALUES ( 6, 3, 'Esta es una descripcion de prueba', '2020-12-02', '14:00',false, 80.00, 2, 2, 1);

insert into tb_notificaciones values ( 1, 'Esta es otra descripcion de prueba', 0, '2020-12-12', '15:00', 'Transferencia realizada con exito', 2);
insert into tb_notificaciones values ( 2, 'Esta es otra descripcion de prueba', 0, '2020-12-12', '15:00', 'Transferencia realizada con exito', 2);
insert into tb_notificaciones values ( 3, 'Esta es otra descripcion de prueba', 0, '2020-12-12', '15:00', 'Transferencia realizada con exito', 2);
insert into tb_notificaciones values ( 4, 'Esta es otra descripcion de prueba', 0, '2020-12-12', '15:00', 'Transferencia realizada con exito', 2);
insert into tb_notificaciones values ( 5, 'Esta es otra descripcion de prueba', 0, '2020-12-12', '15:00', 'Transferencia realizada con exito', 2);

insert into tb_destino_notificaciones values ( 1, 1 );
insert into tb_destino_notificaciones values ( 2, 2 );

insert into tb_destino_notificaciones_clientes values( 1, 1 );
insert into tb_destino_notificaciones_clientes values( 1, 2 );
insert into tb_destino_notificaciones_clientes values( 2, 1 );
insert into tb_destino_notificaciones_clientes values( 2, 2 );