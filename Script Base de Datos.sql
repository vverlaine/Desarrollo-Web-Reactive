/************************************************************************************
					CREACION DE BASE DE DATOS Y TABLAS
************************************************************************************/
DROP DATABASE IF EXISTS cine;
CREATE DATABASE IF NOT EXISTS cine;

use cine;

create table lenguaje(
id int primary key auto_increment
,lenguaje varchar(25)
,observacion varchar(255)
);

create table clasificacion_pelicula(
id int primary key auto_increment
,clasificacion varchar(25)
,observacion varchar(255)
);

create table genero(
id int primary key auto_increment
,genero varchar(25)
,observacion varchar(255)
);

create table subtitulos(
id int primary key auto_increment
,subtitulo varchar(25)
,observaciones varchar(255)
);

create table pelicula(
id int primary key auto_increment
,titulo_original varchar(50)
,id_genero int
,id_lenguaje int
,id_subtitulo int
,fecha_produccion date
,fecha_estreno date
,url_pelicula varchar(255)
,duracion time
,id_clasificacion int
,resumen varchar(255)

,foreign key (id_genero) references genero (id)
on delete cascade
on update cascade

,foreign key (id_lenguaje) references lenguaje (id)
on delete cascade
on update cascade

,foreign key (id_subtitulo) references subtitulos (id)
on delete cascade
on update cascade

,foreign key (id_clasificacion) references clasificacion_pelicula (id)
on delete cascade
on update cascade

);

create table reparto(
id int primary key auto_increment
,nombre varchar(25)
,apellido varchar(25)
,id_pelicula int

,foreign key (id_pelicula) references pelicula (id)
on delete cascade
on update cascade
);

create table tipo_reaccion(
id int primary key auto_increment
,tipo_reaccion varchar(25)
);


create table opinion_pelicula(
id_registro int primary key auto_increment
,id_pelicula int
,correo varchar(50)
,fecha_registro datetime
,comentarios varchar(255)
,id_tipo_reaccion int

,foreign key (id_pelicula) references pelicula (id)
on delete cascade
on update cascade

,foreign key (id_tipo_reaccion) references tipo_reaccion (id)
on delete cascade
on update cascade
);

/************************************************************************************
								INSERT DE DATOS
************************************************************************************/

insert into clasificacion_pelicula (clasificacion, observacion)
values ('3+','Película apta para menores de 3 años');
insert into clasificacion_pelicula (clasificacion, observacion)
values ('13+','Película apta para menores de 13 años');

insert into genero (genero, observacion)
values ('Infantil', 'Película infantil');
insert into genero (genero, observacion)
values ('Comedia', 'Película de comedia');

insert into lenguaje (lenguaje, observacion)
values ('Español latinoamericano','Idioma español');
insert into lenguaje (lenguaje, observacion)
values ('Ingles','Idioma ingles');

insert into tipo_reaccion (tipo_reaccion)
values ('Like');
insert into tipo_reaccion (tipo_reaccion)
values ('Not Like');

insert into subtitulos (subtitulo, observaciones)
values ('Español','Español latinoamericano');
insert into subtitulos (subtitulo, observaciones)
values ('Ingles','ingles');

insert into pelicula (titulo_original, id_genero, id_lenguaje, id_subtitulo, fecha_produccion, fecha_estreno, url_pelicula, duracion, id_clasificacion, resumen)
values ('Toy Story',1,1,1,'2019-08-05','2019-12-12','url pelicula','1:35:00',1,'Resumen Pelicula');
insert into pelicula (titulo_original, id_genero, id_lenguaje, id_subtitulo, fecha_produccion, fecha_estreno, url_pelicula, duracion, id_clasificacion, resumen)
values ('Jexi',1,1,1,'2019-08-05','2019-12-12','url pelicula','1:35:00',1,'Resumen Pelicula');

insert into reparto (nombre, apellido, id_pelicula)
values ('Woody',null,1);
insert into reparto (nombre, apellido, id_pelicula)
values ('Frank','Gen',1);

insert into opinion_pelicula(id_pelicula, correo, fecha_registro, comentarios, id_tipo_reaccion)
values (1,'correo.prueba@gmail.com','2020-08-12','Me gusto la pelicula',1);
insert into opinion_pelicula(id_pelicula, correo, fecha_registro, comentarios, id_tipo_reaccion)
values (2,'correo.prueba2@gmail.com','2020-08-12','Me gusto la pelicula',2);

/************************************************************************************
								CREACION DE VISTAS
************************************************************************************/

create view vista_pelicula
as
select
	*
from
(select
	a.id
    ,a.titulo_original
    ,b.genero
    ,c.lenguaje
    ,d.subtitulo
    ,a.fecha_produccion
    ,a.fecha_estreno
    ,a.url_pelicula
    ,a.duracion
    ,e.clasificacion
    ,a.resumen

from
	pelicula a
    inner join genero b
		on b.id = a.id_genero

	inner join lenguaje c
		on c.id = a.id_lenguaje

	inner join subtitulos d
		on d.id = a.id_subtitulo

	inner join clasificacion_pelicula e
		on e.id = a.id_clasificacion
) as t
;

create view vista_reaccion
as
select
	*
from
(select
	a.id_registro as id
    ,c.titulo_original as pelicula
    ,a.correo
    ,a.fecha_registro
    ,a.comentarios
    ,b.tipo_reaccion

from
	opinion_pelicula a
    inner join tipo_reaccion b
		on a.id_tipo_reaccion = b.id

	inner join pelicula c
		on c.id = a.id_pelicula
) as t
;