create database SSER_v5 default character set utf8mb4;
use SSER_v5;

create table Cliente
(
idCliente int primary key not null,
nombres varchar (45) not null,
apellidos varchar (45) not null,
cedula bigint not null,
telefono bigint not null,
direccion varchar (45) not null,
correo varchar (45) not null
);

create table Cargo
(
idCargo int primary key not null,
nombre varchar (45) not null
);

create table Empleado
(
idEmpleado int primary key not null,
nombres varchar (45) not null,
apellidos varchar (45) not null,
cedula bigint not null,
telefono bigint not null,
direccion varchar (45) not null,
correo varchar (45) not null,
salario bigint not null,
cargo int not null,
constraint empleado_cargo_fk foreign key (cargo) references Cargo (idCargo)
);

create table Equipo
(
idEquipo int primary key not null,
tipo varchar (45) not null,
marca varchar (45) not null,
modelo varchar (45) not null,
numero_serial bigint not null
);

create table OrdenR
(
idOrdenR int primary key not null auto_increment,
fecha_hora timestamp not null default current_timestamp,
estado varchar (45) not null,
tipo_servicio varchar (45) not null,
observacion varchar (200) not null,
cliente int not null,
equipo int not null,
empleado int not null,
constraint ordenR_cliente_fk foreign key (cliente) references Cliente (idCliente),
constraint ordenR_equipo_fk foreign key (equipo) references Equipo (idEquipo),
constraint ordenR_emppleado_fk foreign key (empleado) references Empleado (idEmpleado)
);

create table Accesorio
(
idAccesorio int primary key not null auto_increment,
nombre varchar (45) not null
);

create table Empresa
(
idEmpresa int primary key not null auto_increment,
nombre varchar (45) not null,
nit int not null
);

create table Repuesto
(
idRepuesto int primary key not null auto_increment,
nombre varchar (45) not null,
referencia varchar (45) not null,
empresa int not null,
constraint repuesto_empresa_fk foreign key (empresa) references Empresa (idEmpresa) 
);

create table OrdenR_Accesorio
(
idOrdenR int not null,
idAccesorio int not null,
primary key (idOrdenR, idAccesorio),
constraint oya_accesorio_fk foreign key (idOrdenR) references Accesorio (idAccesorio),
constraint oya_ordenR_fk foreign key (idAccesorio) references OrdenR (idOrdenR)
);

create table OrdenR_Repuesto
(
idOrdenR int not null,
idRepuesto int not null,
primary key (idOrdenR, idRepuesto),
constraint oyr_repuesto_fk foreign key (idOrdenR) references Repuesto (idRepuesto),
constraint oyr_ordenR_fk foreign key (idRepuesto) references OrdenR (idOrdenR)
);
# aqui se se hace el registro del cargo de "tecnico".
insert into cargo values(901, "Tecnico");

# aqui se registra dos empleados con el cargo de tecnico.
insert into empleado values (801, "Armando", "Gutierrez", 1023456500, 3203302345, "cll 30 # 4-70", "asd123@gmail.com", 270000, 901);
insert into empleado values (802, "Gregory", "House", 114234542, 3217587428, "cll 5 # 14-05", "fgt543@gmail.com", 80000, 901);
insert into empleado values (803, "Daniel", "Hernandez", 82345532, 3181278699, "cra 64 # 72-35", "cvf76f@hotmail.com", 150000, 901); 
insert into empleado values (804, "Wilmer", "Ortiz", 90335768, 3214345536, "diag 3 # 10-3a", "will342@hotmail.com", 102000, 901);
insert into empleado values (805, "Nicolas", "Alvarez", 1110345654, 3194039891, "cra 34 # 76-56d", "oz454@gmail.com", 189000, 901);

insert into cliente values (1,"Fernando","Ordoñez", 55555555, 3133341333, "cra 47 #29c-71sur", "fercho24lonewolf@hotmail.com");
insert into cliente values (2,"Yisela","Hernandez", 3333333333, 3152535677, "cll 29 #", "yiahernandez@gnail.com");
insert into cliente values (3,"Laura","Giraldo", 222222222222, 3223462778, "cra 45 #", "laugi3345@gmail.com");
insert into cliente values (4,"Laura","Valero", 111111111111, 3184341299, "cll 12 #", "lvale11@hotmail.com");
insert into cliente values (5,"Ricardo","Quevedo", 666666666666, 3164564121, "cll 62 #", "ricad34@hormail.com");

insert into equipo values (1, "TV","LG","tv50s", 22343323423423);
insert into equipo values (2, "DVD","Sony","dvd20rs", 123664545456454);
insert into equipo values (3, "Eq de Sonido","Panasonic","wdesd-330", 34222344677767);
insert into equipo values (4, "DVD","Challenger","dvd3sq", 5657856343478);
insert into equipo values (5, "TV","Sony","tv65ak", 124095049690565);

insert into ordenr (estado, tipo_servicio, observacion, cliente, equipo, empleado) values("Pendiente","Garantia de fabrica","No enciende",1,2,804);
insert into ordenr (estado, tipo_servicio, observacion, cliente, equipo, empleado) values("Reparado","Particular","No tiene audio, golpe al lado izquierdo del equipo",2,3,801);
insert into ordenr (estado, tipo_servicio, observacion, cliente, equipo, empleado) values("Control de calidad","Garantia de fabrica","No lee CD, rayones en la de arriba del DVD",3,4,805);
insert into ordenr (estado, tipo_servicio, observacion, cliente, equipo, empleado) values("No reparado","Garantia de fabrica","Linea vertical en la pantalla",4,5,801);
insert into ordenr (estado, tipo_servicio, observacion, cliente, equipo, empleado) values("Por reparar","Garantia particular","Sin audio",5,1,804);


